package by.antonov.shapes.warehouse;

import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse {
    private static final Logger logger = LogManager.getLogger();

    private static final CubeWarehouse instance = new CubeWarehouse();
    private final Map<Long, CubeProperties> mapCube;

    private CubeWarehouse() {
        this.mapCube = new HashMap<>();
    }

    public static CubeWarehouse getInstance() {
        return instance;
    }

    public CubeProperties getProperty(long id) throws CustomException {
        if (!mapCube.containsKey(id)) {
            throw new CustomException("Element with key = " + id + " doesn't exist");
        }
        CubeProperties properties = mapCube.get(id);
        logger.info("Get property id=" + id + " from Warehouse " + properties.toString());
        return mapCube.get(id);
    }

    public void setProperty(long id, CubeProperties cubeProperties) {
        logger.info("Set property id=" + id + " to Warehouse " + cubeProperties.toString());
        mapCube.put(id, cubeProperties);
    }
}
