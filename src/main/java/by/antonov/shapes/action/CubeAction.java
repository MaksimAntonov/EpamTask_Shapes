package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAction {
    static Logger logger = LogManager.getLogger();

    public double calculateCubeVolume(Cube cube) {
        double volume = Math.pow(cube.getSideLength(), 3);
        logger.info("Volume for Cube(" + cube.toString() + ") is " + volume);

        return volume;
    }

    public double calculateCubeSideSquare(Cube cube) {
        double sideLength = cube.getSideLength();
        double sideSquare = sideLength * sideLength;
        logger.info("Side square for Cube(" + cube.toString() + ") is " + sideSquare);

        return sideSquare;
    }

    public double calculateCubeSquare(Cube cube) {
        double sideSquare = calculateCubeSideSquare(cube);
        double cubeSquare = 6 * sideSquare;
        logger.info("Cube square for Cube(" + cube.toString() + ") is " + cubeSquare);

        return cubeSquare;
    }
}
