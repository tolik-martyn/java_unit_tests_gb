package hw6;

/**
 * Класс для сравнения двух списков и вывода сообщения на консоль.
 *
 * @param <T> тип чисел в списках (целочисленный или дробный).
 */
class ListComparator<T extends Number> {
    /**
     * Сравнивает два NumberList и выводит сообщение на консоль.
     *
     * @param list1 первый список для сравнения.
     * @param list2 второй список для сравнения.
     */
    public void compareAndPrint(NumberList<T> list1, NumberList<T> list2) {
        int comparisonResult = list1.compareTo(list2);

        if (comparisonResult > 0) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (comparisonResult < 0) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }
}
