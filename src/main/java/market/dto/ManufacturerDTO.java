package market.dto;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class ManufacturerDTO extends RepresentationModel<ManufacturerDTO> {

	private Long id;
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ManufacturerDTO manufacturerDTO = (ManufacturerDTO) o;
		return Objects.equals(id, manufacturerDTO.id) &&
			Objects.equals(title, manufacturerDTO.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public String toString() {
		return "ManufacturerDTO{" +
			"id=" + id +
			", title='" + title + '\'' +
			'}';
	}
}
