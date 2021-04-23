package market.dto.assembler;

import market.controller.backend.CategoryController;
import market.domain.Category;
import market.dto.CategoryDTO;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.List;

public class CategoryDtoAssembler extends RepresentationModelAssemblerSupport<Category, CategoryDTO> {

	public CategoryDtoAssembler() {
		super(CategoryController.class, CategoryDTO.class);
	}

	@Override
	public CategoryDTO toModel(Category category) {
		CategoryDTO dto = instantiateModel(category);
		dto.setId(category.getId());
		dto.setName(category.getName());
		dto.setSubtitle(category.getSubtitle());
		dto.setColor(category.getColor());
		dto.setDescription(category.getDescription());
		return dto;
	}

	public CategoryDTO[] toDtoArray(List<Category> items) {
		return toCollectionModel(items).getContent().toArray(new CategoryDTO[items.size()]);
	}

	public Category toDomain(CategoryDTO dto) {
		return new Category.Builder()
			.setId(dto.getId())
			.setName(dto.getName())
			.setSubtitle(dto.getSubtitle())
			.setColor(dto.getColor())
			.setDescription(dto.getDescription())
			.build();
	}
}
