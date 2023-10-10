package hw6;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Пример использования с целыми числами
        List<Integer> int1 = List.of(6, 7, 8, 9, 10);
        List<Integer> int2 = List.of(1, 2, 3, 4, 5);

        NumberList<Integer> list1 = new NumberList<>(int1);
        NumberList<Integer> list2 = new NumberList<>(int2);

        ListComparator<Integer> comparatorInt = new ListComparator<>();
        comparatorInt.compareAndPrint(list1, list2);

        // Пример использования с числами с плавающей запятой
        List<Double> dbl1 = List.of(1.5, 2.5, 3.5, 4.5, 5.5);
        List<Double> dbl2 = List.of(6.5, 7.5, 8.5, 9.5, 10.5);

        NumberList<Double> list3 = new NumberList<>(dbl1);
        NumberList<Double> list4 = new NumberList<>(dbl2);

        ListComparator<Double> comparatorDbl = new ListComparator<>();
        comparatorDbl.compareAndPrint(list3, list4);

        // Средние значения равны (Integer)
        List<Integer> int3 = List.of(1, 2, 3, 4, 5);
        List<Integer> int4 = List.of(5, 4, 3, 2, 1);

        NumberList<Integer> list5 = new NumberList<>(int3);
        NumberList<Integer> list6 = new NumberList<>(int4);
        comparatorInt.compareAndPrint(list5, list6);

        // Средние значения равны (Double)
        List<Double> dbl3 = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> dbl4 = List.of(5.0, 4.0, 3.0, 2.0, 1.0);

        NumberList<Double> list7 = new NumberList<>(dbl3);
        NumberList<Double> list8 = new NumberList<>(dbl4);
        comparatorDbl.compareAndPrint(list7, list8);

        // Код не скомпенсируются, так как аргументы имеют разный тип данных (так и было задумано)
        // comparatorDbl.compareAndPrint(list5, list8);
        // comparatorInt.compareAndPrint(list5, list8);
    }
}
