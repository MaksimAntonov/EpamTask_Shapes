package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.repository.CubeSpecification;

public class CubeSideLengthSpecificationImpl implements CubeSpecification {

  private final double minSideLength;
  private final double maxSideLength;

  public CubeSideLengthSpecificationImpl(double minSideLength, double maxSideLength) {
    this.minSideLength = minSideLength;
    this.maxSideLength = maxSideLength;
  }

  public static CubeSideLengthSpecificationImpl lessThen(double value) {
    return new CubeSideLengthSpecificationImpl(0, value);
  }

  public static CubeSideLengthSpecificationImpl moreThen(double value) {
    return new CubeSideLengthSpecificationImpl(value, Double.MAX_VALUE);
  }

  public static CubeSideLengthSpecificationImpl range(double minSideLength, double maxSideLength) {
    return new CubeSideLengthSpecificationImpl(minSideLength, maxSideLength);
  }

  @Override
  public boolean test(Cube cube) {
    double sideLength = cube.getSideLength();
    return ((sideLength >= minSideLength) && (sideLength <= maxSideLength));
  }
}
