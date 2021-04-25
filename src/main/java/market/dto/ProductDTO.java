package market.dto;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class ProductDTO extends RepresentationModel<ProductDTO> {

	private Long productId;
	private String manufacturer;
	private String category;

	@NotEmpty
	@Pattern(regexp = "^[^#$%^&*()']*$")
	private String name;

	@NotNull
	private Double price;
	private String description;
	private boolean available;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {return category;}

	public void setCategory(String category) {this.category = category;	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
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
		ProductDTO that = (ProductDTO) o;
		return available == that.available &&
			Objects.equals(productId, that.productId) &&
			Objects.equals(manufacturer, that.manufacturer) &&
			Objects.equals(name, that.name) &&
			Objects.equals(price, that.price) &&
			Objects.equals(category, that.category) &&
			Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, manufacturer, name, price, category, description, available);
	}

}
