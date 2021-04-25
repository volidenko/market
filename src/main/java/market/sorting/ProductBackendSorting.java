package market.sorting;

import org.springframework.stereotype.Component;

/**
 * Опции сортировки и фильтрации списка товаров.
 */
@Component
public class ProductBackendSorting extends AbstractSorter {

	private final int defaultPageSize;

	public ProductBackendSorting(int defaultPageSize) {
		this.defaultPageSize = defaultPageSize;
		sortFieldOptions.put("price", "по цене");
		sortFieldOptions.put("manufacturer.title", "по производителю");
	}

	@Override
	public int getDefaultPageSize() {
		return defaultPageSize;
	}
}
