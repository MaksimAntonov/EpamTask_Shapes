package by.antonov.shapes.entity;

import by.antonov.shapes.observer.CubeEvent;
import by.antonov.shapes.observer.Observable;
import by.antonov.shapes.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Cube extends Shape implements Observable {
    private double sideLength;
    private final List<Observer> observerList = new ArrayList<>();

    public Cube(long id, Point point, double sideLength) {
        super(id, point);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observerList.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observer != null) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        CubeEvent event = new CubeEvent(this);

        observerList.forEach(observer -> observer.parameterChanged(event));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;

        Cube cube = (Cube) o;
        return Double.compare(cube.getSideLength(), getSideLength()) == 0;
    }

    @Override
    public int hashCode() {
        long longBits;
        int result = super.hashCode();
        longBits = Double.doubleToLongBits(getSideLength());
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append(super.toString());
        sb.append(", sideLength=").append(sideLength);
        sb.append('}');
        return sb.toString();
    }
}
