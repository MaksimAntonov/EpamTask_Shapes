package by.antonov.shapes.repository;

import by.antonov.shapes.entity.Cube;

import java.util.function.Function;
import java.util.function.Predicate;

public class CubePredicateFactory {
    public static Predicate<Cube> forID(long value) {
        return (cube) -> cube.getId() == value;
    }

    public static Predicate<Cube> lessThen(double value, Function<Cube, Double> function) {
        return (cube) -> function.apply(cube) <= value;
    }

    public static Predicate<Cube> moreThen(double value, Function<Cube, Double> function) {
        return (cube) -> function.apply(cube) >= value;
    }

    public static Predicate<Cube> range(double min, double max, Function<Cube, Double> function) {
        return lessThen(max, function).and(moreThen(min, function));
    }
}
