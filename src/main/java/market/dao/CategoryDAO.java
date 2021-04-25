package market.dao;

import market.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryDAO extends CrudRepository<Category, Long>, JpaRepository<Category, Long> {

	Optional<Category> findByTitle(String categoryTitle);

}
