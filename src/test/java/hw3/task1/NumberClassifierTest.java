package hw3.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса NumberClassifier")
class NumberClassifierTest {

    private NumberClassifier classifier;

    @BeforeEach
    void setUp() {
        classifier = new NumberClassifier();
    }

    @Test
    @DisplayName("Проверка четности числа 0")
    void testZeroNumber() {
        assertTrue(classifier.evenOddNumber(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10})
    @DisplayName("Положительные четные числа")
    void testPositiveEvenNumber(int n) {
        assertTrue(classifier.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -4, -10})
    @DisplayName("Отрицательные четные числа")
    void testNegativeEvenNumber(int n) {
        assertTrue(classifier.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7})
    @DisplayName("Положительные нечетные числа")
    void testPositiveOddNumber(int n) {
        assertFalse(classifier.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -7})
    @DisplayName("Отрицательные нечетные числа")
    void testNegativeOddNumber(int n) {
        assertFalse(classifier.evenOddNumber(n));
    }
}