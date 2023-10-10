package hw6;

import java.util.List;

/**
 * Обобщенный класс для представления списка чисел.
 *
 * @param <T> тип чисел в списке (целочисленный или дробный).
 */
class NumberList<T extends Number> implements Comparable<NumberList<T>> {
    private List<T> numbers;

    /**
     * Конструктор класса NumberList.
     *
     * @param numbers список чисел.
     */
    public NumberList(List<T> numbers) {
        this.numbers = numbers;
    }

    /**
     * Рассчитывает среднее значение чисел в списке.
     *
     * @return среднее значение чисел или 0.0, если список пуст.
     */
    public double calculateAverage() {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.size();
    }

    /**
     * Сравнивает два объекта NumberList на основе их средних значений.
     *
     * @param other другой объект NumberList для сравнения.
     * @return отрицательное число, если this меньше other;
     *         положительное число, если this больше other;
     *         ноль, если средние значения равны.
     */
    @Override
    public int compareTo(NumberList<T> other) {
        double average1 = this.calculateAverage();
        double average2 = other.calculateAverage();

        return Double.compare(average1, average2);
    }
}
