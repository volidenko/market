package market.dto.assembler;

import market.controller.backend.ManufacturerController;
import market.domain.Manufacturer;
import market.dto.ManufacturerDTO;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.List;

public class ManufacturerDtoAssembler extends RepresentationModelAssemblerSupport<Manufacturer, ManufacturerDTO> {

	public ManufacturerDtoAssembler() {
		super(ManufacturerController.class, ManufacturerDTO.class);
	}

	@Override
	public ManufacturerDTO toModel(Manufacturer manufacturer) {
		ManufacturerDTO dto = instantiateModel(manufacturer);
		dto.setId(manufacturer.getId());
		dto.setTitle(manufacturer.getTitle());
		return dto;
	}

	public ManufacturerDTO[] toDtoArray(List<Manufacturer> items) {
		return toCollectionModel(items).getContent().toArray(new ManufacturerDTO[items.size()]);
	}

	public Manufacturer toDomain(ManufacturerDTO dto) {
		return new Manufacturer.Builder()
			.setTitle(dto.getTitle())
			.build();
	}
}
