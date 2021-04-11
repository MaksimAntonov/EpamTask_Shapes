package by.antonov.shapes.comparator;

import by.antonov.shapes.entity.Cube;

import java.util.Comparator;

public class CubeComparator {
    public static Comparator<Cube> ID = (cube1, cube2) -> Long.compare(cube1.getId(), cube2.getId());
    public static Comparator<Cube> COORDINATE_X = (cube1, cube2) -> Double.compare(cube1.getPoint().getX(), cube2.getPoint().getX());
    public static Comparator<Cube> COORDINATE_Y = (cube1, cube2) -> Double.compare(cube1.getPoint().getY(), cube2.getPoint().getY());
    public static Comparator<Cube> COORDINATE_Z = (cube1, cube2) -> Double.compare(cube1.getPoint().getZ(), cube2.getPoint().getZ());
    public static Comparator<Cube> SIDE_LENGTH = (cube1, cube2) -> Double.compare(cube1.getSideLength(), cube2.getSideLength());
}
