package by.antonov.shapes.observer.impl;

import by.antonov.shapes.action.CubeAction;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.observer.CubeEvent;
import by.antonov.shapes.observer.Observer;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserver implements Observer {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(CubeEvent event) {
        Cube cube = event.getSource();
        logger.info("Element " + cube.getId() + " was changed.");
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        CubeProperties cubeProperties = cubeWarehouse.getProperty(cube.getId());

        double volume = CubeAction.calculateCubeVolume(cube);
        cubeProperties.setVolume(volume);
        double sideSquare = CubeAction.calculateCubeSideSquare(cube);
        cubeProperties.setSideSquare(sideSquare);
        double cubeSquare = CubeAction.calculateCubeSquare(cube);
        cubeProperties.setCubeSquare(cubeSquare);
        Point oppositePoint = CubeAction.calculateOppositePoint(cube);
        cubeProperties.setOppositePoint(oppositePoint);

        cubeWarehouse.setProperty(cube.getId(), cubeProperties);
    }
}
