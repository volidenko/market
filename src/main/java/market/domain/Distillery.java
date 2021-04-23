package market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "distillery")
public class Distillery implements Serializable {
	private static final long serialVersionUID = -1491932412037172392L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	@NotEmpty
	@Pattern(regexp = "^[^#$%^*()']*$")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id", nullable = false)
	private Category category;

	@Column(name = "description")
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Distillery that = (Distillery) o;
		return Objects.equals(id, that.id) &&
			Objects.equals(title, that.title) &&
			Objects.equals(category, that.category) &&
			Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, category, description);
	}

	public static class Builder {
		private Long id;
		private String title;
		private Category category;
		private String description;

		public Builder() {
		}

		public Builder(Distillery source) {
			id = source.id;
			title = source.title;
			category = source.category;
			description = source.description;
		}

		public Distillery build() {
			Distillery distillery = new Distillery();
			distillery.id = id;
			distillery.title = title;
			distillery.category = category;
			distillery.description = description;
			return distillery;
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setRegion(Category category) {
			this.category = category;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
	}
}
