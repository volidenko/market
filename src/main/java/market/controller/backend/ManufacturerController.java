package market.controller.backend;

import market.domain.Manufacturer;
import market.dto.ManufacturerDTO;
import market.dto.assembler.ManufacturerDtoAssembler;
import market.service.ManufacturerService;
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
@RequestMapping("/admin/manufacturers")
@Secured({"ROLE_STAFF", "ROLE_ADMIN"})
public class ManufacturerController {
	private static final String MANUFACTURERS_BASE = "admin/manufacturers";
	private static final String MANUFACTURERS_NEW = MANUFACTURERS_BASE + "/new";
	private static final String MANUFACTURERS_EDIT = MANUFACTURERS_BASE + "/edit";

	private final ManufacturerService manufacturerService;
	private final ManufacturerDtoAssembler manufacturerDtoAssembler = new ManufacturerDtoAssembler();

	public ManufacturerController(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String allManufacturer(Model model) {
		List<ManufacturerDTO> manufacturersDto = manufacturerService.findAll().stream()
			.map(manufacturerDtoAssembler::toModel)
			.collect(toList());
		model.addAttribute("manufacturers", manufacturersDto);
		return MANUFACTURERS_BASE;
	}

	// Creat

	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String newManufacturer(Model model) {
		//model.addAttribute("manufacturer", new Manufacturer());
		model.addAttribute("manufacturer", manufacturerDtoAssembler.toModel(new Manufacturer()));
		return MANUFACTURERS_NEW;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String postManufacturer(
			@Valid ManufacturerDTO manufacturerDto, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return MANUFACTURERS_NEW;

		Manufacturer newManufacturer = manufacturerDtoAssembler.toDomain(manufacturerDto);
		manufacturerService.create(newManufacturer);
		return "redirect:/" + MANUFACTURERS_BASE;
	}

	//Changing

	@RequestMapping(method = RequestMethod.GET, value = "/{manufacturerId}/edit")
	public String editManufacturer(
		@PathVariable long manufacturerId, Model model
	) {
		Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
		model.addAttribute("manufacturer", manufacturerDtoAssembler.toModel(manufacturer));
		return MANUFACTURERS_EDIT;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{manufacturerId}/edit")
	public String putManufacturer(
			@PathVariable long manufacturerId,
			@Valid ManufacturerDTO manufacturerDto, BindingResult bindingResult
	) {
		if (bindingResult.hasErrors())
			return MANUFACTURERS_EDIT;

		Manufacturer changedManufacturer = manufacturerDtoAssembler.toDomain(manufacturerDto);
		manufacturerService.update(manufacturerId, changedManufacturer);
		return "redirect:/" + MANUFACTURERS_BASE;
	}

	// Removing manufacturer

	@RequestMapping(method = RequestMethod.POST, value = "/{manufacturerId}/delete")
	public String deleteManufacturer(@PathVariable long manufacturerId) {
		manufacturerService.delete(manufacturerId);
		return "redirect:/" + MANUFACTURERS_BASE;
	}
}
