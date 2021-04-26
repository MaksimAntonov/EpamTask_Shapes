package by.antonov.shapes.observer.impl;

import by.antonov.shapes.action.CubeAction;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.observer.CubeEvent;
import by.antonov.shapes.observer.CubeObserver;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserverImpl implements CubeObserver {

  private static final Logger logger = LogManager.getLogger();

  @Override
  public void parameterChanged(CubeEvent event) {
    Cube cube = event.getSource();
    CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
    CubeProperties oldProperties = cubeWarehouse.getProperty(cube.getId());
    CubeProperties newProperties = CubeAction.calculateProperties(cube);
    logger.info("Element " + cube.getId() + " was changed from " + oldProperties + " to " + newProperties);
    cubeWarehouse.setProperty(cube.getId(), newProperties);
  }
}
