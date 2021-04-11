package by.antonov.shapes.warehouse;

import by.antonov.shapes.entity.CubeProperties;

import java.util.Map;

public class CubeWarehouse {
    private static CubeWarehouse INSTANCE = new CubeWarehouse();
    private Map<Long, CubeProperties> mapCube;

    private CubeWarehouse() {}

    public static CubeWarehouse getInstance() {
        return INSTANCE;
    }

    public CubeProperties getProperty(long id) {
        return mapCube.get(id);
    }

    public void setProperty(long id, CubeProperties cubeProperties) {
        mapCube.put(id, cubeProperties);
    }
}
