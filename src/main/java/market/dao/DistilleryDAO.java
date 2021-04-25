package market.dao;

import market.domain.Manufacturer;
import market.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DistilleryDAO extends CrudRepository<Manufacturer, Long>, JpaRepository<Manufacturer, Long> {

	List<Manufacturer> findByRegionOrderByTitleAsc(Category region);

	Manufacturer findByTitle(String title);
}
