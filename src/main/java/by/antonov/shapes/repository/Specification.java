package by.antonov.shapes.repository;

import by.antonov.shapes.entity.Cube;

public interface Specification {
    boolean specify(Cube cube);
}
