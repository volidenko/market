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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = -5637368176838137416L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private Long id;



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id", nullable = false)
	private Manufacturer manufacturer;

	@Column(name = "name", nullable = false)
	@NotEmpty
	@Pattern(regexp = "^[^#$%^&*()']*$")
	private String name;

	@Column(name = "price", nullable = false)
	@NotNull
	private Double price;

	@Column(name = "description")
	private String description;

	@Column(name = "available", nullable = false)
	private boolean available = true;

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

	public @NotNull Double getPrice() {
		return price;
	}

	public void setPrice(@NotNull Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {return category;	}

	public void setCategory(Category category) {this.category = category;}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return id == product.id &&
			available == product.available &&
				Objects.equals(category, product.category) &&
			Objects.equals(manufacturer, product.manufacturer) &&
			Objects.equals(name, product.name) &&
			Objects.equals(price, product.price) &&
			Objects.equals(description, product.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, available, category, manufacturer, description);
	}

	public static class Builder {
		private Long id;
		private String name;
		private Double price;
		private boolean available = true;
		private  Category category;
		private Manufacturer manufacturer;
		private String description;

		public Builder() {
		}

		public Builder(Product product) {
			id = product.id;
			name = product.name;
			price = product.price;
			available = product.available;
			category=product.category;
			manufacturer = product.manufacturer;
			description = product.description;
		}

		public Product build() {
			Product product = new Product();
			product.id = id;
			product.category=category;
			product.manufacturer = manufacturer;
			product.name = name;
			product.price = price;
			product.description = description;
			product.available = available;
			return product;
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setManufacturer(Manufacturer manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}
		public Builder setCategory(Category category) {
			this.category = category;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setPrice(@NotNull Double price) {
			this.price = price;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setAvailable(boolean available) {
			this.available = available;
			return this;
		}
	}
}
