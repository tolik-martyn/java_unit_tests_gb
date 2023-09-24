package hw2.task2;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, представляющий корзину покупателя.
 */
class Cart {
    private Map<Integer, Integer> cartItems = new HashMap<>(); // ProductId -> Quantity
    private Shop shop;

    /**
     * Создает новую корзину для покупателя.
     *
     * @param shop магазин, связанный с корзиной
     */
    public Cart(Shop shop) {
        this.shop = shop;
    }

    /**
     * Добавляет продукт в корзину с указанным количеством.
     *
     * @param productId идентификатор продукта
     * @param quantity  количество для добавления
     */
    public void addToCart(int productId, int quantity) {
        Product product = shop.getProduct(productId);
        if (product != null && product.getQuantity() >= quantity) {
            int currentQuantity = cartItems.getOrDefault(productId, 0);
            cartItems.put(productId, currentQuantity + quantity);
            product.setQuantity(product.getQuantity() - quantity);
        } else {
            System.out.println("Товар недоступен или недостаточно на складе.");
        }
    }

    /**
     * Убирает продукт из корзины с указанным количеством.
     *
     * @param productId идентификатор продукта
     * @param quantity  количество для удаления
     */
    public void removeFromCart(int productId, int quantity) {
        int currentQuantity = cartItems.getOrDefault(productId, 0);
        if (currentQuantity >= quantity) {
            cartItems.put(productId, currentQuantity - quantity);
            Product product = shop.getProduct(productId);
            product.setQuantity(product.getQuantity() + quantity);
        } else {
            System.out.println("Недостаточное количество товара в корзине.");
        }
    }

    /**
     * Рассчитывает общую стоимость товаров в корзине.
     *
     * @return общая стоимость товаров в корзине
     */
    public double calculateTotalPrice() {
        double total = 0;
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = shop.getProduct(productId);
            total += product.getPrice() * quantity;
        }
        return total;
    }
}
