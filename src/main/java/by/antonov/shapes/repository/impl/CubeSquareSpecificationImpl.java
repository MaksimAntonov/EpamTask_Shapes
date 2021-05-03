package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperty;
import by.antonov.shapes.repository.CubeSpecification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeSquareSpecificationImpl implements CubeSpecification {

  private final Logger logger = LogManager.getLogger();

  private final double minCubeSquare;
  private final double maxCubeSquare;

  private CubeSquareSpecificationImpl(double minCubeSquare, double maxCubeSquare) {
    this.minCubeSquare = minCubeSquare;
    this.maxCubeSquare = maxCubeSquare;
  }

  public static CubeSquareSpecificationImpl lessThen(double maxCubeSquare) {
    return new CubeSquareSpecificationImpl(0, maxCubeSquare);
  }

  public static CubeSquareSpecificationImpl moreThen(double minCubeSquare) {
    return new CubeSquareSpecificationImpl(minCubeSquare, Double.MAX_VALUE);
  }

  public static CubeSquareSpecificationImpl range(double minCubeSquare, double maxCubeSquare) {
    return new CubeSquareSpecificationImpl(minCubeSquare, maxCubeSquare);
  }

  @Override
  public boolean test(Cube cube) {
    CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
    CubeProperty cubeProperty = cubeWarehouse.getProperty(cube.getId());

    double cubeSquare = cubeProperty.getCubeSquare();
    return ((cubeSquare >= minCubeSquare) && (cubeSquare <= maxCubeSquare));
  }
}
