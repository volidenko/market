package market.controller.frontend;

import market.domain.Manufacturer;
import market.domain.Product;
import market.domain.Category;
import market.dto.ManufacturerDTO;
import market.dto.ProductDTO;
import market.dto.CategoryDTO;
import market.dto.assembler.ManufacturerDtoAssembler;
import market.dto.assembler.ProductDtoAssembler;
import market.dto.assembler.CategoryDtoAssembler;
import market.service.ManufacturerService;
import market.service.ProductService;
import market.service.CategoryService;
import market.sorting.ISorter;
import market.sorting.ProductSorting;
import market.sorting.SortingValuesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Category products showcase.
 */
@Controller
@RequestMapping("/categories")
public class ShowcaseController {
	private static final String CATEGORIES_BASE = "categories";

	private final CategoryService categoryService;
	private final ProductService productService;
	private final ManufacturerService manufacturerService;
	private final ISorter<ProductDTO> productSorting = new ProductSorting();
	private final ProductDtoAssembler productAssembler = new ProductDtoAssembler();
	private final CategoryDtoAssembler categoryDTOAssembler = new CategoryDtoAssembler();
	private final ManufacturerDtoAssembler manufacturerDTOAssembler = new ManufacturerDtoAssembler();

	public ShowcaseController(CategoryService categoryService, ProductService productService, ManufacturerService manufacturerService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.manufacturerService = manufacturerService;
	}

	/**
	 * Category products page. Filtering by manufacturer and sorting.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{categoryId}")
	public String getCategoryProducts(
		@PathVariable long categoryId,
		SortingValuesDTO sortingValues,
		@RequestParam(value = "dist", required = false, defaultValue = "0") Long manufacturerId,
		Model model
	) {
		Category category = categoryService.findOne(categoryId);

		PageRequest request = productSorting.updateSorting(sortingValues);
		Page<Product> pagedProducts;
		if (manufacturerId == 0) {
			pagedProducts = productService.findByCategory(category, request);
		} else {
			Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
			pagedProducts = productService.findByManufacturer(manufacturer, request);
			model.addAttribute("currentManufacturerTitle", manufacturer.getTitle());
		}
		productSorting.prepareModel(model, pagedProducts.map(productAssembler::toModel));

		List<ManufacturerDTO> manufacturersDto = manufacturerService.findAll().stream()
			.sorted(Comparator.comparing(Manufacturer::getId))
			.map(manufacturerDTOAssembler::toModel)
			.collect(toList());
		model.addAttribute("manufacturers", manufacturersDto);

		List<CategoryDTO> categoriesDto = categoryService.findAll().stream()
			.sorted(Comparator.comparing(Category::getId))
			.map(categoryDTOAssembler::toModel)
			.collect(toList());
		model.addAttribute("categories", categoriesDto);
		model.addAttribute("selectedCategory", categoryDTOAssembler.toModel(category));
		return CATEGORIES_BASE;
	}
}
