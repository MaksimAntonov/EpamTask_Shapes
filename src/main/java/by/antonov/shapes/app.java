package by.antonov.shapes;

import by.antonov.shapes.registrator.CubeRegistrator;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeFactory;
import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.parser.DataParser;
import by.antonov.shapes.reader.CustomReader;
import by.antonov.shapes.repository.CubeRepository;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class app {

  public static void main(String[] args) {

    try {
      readAndCreateCube();

      CubeRepository repository = CubeRepository.getInstance();
      Collection<Cube> cubes = repository.getAll();
      long cId = cubes.stream().findAny().map(Cube::getId).orElse((long) 0);
      Cube cube = repository.getItem(cId);
      cube.setSideLength(10);

      Cube cube1 = repository.getItem(cId);
      System.out.println(cube1);
    } catch (CustomException e) {
      e.printStackTrace();
    }
  }

  public static void readAndCreateCube() throws CustomException {
    CustomReader reader = new CustomReader();

    List<String> stringList = reader.readDataFromFile("data/data.txt");
    for (String string : stringList) {
      Map<CubeFieldsName, Double> dataForFactory = DataParser.parseCubeDataFromString(string);
      Cube cube = CubeFactory.getCubeElement(dataForFactory);

      CubeRegistrator creator = CubeRegistrator.newCreatorFor(cube);
      creator.addToRepository().attacheObserver();
    }
  }
}
