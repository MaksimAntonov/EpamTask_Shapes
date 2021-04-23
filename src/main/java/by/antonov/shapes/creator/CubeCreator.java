package by.antonov.shapes.creator;

import by.antonov.shapes.action.CubeAction;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.entity.Point;
import by.antonov.shapes.observer.impl.CubeObserver;
import by.antonov.shapes.repository.CubeRepository;
import by.antonov.shapes.warehouse.CubeWarehouse;

public class CubeCreator {
    private static Cube currentElement;

    private CubeCreator() {}

    public static CubeCreator getCreator() {
        return new CubeCreator();
    }

    public CubeCreator doWith(Cube cube) {
        currentElement = cube;
        return this;
    }

    public CubeCreator addToRepository() {
        CubeRepository repository = CubeRepository.getInstance();
        repository.add(currentElement);

        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        double cubeVolume = CubeAction.calculateCubeVolume(currentElement);
        double cubeSideSquare = CubeAction.calculateCubeSideSquare(currentElement);
        double cubeSquare = CubeAction.calculateCubeSquare(currentElement);
        Point oppositePoint = CubeAction.calculateOppositePoint(currentElement);

        CubeProperties cubeProperties = new CubeProperties(currentElement.getId(), cubeVolume, cubeSideSquare, cubeSquare, oppositePoint);
        cubeWarehouse.setProperty(currentElement.getId(), cubeProperties);

        return this;
    }

    public CubeCreator attacheObserver() {
        CubeObserver cubeObserver = new CubeObserver();

        currentElement.attach(cubeObserver);
        return this;
    }
}
