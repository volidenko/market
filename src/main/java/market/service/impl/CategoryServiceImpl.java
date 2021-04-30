package market.service.impl;

import market.dao.CategoryDAO;
import market.domain.Category;
import market.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryDAO categoryDAO;

	public CategoryServiceImpl(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll().stream()
			.sorted(Comparator.comparing(Category::getTitle))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public Category findOne(long categoryId) {
		return categoryDAO.findById(categoryId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Category findByTitle(String categoryTitle) {	return categoryDAO.findByTitle(categoryTitle).orElse(null);}

	@Transactional
	@Override
	public void create(Category newCategory) {
		categoryDAO.save(newCategory);
	}

	@Override
	public void update(long categoryId, Category changedCategory) {
		Optional<Category> originalOptional = categoryDAO.findById(categoryId);
		if (originalOptional.isPresent()) {
			changedCategory.setId(originalOptional.get().getId());
			categoryDAO.save(changedCategory);
		}
	}

	@Transactional
	@Override
	public void delete(long categoryId) {
		categoryDAO.deleteById(categoryId);
	}
}
