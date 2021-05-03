package by.antonov.shapes.entity;

public class CubeProperty {

  private final double volume;
  private final double sideSquare;
  private final double cubeSquare;
  private final Point oppositePoint;

  private CubeProperty(double volume, double sideSquare, double cubeSquare, Point oppositePoint) {
    this.volume = volume;
    this.sideSquare = sideSquare;
    this.cubeSquare = cubeSquare;
    this.oppositePoint = oppositePoint;
  }

  public double getVolume() {
    return volume;
  }

  public double getSideSquare() {
    return sideSquare;
  }

  public double getCubeSquare() {
    return cubeSquare;
  }

  public Point getOppositePoint() {
    return oppositePoint;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CubeProperty{");
    sb.append(", volume=").append(volume);
    sb.append(", sideSquare=").append(sideSquare);
    sb.append(", cubeSquare=").append(cubeSquare);
    sb.append(", oppositePoint=").append(oppositePoint);
    sb.append('}');
    return sb.toString();
  }

  public static class Builder {

    private double volume;
    private double sideSquare;
    private double cubeSquare;
    private Point oppositePoint;

    public Builder setVolume(double volume) {
      this.volume = volume;
      return this;
    }

    public Builder setSideSquare(double sideSquare) {
      this.sideSquare = sideSquare;
      return this;
    }

    public Builder setCubeSquare(double cubeSquare) {
      this.cubeSquare = cubeSquare;
      return this;
    }

    public Builder setOppositePoint(Point oppositePoint) {
      this.oppositePoint = oppositePoint;
      return this;
    }

    public CubeProperty build() {
      return new CubeProperty(volume, sideSquare, cubeSquare, oppositePoint);
    }
  }
}
