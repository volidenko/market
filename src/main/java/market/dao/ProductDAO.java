package market.dao;

import market.domain.Manufacturer;
import market.domain.Product;
import market.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDAO extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {

	Page<Product> findByManufacturerOrderByName(@Param("manufacturer")Manufacturer manufacturer, Pageable request);

	//@Query(value = "SELECT p FROM Product p WHERE p.manufacturer IN (SELECT d FROM Manufacturer d WHERE d.category = :category) order by p.name")
	Page<Product> findByCategoryOrderByName(@Param("category") Category category, Pageable request);

	Page<Product> findByAvailableOrderByName(boolean available, Pageable request);
}
