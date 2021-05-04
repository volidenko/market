package market.service;

import market.domain.Manufacturer;

import java.util.List;

public interface ManufacturerService {

	/**
	 * @return all the manufacturers sorted by title
	 */
	List<Manufacturer> findAll();


	/**
	 * @return manufacturer with the specified id
	 */
	Manufacturer findById(long manufacturerId);

	/**
	 * @return manufacturer with the specified title
	 */
	Manufacturer findByTitle(String title);

	/**
	 * Creates new manufacturer
	 */
	void create(Manufacturer newManufacturer);

	/**
	 * Updates existing manufacturer.
	 */
	void update(long manufacturerId, Manufacturer changedManufacturer);

	/**
	 * Removes manufacturer.
	 */
	void delete(long manufacturerId);
}
