package by.antonov.shapes.reader;

import by.antonov.shapes.exception.CustomException;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomReaderTest {

  @Test
  public void readDataFromFileTest() throws CustomException {
    List<String> expected = Arrays.asList(
        "1.0 2.4 2.0 3",
        "-1 2 1 4",
        "0 1 4 6",
        "-5.2 0 14 5",
        "5.6 1.7 0 4",
        "12 -12 -12 20"
    );

    CustomReader reader = new CustomReader();

    List<String> actual = reader.readDataFromFile("data/data.txt");

    Assert.assertEquals(actual, expected);
  }

  @Test(expectedExceptions = CustomException.class)
  public void readDataFromFileExceptionTest() throws CustomException {
    CustomReader reader = new CustomReader();
    reader.readDataFromFile("missing_file.txt");
  }
}
