package market.sorting;

import org.springframework.stereotype.Component;

/**
 * Опции сортировки и фильтрации списка товаров.
 */
@Component
public class ProductSorting extends AbstractSorter {

	public ProductSorting() {
		sortFieldOptions.put("price", "по цене");
		sortFieldOptions.put("manufacturer.title", "по производителю");
	}
}
