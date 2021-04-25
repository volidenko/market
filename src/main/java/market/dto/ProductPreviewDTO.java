package market.dto;

import org.springframework.hateoas.RepresentationModel;

/**
 * Адаптер товара.
 */
public class ProductPreviewDTO extends RepresentationModel<ProductPreviewDTO> {

	private long productId;
	private String category;
	private String manufacturer;
	private String name;
	private Double price;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPreviewDTO{" +
			"productId=" + productId +
			", category='" + category + '\'' +
			", manufacturer='" + manufacturer + '\'' +
			", name='" + name + '\'' +
			", price=" + price +
			'}';
	}
}
