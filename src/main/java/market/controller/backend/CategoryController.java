package market.controller.backend;

import market.domain.Category;
import market.dto.CategoryDTO;
import market.dto.assembler.CategoryDtoAssembler;
import market.service.CategoryService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/admin/category")
@Secured({"ROLE_STAFF", "ROLE_ADMIN"})
public class CategoryController {
	private static final String CATEGORIES_BASE = "admin/category";
	private static final String CATEGORIES_NEW = CATEGORIES_BASE + "/new";
	private static final String CATEGORIES_EDIT = CATEGORIES_BASE + "/edit";

	private final CategoryService categoryService;
	private final CategoryDtoAssembler categoryDTOAssembler = new CategoryDtoAssembler();

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String allCategories(Model model) {
		List<CategoryDTO> categoriesDto = categoryService.findAll().stream()
			.sorted(Comparator.comparing(Category::getId))
			.map(categoryDTOAssembler::toModel)
			.collect(toList());
		model.addAttribute("categories", categoriesDto);
		return CATEGORIES_BASE;
	}

	// Creating new category

	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String newCategory(Model model) {
		model.addAttribute("category", categoryDTOAssembler.toModel(new Category()));
		return CATEGORIES_NEW;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String postCategory(
			@Valid CategoryDTO categoryDto, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return CATEGORIES_NEW;
		Category newCategory = categoryDTOAssembler.toDomain(categoryDto);
		categoryService.create(newCategory);
		return "redirect:/" + CATEGORIES_BASE;
	}

	// Updating category

	@RequestMapping(method = RequestMethod.GET, value = "/{categoryId}/edit")
	public String editCategory(
		@PathVariable long categoryId, Model model
	) {
		Category category = categoryService.findOne(categoryId);
		model.addAttribute("category", categoryDTOAssembler.toModel(category));
		return CATEGORIES_EDIT;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{categoryId}/edit")
	public String putCategory(
			@PathVariable long categoryId,
			@Valid CategoryDTO categoryDto, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return CATEGORIES_EDIT;

		Category changedCategory = categoryDTOAssembler.toDomain(categoryDto);
		categoryService.update(categoryId, changedCategory);
		return "redirect:/" + CATEGORIES_BASE;
	}

	// Deleting category

	@RequestMapping(method = RequestMethod.POST, value = "/{categoryId}/delete")
	public String deleteCategory(@PathVariable long categoryId) {
		categoryService.delete(categoryId);
		return "redirect:/" + CATEGORIES_BASE;
	}
}
