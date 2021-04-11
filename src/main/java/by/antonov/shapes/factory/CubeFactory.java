package by.antonov.shapes.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.util.IdGenerator;

public class CubeFactory {
    private static Logger logger = LogManager.getLogger();
    public static Cube getCubeElement(Map<CubeFieldsName, Double> cubeMapData) {
         Point point = new Point(
                 cubeMapData.get(CubeFieldsName.COORDINATE_X),
                 cubeMapData.get(CubeFieldsName.COORDINATE_Y),
                 cubeMapData.get(CubeFieldsName.COORDINATE_Z));
         Cube cube = new Cube(IdGenerator.generateID(), point, cubeMapData.get(CubeFieldsName.SIDE_LENGTH));
         logger.info("Created Cube: " + cube.toString() + " from Map: " + cubeMapData.toString());
         return cube;
    }
}
