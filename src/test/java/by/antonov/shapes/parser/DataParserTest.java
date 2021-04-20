package by.antonov.shapes.parser;

import by.antonov.shapes.entity.CubeFieldsName;
import by.antonov.shapes.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.Map;

public class DataParserTest {
    @DataProvider (name = "parseCubeDataFromStringDataTest")
    public Object[][] parseCubeDataFromStringDataTest() {
        return new Object[][] {
                {"1.0 2.4 2.0 3", buildExpectedDataForTest(1.0, 2.4, 2.0, 3)},
                {"-1 2 1 4", buildExpectedDataForTest(-1, 2, 1, 4)},
                {"0 1 4 6", buildExpectedDataForTest(0, 1, 4, 6)},
                {"-5.2 0 14 5", buildExpectedDataForTest(-5.2, 0, 14, 5)},
                {"5.6 1.7 0 4", buildExpectedDataForTest(5.6, 1.7, 0, 4)},
                {"12 -12 -12 20", buildExpectedDataForTest(12, -12, -12, 20)}
        };
    }

    @Test(dataProvider = "parseCubeDataFromStringDataTest")
    public void parseCubeDataFromStringTest(String stringForParsing, Map<CubeFieldsName, Double> expected)
            throws CustomException {
        Map<CubeFieldsName, Double> actual = DataParser.parseCubeDataFromString(stringForParsing);

        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = CustomException.class)
    public void parseCubeDataFromStringNullTest() throws CustomException {
        DataParser.parseCubeDataFromString(null);
    }

    @Test (expectedExceptions = CustomException.class)
    public void parseCubeDataFromStringWrongParametersTest() throws CustomException {
        DataParser.parseCubeDataFromString("-1 2 1");
    }

    @Test (expectedExceptions = CustomException.class)
    public void parseCubeDataFromStringWithValidatingWrongParametersTest() throws CustomException {
        DataParser.parseCubeDataFromStringWithValidating("12w 1 1 2");
    }

    private Map<CubeFieldsName, Double> buildExpectedDataForTest(double x, double y, double z, double sideLength) {
        Map<CubeFieldsName, Double> expectedMap = new EnumMap<>(CubeFieldsName.class);
        expectedMap.put(CubeFieldsName.COORDINATE_X, x);
        expectedMap.put(CubeFieldsName.COORDINATE_Y, y);
        expectedMap.put(CubeFieldsName.COORDINATE_Z, z);
        expectedMap.put(CubeFieldsName.SIDE_LENGTH, sideLength);

        return expectedMap;
    }
}
