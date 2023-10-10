package hw6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса ListComparator")
class ListComparatorTest {
    private ListComparator<Integer> integerListComparator;
    private ListComparator<Double> doubleListComparator;
    NumberList<Integer> integers1;
    NumberList<Integer> integers2;
    NumberList<Integer> integers3;
    NumberList<Double> doubles1;
    NumberList<Double> doubles2;
    NumberList<Double> doubles3;

    @BeforeEach
    void setUp() {
        integerListComparator = new ListComparator<>();
        doubleListComparator = new ListComparator<>();
        integers1 = new NumberList<>(Arrays.asList(1, 2, 3, 4, 5));
        integers2 = new NumberList<>(Arrays.asList(6, 7, 8, 9, 10));
        integers3 = new NumberList<>(Arrays.asList(10, 9, 8, 7, 6));
        doubles1 = new NumberList<>(Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5));
        doubles2 = new NumberList<>(Arrays.asList(6.5, 7.5, 8.5, 9.5, 10.5));
        doubles3 = new NumberList<>(Arrays.asList(10.5, 9.5, 8.5, 7.5, 6.5));
    }

    @Test
    @DisplayName("Тест compareAndPrint с целыми числами (первый список больше)")
    void compareAndPrintWithIntegerListFirstGreater() {
        String expectedOutput = "Первый список имеет большее среднее значение";
        assertEquals(expectedOutput, getConsoleOutput(() -> integerListComparator.compareAndPrint(integers2, integers1)));
    }

    @Test
    @DisplayName("Тест compareAndPrint с целыми числами (второй список больше)")
    void compareAndPrintWithIntegerListSecondGreater() {
        String expectedOutput = "Второй список имеет большее среднее значение";
        assertEquals(expectedOutput, getConsoleOutput(() -> integerListComparator.compareAndPrint(integers1, integers2)));
    }

    @Test
    @DisplayName("Тест compareAndPrint с целыми числами (средние значения равны)")
    void compareAndPrintWithIntegerListEqual() {
        String expectedOutput = "Средние значения равны";
        assertEquals(expectedOutput, getConsoleOutput(() -> integerListComparator.compareAndPrint(integers2, integers2)));
    }

    @Test
    @DisplayName("Тест compareAndPrint с числами с плавающей запятой (первый список больше)")
    void compareAndPrintWithDoubleListFirstGreater() {
        String expectedOutput = "Первый список имеет большее среднее значение";
        assertEquals(expectedOutput, getConsoleOutput(() -> doubleListComparator.compareAndPrint(doubles2, doubles1)));
    }

    @Test
    @DisplayName("Тест compareAndPrint с числами с плавающей запятой (второй список больше)")
    void compareAndPrintWithDoubleListSecondGreater() {
        String expectedOutput = "Второй список имеет большее среднее значение";
        assertEquals(expectedOutput, getConsoleOutput(() -> doubleListComparator.compareAndPrint(doubles1, doubles3)));
    }

    @Test
    @DisplayName("Тест compareAndPrint с числами с плавающей запятой (средние значения равны)")
    void compareAndPrintWithDoubleListEqual() {
        String expectedOutput = "Средние значения равны";
        assertEquals(expectedOutput, getConsoleOutput(() -> doubleListComparator.compareAndPrint(doubles2, doubles3)));
    }

    // Вспомогательный метод для перехвата вывода в консоль
    private String getConsoleOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        runnable.run();
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
}
