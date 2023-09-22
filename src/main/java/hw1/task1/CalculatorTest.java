package hw1.task1;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    public static void main(String[] args) {
        testValidInput();
        testZeroDiscount();
        testInvalidDiscountPercentage();
        testNegativePurchaseAmount();
        testDiscountOutOfRange();
    }

    /**
     * Тест для проверки валидных входных данных.
     */
    public static void testValidInput() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateDiscount(100.0, 10.0);
        assertThat(result).isEqualTo(90.0);
        System.out.println("Тест на валидные входные данные: Пройден");
    }

    /**
     * Тест для проверки скидки в размере 0%.
     */
    public static void testZeroDiscount() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateDiscount(100.0, 0.0);
        assertThat(result).isEqualTo(100.0);
        System.out.println("Тест на скидку в размере 0%: Пройден");
    }

    /**
     * Тест для проверки недопустимого процента скидки.
     */
    public static void testInvalidDiscountPercentage() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculateDiscount(100.0, -10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Недопустимые входные значения");
        System.out.println("Тест на недопустимый процент скидки: Пройден");
    }

    /**
     * Тест для проверки отрицательной суммы покупки.
     */
    public static void testNegativePurchaseAmount() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculateDiscount(-100.0, 10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Недопустимые входные значения");
        System.out.println("Тест на отрицательную сумму покупки: Пройден");
    }

    /**
     * Тест для проверки процента скидки вне допустимого диапазона.
     */
    public static void testDiscountOutOfRange() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculateDiscount(100.0, 110.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Недопустимые входные значения");
        System.out.println("Тест на процент скидки вне допустимого диапазона: Пройден");
    }
}
