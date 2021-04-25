package by.antonov.shapes.entity;

import by.antonov.shapes.observer.CubeEvent;
import by.antonov.shapes.observer.Observable;
import by.antonov.shapes.observer.Observer;
import java.util.HashSet;
import java.util.Set;
// TODO проверить тексты ошибок/логов
public class Cube implements Observable {

  private final long id;
  private Point point;
  private double sideLength;
  private final Set<Observer> observers = new HashSet<>();

  Cube(long id, Point point, double sideLength) {
    this.id = id;
    this.point = point;
    this.sideLength = sideLength;
  }

  public long getId() {
    return id;
  }

  public Point getPoint() {
    return point;
  }

  public void setPoint(Point point) {
    this.point = point;
    notifyObservers();
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
      observers.add(observer);
    }
  }

  @Override
  public void detach(Observer observer) {
    if (observer != null) {
      observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {
    CubeEvent event = new CubeEvent(this);

    observers.forEach(observer -> observer.parameterChanged(event));
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(getClass().equals(other.getClass()))) {
      return false;
    }

    Cube cube = (Cube) other;
    return (getId() == cube.getId())
        && (getPoint() != null ? getPoint().equals(cube.getPoint()) : cube.getPoint() == null)
        && (cube.getSideLength() == getSideLength());
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = (int) (getId() ^ (getId() >>> 32));
    result = 31 * result + (getPoint() != null ? getPoint().hashCode() : 0);
    temp = Double.doubleToLongBits(getSideLength());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
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
