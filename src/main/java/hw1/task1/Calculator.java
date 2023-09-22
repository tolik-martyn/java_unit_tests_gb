package hw1.task1;

public class Calculator {

    /**
     * Метод calculateDiscount принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
     *
     * @param purchaseAmount     Сумма покупки.
     * @param discountPercentage Процент скидки.
     * @return Сумма с учетом скидки.
     * @throws ArithmeticException Если переданы недопустимые аргументы (отрицательная сумма или некорректный процент скидки).
     */
    public double calculateDiscount(double purchaseAmount, double discountPercentage) {
        if (purchaseAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            throw new ArithmeticException("Недопустимые входные значения");
        }
        return purchaseAmount - (purchaseAmount * discountPercentage / 100);
    }
}
