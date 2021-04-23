package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.exception.CustomException;
import by.antonov.shapes.repository.Specification;
import by.antonov.shapes.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeSpecification implements Specification {
    private final Logger logger = LogManager.getLogger();

    private final double minVolume;
    private final double maxVolume;

    private CubeVolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    public static CubeVolumeSpecification lessThen(double maxVolume) {
        return new CubeVolumeSpecification(0, maxVolume);
    }

    public static CubeVolumeSpecification moreThen(double minVolume) {
        return new CubeVolumeSpecification(minVolume, Double.MAX_VALUE);
    }

    public static CubeVolumeSpecification range(double minVolume, double maxVolume) {
        return new CubeVolumeSpecification(minVolume, maxVolume);
    }

    @Override
    public boolean specify(Cube cube) {
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        CubeProperties cubeProperties = cubeWarehouse.getProperty(cube.getId());

        double volume = cubeProperties.getVolume();
        return ((volume >= minVolume) && (volume <= maxVolume));
    }
}
