package market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = -1491932412037172392L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	@NotEmpty
	@Pattern(regexp = "^[^#$%^*()']*$")
	private String title;

//	@ManyToOne(fetch = FetchType.EAGER)


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
		Manufacturer that = (Manufacturer) o;
		return Objects.equals(id, that.id) &&
			Objects.equals(title, that.title);
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

		public Builder(Manufacturer source) {
			id = source.id;
			title = source.title;
		}

		public Manufacturer build() {
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.id = id;
			manufacturer.title = title;
			return manufacturer;
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
