package market.service;

import market.domain.Manufacturer;
import market.domain.Product;
import market.domain.Category;
import market.exception.UnknownEntityException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

	/**
	 * @return all the products, sorted by title
	 */
	List<Product> findAll();

	/**
	 * @return all the products, sorted by title and paged
	 */
	Page<Product> findAll(PageRequest request);

	/**
	 * @return all the products of the specified manufacturer, sorted by title
	 */
	Page<Product> findByManufacturer(Manufacturer manufacturer, PageRequest request);

	/**
	 * @return all the products of the specified category, sorted by title
	 */
	Page<Product> findByCategory(Category category, PageRequest request);

	/**
	 * @return all the available products, sorted by title
	 */
	Page<Product> findByAvailability(String available, PageRequest request);

	/**
	 * @return product with the specified id
	 * @throws UnknownEntityException if product does not exist
	 */
	Product getProduct(long productId);

	/**
	 * @return product with the specified id
	 */
	Optional<Product> findById(long productId);

	/**
	 * Creates new product.
	 */
	void create(Product product, String manufacturerTitle);

	/**
	 * Updates existing product.
	 *
	 * @throws UnknownEntityException if product does not exist
	 */
	void update(long productId, Product product, String manufacturer);

	/**
	 * Updates availability of the specified product.
	 */
	void updateAvailability(Map<Boolean, List<Long>> productIdsByAvailability);

	/**
	 * Removes manufacturer.
	 */
	void delete(long product);
}
