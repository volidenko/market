package market.dto.assembler;

import market.domain.Product;
import market.dto.ProductDTO;
import market.rest.ProductsRestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ProductDtoAssembler extends RepresentationModelAssemblerSupport<Product, ProductDTO> {

	public ProductDtoAssembler() {
		super(ProductsRestController.class, ProductDTO.class);
	}

	@Override
	public ProductDTO toModel(Product product) {
		ProductDTO dto = instantiateModel(product);
		dto.setProductId(product.getId());
		dto.setManufacturer(product.getManufacturer() == null ? null : product.getManufacturer().getTitle());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setDescription(product.getDescription());
		dto.setAvailable(product.isAvailable());
		return dto;
	}

	public ProductDTO toModelWithSelfLink(Product product) {
		ProductDTO dto = toModel(product);
		dto.add(linkTo(methodOn(ProductsRestController.class).getProduct(product.getId())).withRel("self"));
		return dto;
	}

	public ProductDTO toModelWithListLink(Product product) {
		ProductDTO dto = toModel(product);
		dto.add(linkTo(methodOn(ProductsRestController.class).getProducts()).withRel("All products"));
		return dto;
	}

	public PageImpl<ProductDTO> toModel(Page<Product> page) {
		List<ProductDTO> dtoList = page.map(this::toModel).toList();
		return new PageImpl<>(dtoList, page.getPageable(), page.getTotalElements());
	}

	public Product dtoDomain(ProductDTO dto) {
		return new Product.Builder()
			.setName(dto.getName())
			.setPrice(dto.getPrice())
			.setDescription(dto.getDescription())
			.setAvailable(dto.isAvailable())
			.build();
	}
}
