package by.antonov.shapes.repository.impl;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.repository.CubeSpecification;

public class CubeIdSpecificationImpl implements CubeSpecification {

  private final long id;

  public CubeIdSpecificationImpl(long id) {
    this.id = id;
  }

  @Override
  public boolean test(Cube cube) {
    return (cube.getId() == this.id);
  }
}
