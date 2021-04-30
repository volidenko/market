package market.dao;

import market.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ManufacturerDAO extends CrudRepository<Manufacturer, Long>, JpaRepository<Manufacturer, Long> {
	Optional<Manufacturer> findByTitle(String manufacturerTitle);
}