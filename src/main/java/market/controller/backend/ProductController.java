package market.controller.backend;

import market.domain.Manufacturer;
import market.domain.Product;
import market.dto.ManufacturerDTO;
import market.dto.ProductDTO;
import market.dto.assembler.ManufacturerDtoAssembler;
import market.dto.assembler.ProductDtoAssembler;
import market.exception.UnknownEntityException;
import market.properties.PaginationProperties;
import market.service.ManufacturerService;
import market.service.ProductService;
import market.sorting.ISorter;
import market.sorting.ProductBackendSorting;
import market.sorting.SortingValuesDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Controller
@RequestMapping("/admin/products")
@Secured({"ROLE_STAFF", "ROLE_ADMIN"})
public class ProductController {
	private static final Logger log = LogManager.getLogger(ProductController.class);

	private static final String PRODUCTS_BASE = "admin/products";
	private static final String PRODUCTS_EDIT = PRODUCTS_BASE + "/edit";
	private static final String PRODUCTS_NEW = PRODUCTS_BASE + "/new";

	private final ProductService productService;
	private final ManufacturerService manufacturerService;
	private final ISorter<ProductDTO> productBackendSorting;
	private final ProductDtoAssembler productDtoAssembler = new ProductDtoAssembler();
	private final ManufacturerDtoAssembler manufacturerDtoAssembler = new ManufacturerDtoAssembler();

	public ProductController(ProductService productService, ManufacturerService manufacturerService,
		PaginationProperties paginationProperties)
	{
		this.productService = productService;
		this.manufacturerService = manufacturerService;
		productBackendSorting = new ProductBackendSorting(paginationProperties.getBackendProduct());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getProducts(
		SortingValuesDTO sortingValues,
		@RequestParam(value = "dist", required = false, defaultValue = "0") long manufacturerId,
		Model model
	) {
		PageRequest request = productBackendSorting.updateSorting(sortingValues);
		Page<Product> pagedProducts;
		if (manufacturerId == 0) {
			pagedProducts = productService.findAll(request);
		} else {
			Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
			pagedProducts = productService.findByManufacturer(manufacturer, request);
			model.addAttribute("currentManufacturerTitle", manufacturer.getTitle());
		}
		productBackendSorting.prepareModel(model, pagedProducts.map(productDtoAssembler::toModel));

		List<Manufacturer> manufacturers = manufacturerService.findAll();
		List<ManufacturerDTO> manufacturersDto = manufacturers.stream()
			.map(manufacturerDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("manufacturers", manufacturersDto);

		Map<String, String> mf = manufacturers.stream()
			.collect(toMap(Manufacturer::getTitle, d -> d.getTitle()));
		model.addAttribute("mf", mf);

		return PRODUCTS_BASE;
	}

	//Creating new product

	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String newProduct(Model model) {
		List<ManufacturerDTO> manufacturersDto = manufacturerService.findAll().stream()
			.map(manufacturerDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("manufacturers", manufacturersDto);
		model.addAttribute("product", productDtoAssembler.toModel(new Product()));
		return PRODUCTS_NEW;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String postProduct(
		@Valid ProductDTO product, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return "redirect:/" + PRODUCTS_NEW;

		Product newProduct = productDtoAssembler.dtoDomain(product);
		productService.create(newProduct, product.getManufacturer());
		return "redirect:/" + PRODUCTS_BASE;
	}

	// Updating product

	@RequestMapping(method = RequestMethod.GET, value = "/{productId}/edit")
	public String editProduct(
		@PathVariable long productId, Model model
	) {
		Optional<Product> productOptional = productService.findById(productId);
		if (!productOptional.isPresent())
			return "redirect:/" + PRODUCTS_BASE;

		List<ManufacturerDTO> manufacturersDto = manufacturerService.findAll().stream()
			.map(manufacturerDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("manufacturers", manufacturersDto);
		model.addAttribute("product", productDtoAssembler.toModel(productOptional.get()));
		return PRODUCTS_EDIT;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{productId}/edit")
	public String putProduct(
		@PathVariable long productId,
		@Valid ProductDTO product, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return "redirect:/" + PRODUCTS_EDIT;

		Product changedProduct = productDtoAssembler.dtoDomain(product);
		try {
			productService.update(productId, changedProduct, product.getManufacturer());
			return "redirect:/" + PRODUCTS_BASE;
		} catch (UnknownEntityException e) {
			log.warn(e.getMessage());
			return "redirect:/" + PRODUCTS_EDIT;
		}
	}

	// Removing product

	@RequestMapping(method = RequestMethod.POST, value = "/{productId}/delete")
	public String deleteProduct(@PathVariable long productId) {
		productService.delete(productId);
		return "redirect:/" + PRODUCTS_BASE;
	}
}
