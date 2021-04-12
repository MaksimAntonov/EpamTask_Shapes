package by.antonov.shapes.repository;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.exception.CustomException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository {
    private static CubeRepository instance;
    private List<Cube> cubeList;

    private CubeRepository() {}

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepository();
        }
        return instance;
    }

    public void add(Cube cube) {
        cubeList.add(cube);
    }

    public void addAll(Collection<Cube> cubeCollection) {
        cubeList.addAll(cubeCollection);
    }

    public void remove(Cube cube) {
        cubeList.remove(cube);
    }

    public void removeAll(Collection<Cube> cubeCollection) {
        cubeList.removeAll(cubeCollection);
    }

    public Cube getItem(int index) throws CustomException {
        int cubeListSize = cubeList.size();
        if (index < 0 || index >= cubeListSize) {
            throw new CustomException("Index " + index + " for getItem out of range [0, " + cubeListSize +"]");
        }
        return cubeList.get(index);
    }

    public void setItem(int index, Cube cube) {
        cubeList.set(index, cube);
    }

    public List<Cube> getCubeList() {
        return new ArrayList<>(this.cubeList);
    }

    public List<Cube> query(Specification specification) {
        List<Cube> queryList = new ArrayList<>();
        for (Cube cube : cubeList) {
            if (specification.specify(cube)) {
                queryList.add(cube);
            }
        }

        return queryList;
    }

    public List<Cube> queryStream(Specification specification) {
        List<Cube> queryList = cubeList.stream().filter(specification::specify).collect(Collectors.toList());
        return queryList;
    }
}
