package by.antonov.shapes;

import by.antonov.shapes.creator.CubeCreator;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.factory.CubeFactory;
import by.antonov.shapes.parser.DataParser;
import by.antonov.shapes.reader.CustomReader;
import by.antonov.shapes.repository.CubeRepository;
import by.antonov.shapes.util.RandomNumber;

import java.util.List;
import java.util.Map;

public class app {
    public static void main(String[] args) {
        try {
            readAndCreateCube();

            CubeRepository repository = CubeRepository.getInstance();
            int itemCounts = repository.getItemCount();
            int index = RandomNumber.getRandomIntFromRange(0, itemCounts);

            Cube cube = repository.getItem(index);
            cube.setSideLength(10);
            repository.setItem(index, cube);

        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    public static void readAndCreateCube() throws CustomException {
        CustomReader reader = new CustomReader();

        List<String> stringList = reader.readDataFromFile("data/data.txt");
        CubeCreator creator = CubeCreator.getCreator();
        for (String string : stringList) {
            Map<CubeFieldsName, Double> dataForFactory = DataParser.parseCubeDataFromString(string);
            Cube cube = CubeFactory.getCubeElement(dataForFactory);

            creator.doWith(cube).addToRepository().attacheObserver();
        }
    }
}
