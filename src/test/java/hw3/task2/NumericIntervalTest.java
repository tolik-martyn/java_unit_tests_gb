package hw3.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса NumericInterval")
class NumericIntervalTest {
    /*
    Интервалом (промежутком) называется множество точек прямой, заключённых между точками А и В,
    причём сами точки А и В не причисляются к интервалу.
    Сегментом (отрезком) называется множество точек прямой, лежащих между точками А и В,
    к которому присоединены сами эти точки.
     */

    private NumericInterval intervalFrom25To100;

    @BeforeEach
    void setUp() {
        intervalFrom25To100 = new NumericInterval(25, 100);
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    @DisplayName("Проверка пограничных значений интервала")
    void testBorderlineCase(int n) {
        assertFalse(intervalFrom25To100.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    @DisplayName("Проверка подходящих значений интервала")
    void testPositiveCase(int n) {
        assertTrue(intervalFrom25To100.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 101})
    @DisplayName("Проверка неподходящих значений интервала")
    void testNegativeCase(int n) {
        assertFalse(intervalFrom25To100.numberInInterval(n));
    }
}