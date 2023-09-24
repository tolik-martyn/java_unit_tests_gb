package hw2.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, представляющий магазин.
 */
class Shop {
    private Map<Integer, Product> products = new HashMap<>();

    /**
     * Добавляет продукт в магазин.
     *
     * @param product продукт для добавления
     */
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    /**
     * Получает продукт по его идентификатору.
     *
     * @param productId идентификатор продукта
     * @return продукт или null, если продукт не найден
     */
    public Product getProduct(int productId) {
        return products.get(productId);
    }

    /**
     * Получает список всех продуктов в магазине.
     *
     * @return список продуктов
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}
