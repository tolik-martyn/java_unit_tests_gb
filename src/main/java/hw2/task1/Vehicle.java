package hw2.task1;

public abstract class Vehicle {
    protected String company;
    protected String model;
    protected int yearRelease;
    protected int numWheels;
    protected int speed;
    public Vehicle(String company, String model, int yearRelease, int numWheels, int speed) {
        this.company = company;
        this.model = model;
        this.yearRelease = yearRelease;
        this.numWheels = numWheels;
        this.speed = speed;
    }

    public abstract void testDrive();

    public abstract void park();

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public int getSpeed() {
        return speed;
    }
}
