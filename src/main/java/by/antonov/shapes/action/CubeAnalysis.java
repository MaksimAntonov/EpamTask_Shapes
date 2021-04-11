package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.Point;

public class CubeAnalysis {
    public boolean onCoordinateAxis(Cube cube) {
        return (onCoordinateAxeX(cube) || onCoordinateAxeY(cube) || onCoordinateAxeZ(cube));
    }

    public boolean onCoordinateAxeX(Cube cube) {
        Point point = cube.getPoint();
        return point.getX() == 0;
    }

    public boolean onCoordinateAxeY(Cube cube) {
        Point point = cube.getPoint();
        return point.getY() == 0;
    }

    public boolean onCoordinateAxeZ(Cube cube) {
        Point point = cube.getPoint();
        return point.getZ() == 0;
    }
}
