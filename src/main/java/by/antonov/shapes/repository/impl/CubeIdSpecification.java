package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.repository.Specification;

public class CubeIdSpecification implements Specification {

  private final long id;

  public CubeIdSpecification(long id) {
    this.id = id;
  }

  @Override
  public boolean specify(Cube cube) {
    return (cube.getId() == this.id);
  }
}
