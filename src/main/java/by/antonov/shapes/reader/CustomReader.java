package by.antonov.shapes.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.validator.CustomFileValidator;

public class CustomReader {
    static Logger logger = LogManager.getLogger();

    public List<String> readDataFromFile(String filename) throws CustomException {
        logger.info("Reading a data file " + filename);
        List<String> stringList = new ArrayList<>();
        Path path = createPathForFile(filename);

        BufferedReader reader;
        try {
            reader = Files.newBufferedReader(path);
            Stream<String> stream = reader.lines();
            stream.forEach((s) -> {
                if (CustomFileValidator.rowValidator(s)) {
                    stringList.add(s);
                }
            });
        } catch (IOException e) {
            logger.error("Can't read file " + filename + " error: " + e.getMessage());
            throw new CustomException("Can't read file " + filename, e);
        }

        logger.info("Reading a data file " + filename + " finished. String list: " + stringList.toString());
        return stringList;
    }

    private Path createPathForFile(String filename) throws CustomException {
        URI uri;
        try {
            uri = getClass().getResource(filename).toURI();
        } catch (NullPointerException e) {
            throw new CustomException("CustomReader: URI is null");
        } catch (URISyntaxException e) {
            throw new CustomException("CustomReader: Can't convert URL to URI.");
        }
        String absolutePathToFile = new File(uri).getAbsolutePath();
        Path path;
        try {
            path = Paths.get(absolutePathToFile);
        } catch (InvalidPathException e) {
            throw new CustomException("CustomReader: Path string can't be converted to Path object");
        }
        return path;
    }
}
