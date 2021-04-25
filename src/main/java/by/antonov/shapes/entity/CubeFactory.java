package by.antonov.shapes.entity;

import by.antonov.shapes.util.IdGenerator;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeFactory {

  private static final Logger logger = LogManager.getLogger();

  public static Cube getCubeElement(Map<CubeFieldsName, Double> cubeMapData) {
    Point point = new Point(
        cubeMapData.get(CubeFieldsName.COORDINATE_X),
        cubeMapData.get(CubeFieldsName.COORDINATE_Y),
        cubeMapData.get(CubeFieldsName.COORDINATE_Z));
    Cube cube = new Cube(IdGenerator.generateID(), point,
        cubeMapData.get(CubeFieldsName.SIDE_LENGTH));
    logger.info("Created Cube: " + cube + " from Map: " + cubeMapData);

    return cube;
  }

  public static Cube getCubeElement(double x, double y, double z, double sideLength) {
    Point point = new Point(x, y, z);
    Cube cube = new Cube(IdGenerator.generateID(), point, sideLength);
    logger.info("Created Cube: " + cube
        + " with data: x=" + x + ", y=" + y + ", z=" + z + ", sideLength=" + sideLength);

    return cube;
  }
}
