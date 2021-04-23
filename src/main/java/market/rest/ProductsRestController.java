package market.rest;

import market.domain.Product;
import market.dto.ProductDTO;
import market.dto.assembler.ProductDtoAssembler;
import market.exception.UnknownEntityException;
import market.service.ProductService;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "rest/products")
@ExposesResourceFor(ProductDTO.class)
public class ProductsRestController {

	private final ProductService productService;
	private final ProductDtoAssembler productAssembler = new ProductDtoAssembler();

	public ProductsRestController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Все существующие товары, отсортированные по id.
	 */
	@GetMapping
	public Collection<ProductDTO> getProducts() {
		return productService.findAll().stream()
			.sorted(Comparator.comparing(Product::getId))
			.map(productAssembler::toModelWithSelfLink)
			.collect(Collectors.toList());
	}

	/**
	 * Просмотр одного продукта
	 *
	 * @return товар с указанным id
	 * @throws UnknownEntityException если товара с указанным id не существует
	 */
	@GetMapping(value = "/{productId}")
	public ProductDTO getProduct(@PathVariable long productId) {
		return productService.findById(productId)
			.map(productAssembler::toModelWithListLink)
			.orElseThrow(() -> new UnknownEntityException(ProductDTO.class, productId));
	}
}
