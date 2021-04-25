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
			.setTitle("null category")
			.build();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	@NotEmpty
	@Pattern(regexp = "^[^#$%^&*()']*$")
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
		Category category = (Category) o;
		return Objects.equals(id, category.id) &&
			Objects.equals(title, category.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	public static class Builder {
		private Long id;
		private String title;

		public Builder() {
		}

		public Builder(Category category) {
			id = category.id;
			title = category.title;
		}

		public Category build() {
			Category category = new Category();
			category.id = id;
			category.title = title;
			return category;
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}
	}
}
