package by.antonov.shapes.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.validator.CustomFileValidator;

public class CustomReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readDataFromFile(String filename) throws CustomException {
        logger.info("Reading a data file " + filename);
        List<String> stringList = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new CustomException("Can't find file " + filename);
        }

        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        Stream<String> stream = reader.lines();
        stream.forEach((s) -> {
            if (CustomFileValidator.rowValidator(s)) {
                stringList.add(s);
            }
        });

        logger.info("Reading a data file " + filename + " finished. String list: " + stringList);
        return stringList;
    }
}
