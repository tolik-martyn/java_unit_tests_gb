package hw1.task2;

import java.util.Comparator;
import java.util.List;

/**
 * Класс, представляющий магазин с продуктами.
 */
public class Shop {
    private List<Product> products;

    /**
     * Конструктор для создания магазина с заданным списком продуктов.
     *
     * @param products список продуктов в магазине
     */
    public Shop(List<Product> products) {
        this.products = products;
    }

    /**
     * Сортирует список продуктов по стоимости.
     */
    public void sortProductsByPrice() {
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }

    /**
     * Возвращает самый дорогой продукт в магазине.
     *
     * @return самый дорогой продукт
     * @throws IllegalStateException если магазин пустой
     */
    public Product getMostExpensiveProduct() {
        return products.stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new IllegalStateException("Магазин не содержит продуктов."));
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
