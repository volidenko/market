package market.controller.frontend;

import market.domain.Category;
import market.dto.CategoryDTO;
import market.dto.assembler.CategoryDtoAssembler;
import market.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Frontend root pages controller.
 */
@Controller
public class FrontendController {
	private final CategoryService categoryService;
	private final CategoryDtoAssembler categoryDTOAssembler = new CategoryDtoAssembler();

	public FrontendController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Title page.
	 */
	@RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		List<CategoryDTO> categoriesDto = categoryService.findAll().stream()
			.map(categoryDTOAssembler::toModel)
			.collect(toList());
		model.addAttribute("categories", categoriesDto);
		model.addAttribute("selectedCategory", Category.NULL);
		return "index";
	}

	/**
	 * Login page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * Implementation description page.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/inside")
	public String whatsInside() {
		return "inside";
	}

	/**
	 * REST description page.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/rest-api")
	public String restApi() {
		return "rest";
	}
}
