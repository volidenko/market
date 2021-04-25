package market.service;

import market.domain.Category;

import java.util.List;

public interface CategoryService {

	/**
	 * @return все существующие категории отсортированы по названию категории
	 */
	List<Category> findAll();

	/**
	 * @return категорию с указанным id
	 */
	Category findOne(long categoryId);

	/**
	 * @return категорию с указанным именем
	 */
	Category findByTitle(String categoryTitle);

	/**
	 * Создание новой категории.
	 */
	void create(Category newCategory);

	/**
	 * Обновления существующей категории.
	 */
	void update(long categoryId, Category changedCategory);

	/**
	 * Удаление категории
	 */
	void delete(long categoryId);

}
