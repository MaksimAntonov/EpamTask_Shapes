package by.antonov.shapes.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;
import java.util.Map;

import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.validator.CubeDataValidator;

public class DataParser {
    static Logger logger = LogManager.getLogger();

    private static final String SEPARATOR = "\s";

    public static Map<CubeFieldsName, Double> parseCubeDataFromString(String dataForParsing) throws CustomException {
        if (dataForParsing == null) {
            throw new CustomException("dataForParsing can't be null");
        }
        logger.info("Parsing string: " + dataForParsing);
        String[] stringArray = dataForParsing.split(SEPARATOR);

        Map<CubeFieldsName, Double> mapCubeData = new EnumMap<>(CubeFieldsName.class);
        if (stringArray.length != 4
                || !CubeDataValidator.isCoordinate(stringArray[0])
                || !CubeDataValidator.isCoordinate(stringArray[1])
                || !CubeDataValidator.isCoordinate(stringArray[2])
                || !CubeDataValidator.isSideLength(stringArray[3])
        ) {
            throw new CustomException("Incorrect dataForParsing");
        }

        mapCubeData.put(CubeFieldsName.COORDINATE_X, Double.parseDouble(stringArray[0]));
        mapCubeData.put(CubeFieldsName.COORDINATE_Y, Double.parseDouble(stringArray[1]));
        mapCubeData.put(CubeFieldsName.COORDINATE_Z, Double.parseDouble(stringArray[2]));
        mapCubeData.put(CubeFieldsName.SIDE_LENGTH, Double.parseDouble(stringArray[3]));

        logger.info("Map with cube data: " + mapCubeData.toString());

        return mapCubeData;
    }
}
