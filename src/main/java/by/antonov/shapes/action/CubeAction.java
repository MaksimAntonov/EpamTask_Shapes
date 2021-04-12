package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;

import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.warehouse.CubeWarehouse;
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

    public Point calculateOppositePoint(Cube cube) {
        Point basePoint = cube.getPoint();
        double sideLength = cube.getSideLength();

        double new_x = basePoint.getX() + sideLength;
        double new_y = basePoint.getY() + sideLength;
        double new_z = basePoint.getZ() + sideLength;

        Point newPoint = new Point(new_x, new_y, new_z);
        return newPoint;
    }

    public double calculateRatioOfCuboidAfterCutByAxel(Cube cube) {
        CubeAnalysis cubeAnalysis = new CubeAnalysis();
        CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());
        Point basePoint = cube.getPoint();
        Point oppositePoint = cubeProperties.getOppositePoint();

        double cuttedSideLengthX1, cuttedSideLengthX2,
                cuttedSideLengthY1, cuttedSideLengthY2,
                cuttedSideLengthZ1, cuttedSideLengthZ2;

        if (cubeAnalysis.isCuttedByCoordinateAxeX(cube)) {
            cuttedSideLengthX1 = Math.abs(basePoint.getX());
            cuttedSideLengthX2 = Math.abs(oppositePoint.getX());
        } else {
            cuttedSideLengthX1 = cube.getSideLength();
            cuttedSideLengthX2 = cube.getSideLength();
        }

        if (cubeAnalysis.isCuttedByCoordinateAxeY(cube)) {
            cuttedSideLengthY1 = Math.abs(basePoint.getY());
            cuttedSideLengthY2 = Math.abs(oppositePoint.getY());
        } else {
            cuttedSideLengthY1 = cube.getSideLength();
            cuttedSideLengthY2 = cube.getSideLength();
        }

        if (cubeAnalysis.isCuttedByCoordinateAxeZ(cube)) {
            cuttedSideLengthZ1 = Math.abs(basePoint.getZ());
            cuttedSideLengthZ2 = Math.abs(oppositePoint.getZ());
        } else {
            cuttedSideLengthZ1 = cube.getSideLength();
            cuttedSideLengthZ2 = cube.getSideLength();
        }

        double volumeForCuboid1 = calculateCuboidVolume(cuttedSideLengthX1, cuttedSideLengthY1, cuttedSideLengthZ1);
        double volumeForCuboid2 = calculateCuboidVolume(cuttedSideLengthX2, cuttedSideLengthY2, cuttedSideLengthZ2);

        return volumeForCuboid1 / volumeForCuboid2;
    }

    public double calculateCuboidVolume(double lengthByX, double lengthByY, double lengthByZ) {
        return lengthByX * lengthByY * lengthByZ;
    }
}
