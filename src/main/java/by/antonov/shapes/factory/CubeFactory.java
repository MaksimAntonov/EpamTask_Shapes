package by.antonov.shapes.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.util.IdGenerator;

public class CubeFactory {
    private static final Logger logger = LogManager.getLogger();

    public static Cube getCubeElement(Map<CubeFieldsName, Double> cubeMapData) {
         Point point = new Point(
                 cubeMapData.get(CubeFieldsName.COORDINATE_X),
                 cubeMapData.get(CubeFieldsName.COORDINATE_Y),
                 cubeMapData.get(CubeFieldsName.COORDINATE_Z));
         Cube cube = new Cube(IdGenerator.generateID(), point, cubeMapData.get(CubeFieldsName.SIDE_LENGTH));
         logger.info("Created Cube: " + cube + " from Map: " + cubeMapData.toString());

         return cube;
    }

    public static Cube getCubeElement(double x, double y, double z, double sideLength) {
        Point point = new Point(x, y, z);
        Cube cube = new Cube(IdGenerator.generateID(), point, sideLength);
        logger.info("Created Cube: " + cube
                + " with data: x=" + x + ", y=" + y + ", z=" + z + ", sideLength=" + sideLength);

        return cube;
    }

    public static Cube getCubeElement(long id, double x, double y, double z, double sideLength) {
        Point point = new Point(x, y, z);
        Cube cube = new Cube(id, point, sideLength);
        logger.info("Created Cube: " + cube
                + " with data: id=" + id + ", x=" + x + ", y=" + y + ", z=" + z + ", sideLength=" + sideLength);

        return cube;
    }

    public static Cube getCubeElement(Point point, double sideLength) {
        Cube cube = new Cube(IdGenerator.generateID(), point, sideLength);
        return cube;
    }
}
