package by.antonov.shapes.warehouse;

import by.antonov.shapes.entity.CubeProperty;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeWarehouse {
  private static final Logger logger = LogManager.getLogger();

  private static final CubeWarehouse instance = new CubeWarehouse();
  private final Map<Long, CubeProperty> mapCube = new HashMap<>();

  private CubeWarehouse() {
  }

  public static CubeWarehouse getInstance() {
    return instance;
  }

  public CubeProperty getProperty(long id) {
    CubeProperty properties = mapCube.get(id);
    logger.info("Get property id=" + id + " from Warehouse " + properties.toString());
    return mapCube.get(id);
  }

  public void setProperty(long id, CubeProperty cubeProperty) {
    logger.info("Set property id=" + id + " to Warehouse " + cubeProperty.toString());
    mapCube.put(id, cubeProperty);
  }
}
