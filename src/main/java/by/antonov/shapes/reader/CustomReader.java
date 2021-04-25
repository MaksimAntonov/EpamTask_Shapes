package by.antonov.shapes.reader;

import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.validator.CustomFileValidator;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomReader {

  private static final Logger logger = LogManager.getLogger();

  public List<String> readDataFromFile(String filename) throws CustomException {
    logger.info("Reading a data file " + filename);
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

    if (inputStream == null) {
      throw new CustomException("Can not find file " + filename);
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    List<String> correctStrings = reader.lines()
        .filter(CustomFileValidator::rowValidator)
        .collect(Collectors.toList());

    logger.info("Reading a data file " + filename + " finished. String list: " + correctStrings);
    return correctStrings;
  }
}
