package hw2.task2;

/**
 * Главный класс, запускающий демонстрацию онлайн-магазина.
 */
public class OnlineShopDemo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addProduct(new Product(1, "Ноутбук", 1000.0, 10));
        shop.addProduct(new Product(2, "Смартфон", 500.0, 20));
        shop.addProduct(new Product(3, "Планшет", 300.0, 15));

        Cart cart = new Cart(shop);
        TextUserInterface ui = new TextUserInterface(shop, cart);
        ui.start();
    }
}

