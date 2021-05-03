package by.antonov.shapes.repository;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.exception.CustomException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CubeRepository {
  private static final CubeRepository instance = new CubeRepository();
  private final Map<Long, Cube> cubes = new HashMap<>();

  private CubeRepository() {
  }

  public static CubeRepository getInstance() {
    return instance;
  }

  public void add(Cube cube) {
    cubes.put(cube.getId(), cube);
  }

  public void addAll(Collection<Cube> cubeCollection) {
    cubeCollection.forEach(cube -> cubes.put(cube.getId(), cube));
  }

  public void remove(Long cubeId) {
    cubes.remove(cubeId);
  }

  public void removeAll(Collection<Cube> cubeCollection) {
    cubeCollection.forEach(cube -> cubes.remove(cube.getId()));
  }

  // For tests
  void clear() {
    cubes.clear();
  }

  public Cube getItem(Long cubeId) throws CustomException {
    Cube cube = cubes.get(cubeId);
    if (cube == null) {
      throw new CustomException("Cube with id=" + cubeId + " isn't registered");
    }

    return cube;
  }

  public Collection<Cube> getAll() {
    return Collections.unmodifiableCollection(cubes.values());
  }

  public List<Cube> query(Predicate<Cube> specification) {
    List<Cube> queryList = new ArrayList<>();
    for (Cube cube : cubes.values()) {
      if (specification.test(cube)) {
        queryList.add(cube);
      }
    }

    return queryList;
  }

  public List<Cube> queryStream(Predicate<Cube> specification) {
    return cubes.values().stream().filter(specification).collect(Collectors.toList());
  }

  public List<Cube> sort(Comparator<Cube> comparator) {
    return cubes.values().stream().sorted(comparator).collect(Collectors.toList());
  }
}
