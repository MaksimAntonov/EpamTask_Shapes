package by.antonov.shapes.observer.impl;

import by.antonov.shapes.action.CubeAction;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.observer.CubeEvent;
import by.antonov.shapes.observer.Observer;
import by.antonov.shapes.warehouse.CubeWarehouse;

public class CubeObserver implements Observer {
    @Override
    public void parameterChanged(CubeEvent event) {
        Cube cube = event.getSource();
        CubeAction cubeAction = new CubeAction();
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        CubeProperties cubeProperties = cubeWarehouse.getProperty(cube.getId());

        double volume = cubeAction.calculateCubeVolume(cube);
        cubeProperties.setVolume(volume);
        double sideSquare = cubeAction.calculateCubeSideSquare(cube);
        cubeProperties.setSideSquare(sideSquare);
        double cubeSquare = cubeAction.calculateCubeSquare(cube);
        cubeProperties.setCubeSquare(cubeSquare);

        cubeWarehouse.setProperty(cube.getId(), cubeProperties);
    }
}
