package hw3.task2;

public class NumericInterval {
    /*
    Интервалом (промежутком) называется множество точек прямой, заключённых между точками А и В,
    причём сами точки А и В не причисляются к интервалу.
    Сегментом (отрезком) называется множество точек прямой, лежащих между точками А и В,
    к которому присоединены сами эти точки.
     */

    private int fromInterval;
    private int toInterval;

    public NumericInterval(int fromInterval, int toInterval) {
        this.fromInterval = fromInterval;
        this.toInterval = toInterval;
    }

    public boolean numberInInterval(int n) {
        return n > fromInterval && n < toInterval;
    }
}
