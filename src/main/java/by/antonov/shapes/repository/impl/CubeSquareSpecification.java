package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.repository.Specification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeSquareSpecification implements Specification {
    private final Logger logger = LogManager.getLogger();

    private final double minCubeSquare;
    private final double maxCubeSquare;

    private CubeSquareSpecification(double minCubeSquare, double maxCubeSquare) {
        this.minCubeSquare = minCubeSquare;
        this.maxCubeSquare = maxCubeSquare;
    }

    public static CubeSquareSpecification lessThen(double maxCubeSquare) {
        return new CubeSquareSpecification(0, maxCubeSquare);
    }

    public static CubeSquareSpecification moreThen(double minCubeSquare) {
        return new CubeSquareSpecification(minCubeSquare, Double.MAX_VALUE);
    }

    public static CubeSquareSpecification range(double minCubeSquare, double maxCubeSquare) {
        return new CubeSquareSpecification(minCubeSquare, maxCubeSquare);
    }

    @Override
    public boolean specify(Cube cube) {
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        boolean result = false;
        try {
            CubeProperties cubeProperties = cubeWarehouse.getProperty(cube.getId());

            double cubeSquare = cubeProperties.getCubeSquare();
            result = ((cubeSquare > minCubeSquare) && (cubeSquare < maxCubeSquare));
        } catch (CustomException e) {
            logger.warn("Element with id=" + cube.getId() + " doesn't exist in CubeWarehouse.");
        }

        return result;
    }
}
