package hw1.task2;

/**
 * Класс, представляющий продукт.
 */
public class Product {
    private String name;
    private double price;

    /**
     * Конструктор для создания экземпляра продукта с указанными именем и ценой.
     *
     * @param name  имя продукта
     * @param price цена продукта
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Возвращает имя продукта.
     *
     * @return имя продукта
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает цену продукта.
     *
     * @return цена продукта
     */
    public double getPrice() {
        return price;
    }
}
