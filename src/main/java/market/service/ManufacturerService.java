package market.service;

import market.domain.Manufacturer;
import market.domain.Category;

import java.util.List;

public interface ManufacturerService {

	/**
	 * @return all the distilleries sorted by title
	 */
	List<Manufacturer> findAll();

	/**
	 * @return all the distilleries of the specified region sorted by title
	 */
	List<Manufacturer> findByRegion(Category category);

	/**
	 * @return distillery with the specified id
	 */
	Manufacturer findById(long distilleryId);

	/**
	 * @return distillery with the specified title
	 */
	Manufacturer findByTitle(String title);

	/**
	 * Creates new distillery.
	 */
	void create(Manufacturer newManufacturer, String regionName);

	/**
	 * Updates existing distillery.
	 */
	void update(long distilleryId, Manufacturer changedManufacturer, String regionTitle);

	/**
	 * Removes distillery.
	 */
	void delete(long distilleryId);
}
