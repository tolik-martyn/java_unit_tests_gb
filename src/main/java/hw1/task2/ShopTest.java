package hw1.task2;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShopTest {

    public static void main(String[] args) {
        testSortProductsByPrice();
        testGetMostExpensiveProductIfShopIsNotEmpty();
        testGetMostExpensiveProductIfShopIsEmpty();
        testCheckCountProducts();
        testCheckCorrectProducts();
    }

    /**
     * Проверка корректности работы метода sortProductsByPrice()
     */
    public static void testSortProductsByPrice() {

        Product product1 = new Product("Продукт1", 30.0);
        Product product2 = new Product("Продукт2", 10.0);
        Product product3 = new Product("Продукт3", 20.0);
        List<Product> products = Arrays.asList(product1, product2, product3);
        Shop shop = new Shop(products);

        shop.sortProductsByPrice();

        assertThat(shop.getProducts()).containsExactly(product2, product3, product1);
        System.out.println("Тест на проверку правильности сортировки продуктов: Пройден");
    }

    /**
     * Проверка корректности работы метода getMostExpensiveProduct(), если в магазине есть продукты
     */
    public static void testGetMostExpensiveProductIfShopIsNotEmpty() {

        Product product1 = new Product("Продукт1", 30.0);
        Product product2 = new Product("Продукт2", 10.0);
        Product product3 = new Product("Продукт3", 20.0);
        List<Product> products = Arrays.asList(product1, product2, product3);
        Shop shop = new Shop(products);

        Product mostExpensive = shop.getMostExpensiveProduct();

        assertThat(mostExpensive.getPrice()).isEqualTo(30.0);
        assertThat(mostExpensive.getName()).isEqualTo("Продукт1");
        System.out.println("Тест на проверку поиска наиболее дорогого продукта (есть продукты): Пройден");
    }

    /**
     * Проверка корректности работы метода getMostExpensiveProduct(), если в магазине нет продуктов
     */
    public static void testGetMostExpensiveProductIfShopIsEmpty() {

        List<Product> emptyProducts = Collections.emptyList();
        Shop emptyShop = new Shop(emptyProducts);

        assertThatThrownBy(emptyShop::getMostExpensiveProduct)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Магазин не содержит продуктов.");
        System.out.println("Тест на проверку поиска наиболее дорогого продукта (нет продуктов): Пройден");
    }

    /**
     * Проверка ожидаемого количества продуктов в магазине
     */
    public static void testCheckCountProducts() {
        Product product1 = new Product("Продукт1", 30.0);
        Product product2 = new Product("Продукт2", 10.0);
        Product product3 = new Product("Продукт3", 20.0);
        List<Product> products = Arrays.asList(product1, product2, product3);
        Shop shop = new Shop(products);

        assertThat(shop.getProducts()).hasSize(3);
        System.out.println("Тест на соответствие количества продуктов в магазине: Пройден");
    }

    /**
     * Проверка соответствия ожидаемых продуктов (порядок продуктов не важен)
     */
    public static void testCheckCorrectProducts() {
        Product product1 = new Product("Продукт1", 30.0);
        Product product2 = new Product("Продукт2", 10.0);
        Product product3 = new Product("Продукт3", 20.0);
        List<Product> products = Arrays.asList(product1, product2, product3);
        Shop shop = new Shop(products);

        assertThat(shop.getProducts()).containsExactlyInAnyOrder(product2, product3, product1);
        System.out.println("Тест на проверку соответствия продуктов в магазине: Пройден");
    }
}
