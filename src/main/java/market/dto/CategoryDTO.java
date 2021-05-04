package market.dto;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class CategoryDTO extends RepresentationModel<CategoryDTO> {

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
		CategoryDTO categoryDTO = (CategoryDTO) o;
		return Objects.equals(id, categoryDTO.id) &&
			Objects.equals(title, categoryDTO.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public String toString() {
		return "CategoryDTO{" +
			"id=" + id +
			", title='" + title + '\'' +
			'}';
	}
}
