package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperty;
import by.antonov.shapes.repository.CubeSpecification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeSideSquareSpecificationImpl implements CubeSpecification {

  private final Logger logger = LogManager.getLogger();

  private final double minSideSquare;
  private final double maxSideSquare;

  private CubeSideSquareSpecificationImpl(double minSideSquare, double maxSideSquare) {
    this.minSideSquare = minSideSquare;
    this.maxSideSquare = maxSideSquare;
  }

  public static CubeSideSquareSpecificationImpl lessThen(double maxSideSquare) {
    return new CubeSideSquareSpecificationImpl(0, maxSideSquare);
  }

  public static CubeSideSquareSpecificationImpl moreThen(double minSideSquare) {
    return new CubeSideSquareSpecificationImpl(minSideSquare, Double.MAX_VALUE);
  }

  public static CubeSideSquareSpecificationImpl range(double minSideSquare, double maxSideSquare) {
    return new CubeSideSquareSpecificationImpl(minSideSquare, maxSideSquare);
  }

  @Override
  public boolean test(Cube cube) {
    CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
    CubeProperty cubeProperty = cubeWarehouse.getProperty(cube.getId());

    double sideSquare = cubeProperty.getSideSquare();
    return ((sideSquare >= minSideSquare) && (sideSquare <= maxSideSquare));
  }
}
