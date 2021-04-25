package by.antonov.shapes.warehouse;

import by.antonov.shapes.entity.CubeProperties;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeWarehouse {

  private static final Logger logger = LogManager.getLogger();

  private static final CubeWarehouse INSTANCE = new CubeWarehouse();
  private final Map<Long, CubeProperties> mapCube = new HashMap<>();

  private CubeWarehouse() {
  }

  public static CubeWarehouse getInstance() {
    return INSTANCE;
  }

  public CubeProperties getProperty(long id) {
    CubeProperties properties = mapCube.get(id);
    logger.info("Get property id=" + id + " from Warehouse " + properties.toString());
    return mapCube.get(id);
  }

  public void setProperty(long id, CubeProperties cubeProperties) {
    logger.info("Set property id=" + id + " to Warehouse " + cubeProperties.toString());
    mapCube.put(id, cubeProperties);
  }
}
