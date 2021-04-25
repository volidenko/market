package market.service.impl;

import market.dao.DistilleryDAO;
import market.domain.Manufacturer;
import market.domain.Category;
import market.service.ManufacturerService;
import market.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	private final CategoryService categoryService;
	private final DistilleryDAO distilleryDAO;

	public ManufacturerServiceImpl(CategoryService categoryService, DistilleryDAO distilleryDAO) {
		this.categoryService = categoryService;
		this.distilleryDAO = distilleryDAO;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Manufacturer> findAll() {
		return distilleryDAO.findAll().stream()
			.sorted(Comparator.comparing(Manufacturer::getTitle))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Manufacturer> findByRegion(Category region) {
		return distilleryDAO.findByRegionOrderByTitleAsc(region);
	}

	@Transactional(readOnly = true)
	@Override
	public Manufacturer findById(long distilleryId) {
		return distilleryDAO.findById(distilleryId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Manufacturer findByTitle(String title) {
		return distilleryDAO.findByTitle(title);
	}

	@Transactional
	@Override
	public void create(Manufacturer newManufacturer, String regionName) {
		saveInternal(newManufacturer, regionName);
	}

	@Override
	public void update(long distilleryId, Manufacturer changedManufacturer, String regionName) {
		Optional<Manufacturer> originalDistillery = distilleryDAO.findById(distilleryId);
		if (originalDistillery.isPresent()) {
			changedManufacturer.setId(originalDistillery.get().getId());
			saveInternal(changedManufacturer, regionName);
		}
	}

	private void saveInternal(Manufacturer manufacturer, String categoryTitle) {
		Category category = categoryService.findByTitle(categoryTitle);
		if (category != null) {
			manufacturer.setCategory(category);
			distilleryDAO.save(manufacturer);
		}
	}

	@Transactional
	@Override
	public void delete(long distilleryId) {
		distilleryDAO.deleteById(distilleryId);
	}
}
