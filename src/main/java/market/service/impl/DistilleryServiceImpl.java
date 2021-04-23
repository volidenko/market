package market.service.impl;

import market.dao.DistilleryDAO;
import market.domain.Distillery;
import market.domain.Category;
import market.service.DistilleryService;
import market.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistilleryServiceImpl implements DistilleryService {
	private final CategoryService categoryService;
	private final DistilleryDAO distilleryDAO;

	public DistilleryServiceImpl(CategoryService categoryService, DistilleryDAO distilleryDAO) {
		this.categoryService = categoryService;
		this.distilleryDAO = distilleryDAO;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Distillery> findAll() {
		return distilleryDAO.findAll().stream()
			.sorted(Comparator.comparing(Distillery::getTitle))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Distillery> findByRegion(Category region) {
		return distilleryDAO.findByRegionOrderByTitleAsc(region);
	}

	@Transactional(readOnly = true)
	@Override
	public Distillery findById(long distilleryId) {
		return distilleryDAO.findById(distilleryId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Distillery findByTitle(String title) {
		return distilleryDAO.findByTitle(title);
	}

	@Transactional
	@Override
	public void create(Distillery newDistillery, String regionName) {
		saveInternal(newDistillery, regionName);
	}

	@Override
	public void update(long distilleryId, Distillery changedDistillery, String regionName) {
		Optional<Distillery> originalDistillery = distilleryDAO.findById(distilleryId);
		if (originalDistillery.isPresent()) {
			changedDistillery.setId(originalDistillery.get().getId());
			saveInternal(changedDistillery, regionName);
		}
	}

	private void saveInternal(Distillery distillery, String regionName) {
		Category category = categoryService.findByName(regionName);
		if (category != null) {
			distillery.setCategory(category);
			distilleryDAO.save(distillery);
		}
	}

	@Transactional
	@Override
	public void delete(long distilleryId) {
		distilleryDAO.deleteById(distilleryId);
	}
}