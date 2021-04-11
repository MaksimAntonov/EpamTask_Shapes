import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.factory.CubeFactory;
import by.antonov.shapes.parser.DataParser;
import by.antonov.shapes.reader.CustomReader;

import java.util.List;
import java.util.Map;

public class app {
    public static void main(String[] args) {
        List<String> dataList;
        CustomReader reader = new CustomReader();

        try {
            dataList = reader.readDataFromFile("/data/data.txt");
            for (String dataElement : dataList) {
                Map<CubeFieldsName, Double> dataMap = DataParser.parseCubeDataFromString(dataElement);
                Cube cube = CubeFactory.getCubeElement(dataMap);
                System.out.println(cube.toString());
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
