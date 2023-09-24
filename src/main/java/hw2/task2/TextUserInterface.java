package hw2.task2;

import java.util.List;
import java.util.Scanner;

/**
 * Класс, представляющий текстовый пользовательский интерфейс.
 */
class TextUserInterface {
    private Shop shop;
    private Cart cart;

    /**
     * Создает новый текстовый пользовательский интерфейс.
     *
     * @param shop магазин
     * @param cart корзина
     */
    public TextUserInterface(Shop shop, Cart cart) {
        this.shop = shop;
        this.cart = cart;
    }

    /**
     * Начинает выполнение текстового интерфейса.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Просмотр продуктов");
            System.out.println("2. Добавить продукт в корзину");
            System.out.println("3. Убрать продукт из корзины");
            System.out.println("4. Посчитать общую стоимость корзины");
            System.out.println("5. Выйти из программы");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    calculateTotalPrice();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private void displayProducts() {
        List<Product> products = shop.getAllProducts();
        System.out.println("Список продуктов в магазине:");
        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - " + product.getPrice() + " руб. (В наличии: " + product.getQuantity() + ")");
        }
    }

    private void addToCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID продукта: ");
        int productId = scanner.nextInt();
        System.out.print("Введите количество: ");
        int quantity = scanner.nextInt();
        cart.addToCart(productId, quantity);
    }

    private void removeFromCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID продукта: ");
        int productId = scanner.nextInt();
        System.out.print("Введите количество: ");
        int quantity = scanner.nextInt();
        cart.removeFromCart(productId, quantity);
    }

    private void calculateTotalPrice() {
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Общая стоимость корзины: " + totalPrice + " руб.");
    }
}
