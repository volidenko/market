package market.service;

import market.domain.Distillery;
import market.domain.Category;

import java.util.List;

public interface DistilleryService {

	/**
	 * @return all the distilleries sorted by title
	 */
	List<Distillery> findAll();

	/**
	 * @return all the distilleries of the specified region sorted by title
	 */
	List<Distillery> findByRegion(Category category);

	/**
	 * @return distillery with the specified id
	 */
	Distillery findById(long distilleryId);

	/**
	 * @return distillery with the specified title
	 */
	Distillery findByTitle(String title);

	/**
	 * Creates new distillery.
	 */
	void create(Distillery newDistillery, String regionName);

	/**
	 * Updates existing distillery.
	 */
	void update(long distilleryId, Distillery changedDistillery, String regionTitle);

	/**
	 * Removes distillery.
	 */
	void delete(long distilleryId);
}
