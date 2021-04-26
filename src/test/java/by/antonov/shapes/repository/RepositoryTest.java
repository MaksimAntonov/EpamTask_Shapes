package by.antonov.shapes.repository;

import static by.antonov.shapes.repository.CubePredicateFactory.createPredicate;
import static by.antonov.shapes.repository.CubePredicateFactory.forCubeProperties;
import static by.antonov.shapes.repository.CubePredicateFactory.valueEqualTo;
import static by.antonov.shapes.repository.CubePredicateFactory.valueLessThen;
import static by.antonov.shapes.repository.CubePredicateFactory.valueMoreThen;

import by.antonov.shapes.comparator.CubeComparator;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeFactory;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.repository.impl.CubeIdSpecificationImpl;
import by.antonov.shapes.repository.impl.CubeSideLengthSpecificationImpl;
import by.antonov.shapes.repository.impl.CubeSquareSpecificationImpl;
import by.antonov.shapes.repository.impl.CubeVolumeSpecificationImpl;
import by.antonov.shapes.warehouse.CubeWarehouse;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RepositoryTest {

  private final CubeRepository Repository = CubeRepository.getInstance();

  private final Cube cube1 = newCube(1.0, 2.4, 2.0, 3);
  private final Cube cube2 = newCube(-1, 2, 1, 4);
  private final Cube cube3 = newCube(0, 1, 4, 6);
  private final Cube cube4 = newCube(-5.2, 0, 14, 5);
  private final Cube cube5 = newCube(5.6, 1.7, 0, 4);
  private final Cube cube6 = newCube(12, -12, -12, 20);

  @BeforeClass
  public void setUp() {
    prepareDataForTest();
  }

  @DataProvider(name = "sortDataTest")
  public Object[][] sortDataTest() {
    return new Object[][]{
        {CubeComparator.ID, Arrays.asList(cube1, cube2, cube3, cube4, cube5, cube6)},
        {CubeComparator.COORDINATE_X, Arrays.asList(cube4, cube2, cube3, cube1, cube5, cube6)},
        {CubeComparator.COORDINATE_Y, Arrays.asList(cube6, cube4, cube3, cube5, cube2, cube1)},
        {CubeComparator.COORDINATE_Z, Arrays.asList(cube6, cube5, cube2, cube1, cube3, cube4)},
        {CubeComparator.SIDE_LENGTH, Arrays.asList(cube1, cube2, cube5, cube4, cube3, cube6)}
    };
  }

  @DataProvider(name = "queryDataTest")
  public Object[][] queryDataTest() {
    return new Object[][]{
        {new CubeIdSpecificationImpl(3), Arrays.asList(cube3)},
        {CubeSideLengthSpecificationImpl.lessThen(5), Arrays.asList(cube1, cube2, cube4, cube5)},
        {CubeSideLengthSpecificationImpl.moreThen(5), Arrays.asList(cube3, cube4, cube6)},
        {CubeSideLengthSpecificationImpl.range(3, 8), Arrays.asList(cube1, cube2, cube3, cube4, cube5)},
        {CubeVolumeSpecificationImpl.lessThen(30), Arrays.asList(cube1)},
        {CubeSquareSpecificationImpl.range(100, 300), Arrays.asList(cube3, cube4)},
    };
  }

  @DataProvider(name = "queryPredicateDataTest")
  public Object[][] queryPredicateDataTest() {
    return new Object[][]{
        {
            createPredicate(
                Cube::getId,
                valueEqualTo((long) 3)),
            Arrays.asList(cube3)
        },
        {
            createPredicate(
                Cube::getSideLength,
                valueLessThen((double) 5)),
            Arrays.asList(cube1, cube2, cube4, cube5)
        },
        {
            createPredicate(
                Cube::getSideLength,
                valueMoreThen((double) 5)),
            Arrays.asList(cube3, cube4, cube6)
        },
        {
            createPredicate(
                Cube::getSideLength,
                valueMoreThen((double) 3)
                    .and(valueLessThen((double) 8))
            ),
            Arrays.asList(cube1, cube2, cube3, cube4, cube5)
        },
        {
            forCubeProperties(
                createPredicate(
                    CubeProperties::getVolume,
                    valueLessThen((double) 30))
            ),
            Arrays.asList(cube1)
        },
        {
            forCubeProperties(
                createPredicate(
                    CubeProperties::getCubeSquare,
                    valueMoreThen((double) 100)).and(
                    createPredicate(
                        CubeProperties::getCubeSquare,
                        valueLessThen((double) 300)
                    )
                )
            ),
            Arrays.asList(cube3, cube4)
        }
    };
  }

  @Test(dataProvider = "sortDataTest")
  public void sortTest(Comparator<Cube> cubeComparator, List<Cube> expected) {
    List<Cube> actual = Repository.sort(cubeComparator);

    Assert.assertEquals(actual, expected);
  }

  @Test(dataProvider = "queryDataTest")
  public void findTest(CubeSpecification specification, List<Cube> expected) {
    List<Cube> actual = Repository.query(specification);

    Assert.assertEquals(actual, expected);
  }

  @Test(dataProvider = "queryPredicateDataTest")
  public void findPredicateTest(Predicate<Cube> specification, List<Cube> expected) {
    List<Cube> actual = Repository.query(specification);

    Assert.assertEquals(actual, expected);
  }

  @Test(dataProvider = "queryDataTest")
  public void findStreamTest(CubeSpecification specification, List<Cube> expected) {
    List<Cube> actual = Repository.queryStream(specification);

    Assert.assertEquals(actual, expected);
  }

  @Test(dataProvider = "queryPredicateDataTest")
  public void findStreamPredicateTest(Predicate<Cube> specification, List<Cube> expected) {
    List<Cube> actual = Repository.queryStream(specification);

    Assert.assertEquals(actual, expected);
  }

  private Cube newCube(double x, double y, double z, double sideLength) {
    return CubeFactory.getCubeElement(x, y, z, sideLength);
  }

  private void prepareDataForTest() {
    CubeWarehouse warehouse = CubeWarehouse.getInstance();
    Repository.clear();
    Repository.addAll(Arrays.asList(cube1, cube2, cube3, cube4, cube5, cube6));

    warehouse.setProperty(1, new CubeProperties.Builder().setVolume(27)
        .setSideSquare(9)
        .setCubeSquare(54)
        .setOppositePoint(new Point(4, 5.4, 5))
        .build());
    warehouse.setProperty(2, new CubeProperties.Builder().setVolume(64)
        .setSideSquare(16)
        .setCubeSquare(94)
        .setOppositePoint(new Point(3, 6, 5))
        .build());
    warehouse.setProperty(3, new CubeProperties.Builder().setVolume(216)
        .setSideSquare(36)
        .setCubeSquare(216)
        .setOppositePoint(new Point(6, 7, 10))
        .build());
    warehouse.setProperty(4, new CubeProperties.Builder().setVolume(125)
        .setSideSquare(25)
        .setCubeSquare(150)
        .setOppositePoint(new Point(-0.2, 5, 19))
        .build());
    warehouse.setProperty(5, new CubeProperties.Builder().setVolume(64)
        .setSideSquare(16)
        .setCubeSquare(96)
        .setOppositePoint(new Point(9.6, 5.7, 4))
        .build());
    warehouse.setProperty(6, new CubeProperties.Builder().setVolume(8000)
        .setSideSquare(400)
        .setCubeSquare(2400)
        .setOppositePoint(new Point(32, 8, 10))
        .build());
  }
}
