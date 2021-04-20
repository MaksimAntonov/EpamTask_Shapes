package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeActionTest {
    @DataProvider(name = "calculateVolumeDataTest")
    public Object[][] calculateVolumeDataTest() {
        return new Object[][] {
            {new Cube(1, new Point(1, 1, 1), 2), 8},
            {new Cube(1, new Point(1, 1, 1), 3), 27},
            {new Cube(1, new Point(1, 1, 1), 4), 64},
            {new Cube(1, new Point(1, 1, 1), 1.8), 5.832}
        };
    }

    @DataProvider(name = "calculateSideSquareDataTest")
    public Object[][] calculateSideSquareDataTest() {
        return new Object[][] {
                {new Cube(1, new Point(1, 1, 1), 2), 4},
                {new Cube(1, new Point(1, 1, 1), 3), 9},
                {new Cube(1, new Point(1, 1, 1), 4), 16},
                {new Cube(1, new Point(1, 1, 1), 1.8), 3.24}
        };
    }

    @DataProvider(name = "calculateCubeSquareDataTest")
    public Object[][] calculateCubeSquareDataTest() {
        return new Object[][] {
                {new Cube(1, new Point(1, 1, 1), 2), 24},
                {new Cube(1, new Point(1, 1, 1), 3), 54},
                {new Cube(1, new Point(1, 1, 1), 4), 96},
                {new Cube(1, new Point(1, 1, 1), 1.8), 19.44}
        };
    }

    @Test(dataProvider = "calculateVolumeDataTest")
    public void calculateVolumeTest(Cube cube, double expected) {
        double actual = CubeAction.calculateCubeVolume(cube);

        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test(dataProvider = "calculateSideSquareDataTest")
    public void calculateSideSquareTest(Cube cube, double expected) {
        double actual = CubeAction.calculateCubeSideSquare(cube);

        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test(dataProvider = "calculateCubeSquareDataTest")
    public void calculateCubeSquareTest(Cube cube, double expected) {
        double actual = CubeAction.calculateCubeSquare(cube);

        Assert.assertEquals(actual, expected, 0.0001);
    }
}
