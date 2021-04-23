package market.dto;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class CategoryDTO extends RepresentationModel<CategoryDTO> {

	private Long id;
	private String name;
	private String subtitle;
	private String description;
	private String color;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CategoryDTO categoryDTO = (CategoryDTO) o;
		return Objects.equals(id, categoryDTO.id) &&
			Objects.equals(name, categoryDTO.name) &&
			Objects.equals(subtitle, categoryDTO.subtitle) &&
			Objects.equals(description, categoryDTO.description) &&
			Objects.equals(color, categoryDTO.color);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, subtitle, description, color);
	}

	@Override
	public String toString() {
		return "RegionDTO{" +
			"id=" + id +
			", name='" + name + '\'' +
			", subtitle='" + subtitle + '\'' +
			", description='" + description + '\'' +
			", color='" + color + '\'' +
			'}';
	}
}
