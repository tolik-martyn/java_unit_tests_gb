package hw2.task2;

/**
 * Класс, представляющий продукт.
 */
class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    /**
     * Создает новый экземпляр продукта.
     *
     * @param id       уникальный идентификатор продукта
     * @param name     название продукта
     * @param price    цена продукта
     * @param quantity количество продукта на складе
     */
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
