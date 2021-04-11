package by.antonov.shapes.action;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.Point;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeAnalysisTest {
    private CubeAnalysis cubeAnalysis;

    @BeforeMethod
    public void setUp() {
        this.cubeAnalysis = new CubeAnalysis();
    }

    @AfterMethod
    public void tearDown() {
        this.cubeAnalysis = null;
    }

    @DataProvider(name = "onCoordinateAxisDataTest")
    public Object[][] onCoordinateAxisDataTest() {
        return new Object[][] {
                {new Cube(1, new Point(0, 1, 1), 2), true},
                {new Cube(2, new Point(1, 0, 1), 3), true},
                {new Cube(3, new Point(1, 1, 0), 4), true},
                {new Cube(4, new Point(1, 1, 1), 1.8), false}
        };
    }

    @Test (dataProvider = "onCoordinateAxisDataTest")
    public void onCoordinateAxisTest(Cube cube, boolean expected) {
        boolean actual = cubeAnalysis.onCoordinateAxis(cube);

        Assert.assertEquals(actual, expected);
    }
}