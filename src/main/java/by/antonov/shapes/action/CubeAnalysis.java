package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.entity.Shape;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.warehouse.CubeWarehouse;

public class CubeAnalysis {
    public static boolean isCube(Shape o) {
        return (o.getClass() == Cube.class);
    }

    public static boolean onCoordinateAxis(Cube cube) {
        return (onCoordinateAxeX(cube) || onCoordinateAxeY(cube) || onCoordinateAxeZ(cube));
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

    public static boolean isCubeCuttedByAxes(Cube cube) throws CustomException {
        return (isCuttedByCoordinateAxeX(cube) || isCuttedByCoordinateAxeY(cube) || isCuttedByCoordinateAxeY(cube));
    }

    public static boolean isCuttedByCoordinateAxeX(Cube cube) throws CustomException {
        CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());

        Point basePoint = cube.getPoint();
        Point oppositePoint = cubeProperties.getOppositePoint();

        return (basePoint.getX() < 0 && oppositePoint.getX() > 0);
    }

    public static boolean isCuttedByCoordinateAxeY(Cube cube) throws CustomException {
        CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());

        Point basePoint = cube.getPoint();
        Point oppositePoint = cubeProperties.getOppositePoint();

        return (basePoint.getY() < 0 && oppositePoint.getY() > 0);
    }

    public static boolean isCuttedByCoordinateAxeZ(Cube cube) throws CustomException {
        CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());

        Point basePoint = cube.getPoint();
        Point oppositePoint = cubeProperties.getOppositePoint();

        return (basePoint.getZ() < 0 && oppositePoint.getZ() > 0);
    }
}
