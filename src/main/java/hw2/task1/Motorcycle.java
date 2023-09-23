package hw2.task1;

public class Motorcycle extends Vehicle {
    public Motorcycle(String company, String model, int yearRelease) {
        super(company, model, yearRelease, 2, 0);
    }

    @Override
    public void testDrive() {
        this.speed = 75;
    }

    @Override
    public void park() {
        this.speed = 0;
    }
}
