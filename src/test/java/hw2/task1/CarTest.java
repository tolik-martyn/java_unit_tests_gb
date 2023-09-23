package hw2.task1;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестовый класс для класса Car")
class CarTest {
    private Car car;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        car = new Car("Toyota", "Camry", 2022);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что автомобиль является транспортным средством")
    void testInstanceOfVehicle() {
        assertInstanceOf(Vehicle.class, car, "Автомобиль должен быть транспортным средством");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что автомобиль создается с 4 колесами")
    void testNumberOfWheels() {
        int expectedNumberOfWheels = 4;
        int actualNumberOfWheels = car.getNumWheels();
        assertEquals(expectedNumberOfWheels, actualNumberOfWheels, "У автомобиля должно быть 4 колеса");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что автомобиль развивает скорость 60 в режиме тестового вождения")
    void testDriveSpeed() {
        car.testDrive(); // Эмулируем движение
        int expectedSpeed = 60;
        int actualSpeed = car.getSpeed();
        assertEquals(expectedSpeed, actualSpeed, "Скорость автомобиля должна составлять 60 в режиме тестового вождения");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка, что автомобиль останавливается в режиме парковки")
    void testPark() {
        car.testDrive(); // Эмулируем движение
        car.park(); // Эмулируем парковку
        int expectedSpeed = 0;
        int actualSpeed = car.getSpeed();
        assertEquals(expectedSpeed, actualSpeed, "Скорость автомобиля должна составлять 0 в режиме парковки");
    }
}
