package by.antonov.shapes.entity;

public class Point {

  private final double x;
  private final double y;
  private final double z;

  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(getClass().equals(other.getClass()))) {
      return false;
    }

    Point point = (Point) other;
    return Double.compare(point.getX(), getX()) == 0
        && Double.compare(point.getY(), getY()) == 0
        && Double.compare(point.getZ(), getZ()) == 0;
  }

  @Override
  public int hashCode() {
    int result;
    long longBits;
    longBits = Double.doubleToLongBits(getX());
    result = (int) (longBits ^ (longBits >>> 32));
    longBits = Double.doubleToLongBits(getY());
    result = 31 * result + (int) (longBits ^ (longBits >>> 32));
    longBits = Double.doubleToLongBits(getZ());
    result = 31 * result + (int) (longBits ^ (longBits >>> 32));
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Point{");
    sb.append("x=").append(x);
    sb.append(", y=").append(y);
    sb.append(", z=").append(z);
    sb.append('}');
    return sb.toString();
  }
}
