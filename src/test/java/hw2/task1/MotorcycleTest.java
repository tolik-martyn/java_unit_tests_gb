package hw2.task1;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестовый класс для класса Motorcycle")
class MotorcycleTest {
    private Motorcycle motorcycle;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        motorcycle = new Motorcycle("Yamaha", "YZF-R6", 2021);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что мотоцикл является транспортным средством")
    void testInstanceOfVehicle() {
        assertInstanceOf(Vehicle.class, motorcycle, "Мотоцикл должен быть транспортным средством");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что мотоцикл создается с 2 колесами")
    void testNumberOfWheels() {
        int expectedNumberOfWheels = 2;
        int actualNumberOfWheels = motorcycle.getNumWheels();
        assertEquals(expectedNumberOfWheels, actualNumberOfWheels, "У мотоцикла должно быть 2 колеса");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что мотоцикл развивает скорость 75 в режиме тестового вождения")
    void testDriveSpeed() {
        motorcycle.testDrive(); // Эмулируем движение
        int expectedSpeed = 75;
        int actualSpeed = motorcycle.getSpeed();
        assertEquals(expectedSpeed, actualSpeed, "Скорость мотоцикла должна составлять 75 в режиме тестового вождения");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что мотоцикл останавливается в режиме парковки")
    void testPark() {
        motorcycle.testDrive(); // Эмулируем движение
        motorcycle.park(); // Эмулируем парковку
        int expectedSpeed = 0;
        int actualSpeed = motorcycle.getSpeed();
        assertEquals(expectedSpeed, actualSpeed, "Скорость мотоцикла должна составлять 0 в режиме парковки");
    }
}