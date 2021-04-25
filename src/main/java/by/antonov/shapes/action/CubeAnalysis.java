package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.warehouse.CubeWarehouse;

public class CubeAnalysis {

  public static boolean isCube(Cube o) {
    return o.getSideLength() > 0;
  }

  public static boolean onCoordinateAxis(Cube cube) {
    return onCoordinateAxeX(cube) || onCoordinateAxeY(cube) || onCoordinateAxeZ(cube);
  }

  public static boolean onCoordinateAxeX(Cube cube) {
    Point point = cube.getPoint();
    return point.getX() == 0;
  }

  public static boolean onCoordinateAxeY(Cube cube) {
    Point point = cube.getPoint();
    return point.getY() == 0;
  }

  public static boolean onCoordinateAxeZ(Cube cube) {
    Point point = cube.getPoint();
    return point.getZ() == 0;
  }

  public static boolean isCubeCuttedByAxes(Cube cube) {
    return (isCuttedByCoordinateAxeX(cube) || isCuttedByCoordinateAxeY(cube)
        || isCuttedByCoordinateAxeY(cube));
  }

  public static boolean isCuttedByCoordinateAxeX(Cube cube) {
    CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());

    Point basePoint = cube.getPoint();
    Point oppositePoint = cubeProperties.getOppositePoint();

    return (basePoint.getX() < 0 && oppositePoint.getX() > 0);
  }

  public static boolean isCuttedByCoordinateAxeY(Cube cube) {
    CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());

    Point basePoint = cube.getPoint();
    Point oppositePoint = cubeProperties.getOppositePoint();

    return (basePoint.getY() < 0 && oppositePoint.getY() > 0);
  }

  public static boolean isCuttedByCoordinateAxeZ(Cube cube) {
    CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());

    Point basePoint = cube.getPoint();
    Point oppositePoint = cubeProperties.getOppositePoint();

    return (basePoint.getZ() < 0 && oppositePoint.getZ() > 0);
  }
}
