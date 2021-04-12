package by.antonov.shapes.warehouse;

import by.antonov.shapes.entity.CubeProperties;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse {
    private static final CubeWarehouse instance = new CubeWarehouse();
    private final Map<Long, CubeProperties> mapCube;

    private CubeWarehouse() {
        this.mapCube = new HashMap<>();
    }

    public static CubeWarehouse getInstance() {
        return instance;
    }

    public CubeProperties getProperty(long id) {
        return mapCube.get(id);
    }

    public void setProperty(long id, CubeProperties cubeProperties) {
        mapCube.put(id, cubeProperties);
    }
}
