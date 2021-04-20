package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.repository.Specification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeSideSquareSpecification implements Specification {
    private final Logger logger = LogManager.getLogger();

    private final double minSideSquare;
    private final double maxSideSquare;

    private CubeSideSquareSpecification(double minSideSquare, double maxSideSquare) {
        this.minSideSquare = minSideSquare;
        this.maxSideSquare = maxSideSquare;
    }

    public static CubeSideSquareSpecification lessThen(double maxSideSquare) {
        return new CubeSideSquareSpecification(0, maxSideSquare);
    }

    public static CubeSideSquareSpecification moreThen(double minSideSquare) {
        return new CubeSideSquareSpecification(minSideSquare, Double.MAX_VALUE);
    }

    public static CubeSideSquareSpecification range(double minSideSquare, double maxSideSquare) {
        return new CubeSideSquareSpecification(minSideSquare, maxSideSquare);
    }

    @Override
    public boolean specify(Cube cube) {
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        boolean result = false;
        try {
            CubeProperties cubeProperties = cubeWarehouse.getProperty(cube.getId());

            double sideSquare = cubeProperties.getSideSquare();
            result = ((sideSquare > minSideSquare) && (sideSquare < maxSideSquare));
        } catch (CustomException e) {
            logger.warn("Element with id=" + cube.getId() + " doesn't exist in CubeWarehouse.");
        }
        return result;
    }
}
