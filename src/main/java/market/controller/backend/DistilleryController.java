package market.controller.backend;

import market.domain.Manufacturer;
import market.dto.ManufacturerDTO;
import market.dto.CategoryDTO;
import market.dto.assembler.ManufacturerDtoAssembler;
import market.dto.assembler.CategoryDtoAssembler;
import market.service.ManufacturerService;
import market.service.CategoryService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/admin/distilleries")
@Secured({"ROLE_STAFF", "ROLE_ADMIN"})
public class DistilleryController {
	private static final String DISTILLERIES_BASE = "admin/distilleries";
	private static final String DISTILLERIES_NEW = DISTILLERIES_BASE + "/new";
	private static final String DISTILLERIES_EDIT = DISTILLERIES_BASE + "/edit";

	private final ManufacturerService manufacturerService;
	private final CategoryService categoryService;
	private final CategoryDtoAssembler categoryDtoAssembler = new CategoryDtoAssembler();
	private final ManufacturerDtoAssembler manufacturerDtoAssembler = new ManufacturerDtoAssembler();

	public DistilleryController(ManufacturerService manufacturerService, CategoryService categoryService) {
		this.manufacturerService = manufacturerService;
		this.categoryService = categoryService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String allDistilleries(Model model) {
		List<ManufacturerDTO> distilleriesDto = manufacturerService.findAll().stream()
			.map(manufacturerDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("distilleries", distilleriesDto);
		return DISTILLERIES_BASE;
	}

	//------------------------------------------------ Creating new distillery

	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String newDistillery(Model model) {
		List<CategoryDTO> categoriesDto = categoryService.findAll().stream()
			.map(categoryDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("categories", categoriesDto);
		model.addAttribute("distillery", new Manufacturer());
		return DISTILLERIES_NEW;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String postDistillery(
			@Valid ManufacturerDTO manufacturerDto, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return DISTILLERIES_NEW;

		Manufacturer newManufacturer = manufacturerDtoAssembler.toDomain(manufacturerDto);
		manufacturerService.create(newManufacturer, manufacturerDto.getRegion());
		return "redirect:/" + DISTILLERIES_BASE;
	}

	//------------------------------------------------ Changing distillery

	@RequestMapping(method = RequestMethod.GET, value = "/{distilleryId}/edit")
	public String editDistillery(
		@PathVariable long distilleryId, Model model
	) {
		List<CategoryDTO> regionsDto = categoryService.findAll().stream()
			.map(categoryDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("regions", regionsDto);

		Manufacturer manufacturer = manufacturerService.findById(distilleryId);
		model.addAttribute("distillery", manufacturerDtoAssembler.toModel(manufacturer));

		return DISTILLERIES_EDIT;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{distilleryId}/edit")
	public String putDistillery(
			@PathVariable long distilleryId,
			@Valid ManufacturerDTO manufacturerDto, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return DISTILLERIES_EDIT;

		Manufacturer changedManufacturer = manufacturerDtoAssembler.toDomain(manufacturerDto);
		manufacturerService.update(distilleryId, changedManufacturer, manufacturerDto.getRegion());
		return "redirect:/" + DISTILLERIES_BASE;
	}

	//------------------------------------------------------ Removing distillery

	@RequestMapping(method = RequestMethod.POST, value = "/{distilleryId}/delete")
	public String deleteDistillery(@PathVariable long distilleryId) {
		manufacturerService.delete(distilleryId);
		return "redirect:/" + DISTILLERIES_BASE;
	}
}
