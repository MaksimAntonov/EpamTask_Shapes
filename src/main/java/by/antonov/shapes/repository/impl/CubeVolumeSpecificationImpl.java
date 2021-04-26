package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.repository.CubeSpecification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeSpecificationImpl implements CubeSpecification {

  private final Logger logger = LogManager.getLogger();

  private final double minVolume;
  private final double maxVolume;

  private CubeVolumeSpecificationImpl(double minVolume, double maxVolume) {
    this.minVolume = minVolume;
    this.maxVolume = maxVolume;
  }

  public static CubeVolumeSpecificationImpl lessThen(double maxVolume) {
    return new CubeVolumeSpecificationImpl(0, maxVolume);
  }

  public static CubeVolumeSpecificationImpl moreThen(double minVolume) {
    return new CubeVolumeSpecificationImpl(minVolume, Double.MAX_VALUE);
  }

  public static CubeVolumeSpecificationImpl range(double minVolume, double maxVolume) {
    return new CubeVolumeSpecificationImpl(minVolume, maxVolume);
  }

  @Override
  public boolean test(Cube cube) {
    CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
    CubeProperties cubeProperties = cubeWarehouse.getProperty(cube.getId());

    double volume = cubeProperties.getVolume();
    return ((volume >= minVolume) && (volume <= maxVolume));
  }
}
