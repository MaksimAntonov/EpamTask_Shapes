package by.antonov.shapes.entity;

import by.antonov.shapes.observer.CubeEvent;
import by.antonov.shapes.observer.Observable;
import by.antonov.shapes.observer.Observer;

import java.util.List;

public class Cube implements Observable {
    private long id;
    private Point point;
    private double sideLength;
    private List<Observer> observerList;

    public Cube(long id, Point point, double sideLength) {
        this.id = id;
        this.point = point;
        this.sideLength = sideLength;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
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
        return getId() == cube.getId()
                && Double.compare(cube.getSideLength(), getSideLength()) == 0
                && getPoint() != null ? getPoint().equals(cube.getPoint()) : cube.getPoint() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long longBits;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getPoint() != null ? getPoint().hashCode() : 0);
        longBits = Double.doubleToLongBits(getSideLength());
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("id=").append(id);
        sb.append(", point=").append(point.toString());
        sb.append(", sideLength=").append(sideLength);
        sb.append('}');
        return sb.toString();
    }
}
