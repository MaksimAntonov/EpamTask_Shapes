package by.antonov.shapes.action;

import by.antonov.shapes.comparator.CubeComparator;
import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.repository.CubeRepository;

import java.util.List;

public class CubeSort {
    private final CubeRepository repository = CubeRepository.getInstance();

    public List<Cube> sortById() {
        List<Cube> cubeList = repository.getCubeList();
        cubeList.sort(CubeComparator.ID);
        return cubeList;
    }

    public List<Cube> sortByCoordinateX() {
        List<Cube> cubeList = repository.getCubeList();
        cubeList.sort(CubeComparator.COORDINATE_X);
        return cubeList;
    }

    public List<Cube> sortByCoordinateY() {
        List<Cube> cubeList = repository.getCubeList();
        cubeList.sort(CubeComparator.COORDINATE_Y);
        return cubeList;
    }

    public List<Cube> sortByCoordinateZ() {
        List<Cube> cubeList = repository.getCubeList();
        cubeList.sort(CubeComparator.COORDINATE_Z);
        return cubeList;
    }
}
