package by.antonov.shapes.repository;

import by.antonov.shapes.comparator.CubeComparator;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.factory.CubeFactory;
import by.antonov.shapes.repository.impl.CubeIdSpecification;
import by.antonov.shapes.repository.impl.CubeSideLengthSpecification;
import by.antonov.shapes.repository.impl.CubeSquareSpecification;
import by.antonov.shapes.repository.impl.CubeVolumeSpecification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class RepositoryTest {
    private final CubeRepository Repository = CubeRepository.getInstance();

    private final Cube cube1 = CubeFactory.getCubeElement(1, 1.0, 2.4, 2.0, 3);
    private final Cube cube2 = CubeFactory.getCubeElement(2,-1, 2, 1, 4);
    private final Cube cube3 = CubeFactory.getCubeElement(3,0, 1, 4, 6);
    private final Cube cube4 = CubeFactory.getCubeElement(4,-5.2, 0, 14, 5);
    private final Cube cube5 = CubeFactory.getCubeElement(5,5.6, 1.7, 0, 4);
    private final Cube cube6 = CubeFactory.getCubeElement(6,12, -12, -12, 20);

    @BeforeClass
    public void setUp() {
        prepareDataForTest();
    }

    @DataProvider (name = "sortDataTest")
    public Object[][] sortDataTest() {
        return new Object[][] {
                {CubeComparator.ID, Arrays.asList(cube1, cube2, cube3, cube4, cube5, cube6)},
                {CubeComparator.COORDINATE_X, Arrays.asList(cube4, cube2, cube3, cube1, cube5, cube6)},
                {CubeComparator.COORDINATE_Y, Arrays.asList(cube6, cube4, cube3, cube5, cube2, cube1)},
                {CubeComparator.COORDINATE_Z, Arrays.asList(cube6, cube5, cube2, cube1, cube3, cube4)},
                {CubeComparator.SIDE_LENGTH, Arrays.asList(cube1, cube2, cube5, cube4, cube3, cube6)}
        };
    }

    @DataProvider (name = "queryDataTest")
    public Object[][] queryDataTest() {
        return new Object[][] {
                {new CubeIdSpecification(3), Arrays.asList(cube3)},
                {CubeSideLengthSpecification.lessThen(5), Arrays.asList(cube1, cube2, cube5)},
                {CubeSideLengthSpecification.moreThen(5), Arrays.asList(cube3, cube6)},
                {CubeSideLengthSpecification.range(3,8), Arrays.asList(cube2, cube3, cube4, cube5)},
                {CubeVolumeSpecification.lessThen(30), Arrays.asList(cube1)},
                {CubeSquareSpecification.range(100, 300), Arrays.asList(cube3, cube4)},
        };
    }

    @Test (dataProvider = "sortDataTest")
    public void sortTest(Comparator<Cube> cubeComparator, List<Cube> expected) {
        List<Cube> actual = Repository.sort(cubeComparator);

        Assert.assertEquals(actual, expected);
    }

    @Test (dataProvider = "queryDataTest")
    public void findTest(Specification specification, List<Cube> expected) {
        List<Cube> actual = Repository.query(specification);

        Assert.assertEquals(actual, expected);
    }

    @Test (dataProvider = "queryDataTest")
    public void findStreamTest(Specification specification, List<Cube> expected) {
        List<Cube> actual = Repository.queryStream(specification);

        Assert.assertEquals(actual, expected);
    }

    private void prepareDataForTest() {
        CubeWarehouse warehouse = CubeWarehouse.getInstance();
        Repository.clear();
        Repository.addAll(Arrays.asList(cube1, cube2, cube3, cube4, cube5, cube6));

        warehouse.setProperty(1, new CubeProperties(1, 27, 9, 54, new Point(4, 5.4, 5)));
        warehouse.setProperty(2, new CubeProperties(2, 64, 16, 94, new Point(3, 6, 5)));
        warehouse.setProperty(3, new CubeProperties(3, 216, 36, 216, new Point(6, 7, 10)));
        warehouse.setProperty(4, new CubeProperties(4, 125, 25, 150, new Point(-0.2, 5, 19)));
        warehouse.setProperty(5, new CubeProperties(5, 64, 16, 96, new Point(9.6, 5.7, 4)));
        warehouse.setProperty(6, new CubeProperties(6, 8000, 400, 2400, new Point(32,8, 10)));
    }
}
