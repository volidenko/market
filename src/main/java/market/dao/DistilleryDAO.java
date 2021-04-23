package market.dao;

import market.domain.Distillery;
import market.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DistilleryDAO extends CrudRepository<Distillery, Long>, JpaRepository<Distillery, Long> {

	List<Distillery> findByRegionOrderByTitleAsc(Category region);

	Distillery findByTitle(String title);
}
