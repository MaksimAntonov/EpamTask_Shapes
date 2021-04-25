package by.antonov.shapes.registrator;

import by.antonov.shapes.action.CubeAction;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.observer.impl.CubeObserver;
import by.antonov.shapes.repository.CubeRepository;
import by.antonov.shapes.warehouse.CubeWarehouse;

public class CubeRegistrator {

  private final Cube currentElement;

  private CubeRegistrator(Cube cube) {
    this.currentElement = cube;
  }

  public static CubeRegistrator newCreatorFor(Cube cube) {
    return new CubeRegistrator(cube);
  }

  public CubeRegistrator addToRepository() {
    CubeRepository repository = CubeRepository.getInstance();
    repository.add(currentElement);

    CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
    cubeWarehouse.setProperty(currentElement.getId(), CubeAction.calculateProperties(currentElement));

    return this;
  }

  public CubeRegistrator attacheObserver() {
    CubeObserver cubeObserver = new CubeObserver();

    currentElement.attach(cubeObserver);
    return this;
  }
}
