package market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	public static final Category NULL;
	private static final long serialVersionUID = 5413261502059862627L;

	static {
		NULL = new Category.Builder()
			.setId(0L)
			.setName("null category")
			.build();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotEmpty
	@Pattern(regexp = "^[^#$%^&*()']*$")
	private String name;

	@Column(name = "subtitle")
	@Pattern(regexp = "^[^#$%^*()']*$")
	private String subtitle;

	@Column(name = "description")
	private String description;

	@Column(name = "color")
	@Pattern(regexp = "^(a-z|A-Z|0-9-)*[^#$%^&*()']*$")
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
		Category category = (Category) o;
		return Objects.equals(id, category.id) &&
			Objects.equals(name, category.name) &&
			Objects.equals(subtitle, category.subtitle) &&
			Objects.equals(description, category.description) &&
			Objects.equals(color, category.color);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, subtitle, description, color);
	}

	public static class Builder {
		private Long id;
		private String name;
		private String subtitle;
		private String description;
		private String color;

		public Builder() {
		}

		public Builder(Category category) {
			id = category.id;
			name = category.name;
			subtitle = category.subtitle;
			description = category.description;
			color = category.color;
		}

		public Category build() {
			Category category = new Category();
			category.id = id;
			category.name = name;
			category.subtitle = subtitle;
			category.description = description;
			category.color = color;
			return category;
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setSubtitle(String subtitle) {
			this.subtitle = subtitle;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setColor(String color) {
			this.color = color;
			return this;
		}
	}
}
