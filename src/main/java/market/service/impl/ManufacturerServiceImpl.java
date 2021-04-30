package market.service.impl;

import market.dao.ManufacturerDAO;
import market.domain.Manufacturer;
import market.service.ManufacturerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	private final ManufacturerDAO manufacturerDAO;

	public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
		this.manufacturerDAO = manufacturerDAO;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Manufacturer> findAll() {
		return manufacturerDAO.findAll().stream()
			.sorted(Comparator.comparing(Manufacturer::getTitle))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public Manufacturer findById(long manufacturerId) {
		return manufacturerDAO.findById(manufacturerId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Manufacturer findByTitle(String manufacturerTitle) { return manufacturerDAO.findByTitle(manufacturerTitle).orElse(null);}

	@Transactional
	@Override
	public void create(Manufacturer newManufacturer) {
		manufacturerDAO.save(newManufacturer);
	}

	@Override
	public void update(long manufacturerId, Manufacturer changedManufacturer) {
		Optional<Manufacturer> originalManufacturer = manufacturerDAO.findById(manufacturerId);
		if (originalManufacturer.isPresent()) {
			changedManufacturer.setId(originalManufacturer.get().getId());
			manufacturerDAO.save(changedManufacturer);
		}
	}

	@Transactional
	@Override
	public void delete(long manufacturerId) {
		manufacturerDAO.deleteById(manufacturerId);
	}
}
