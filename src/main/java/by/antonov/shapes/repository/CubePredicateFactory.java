package by.antonov.shapes.repository;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.warehouse.CubeWarehouse;

import java.util.function.Function;
import java.util.function.Predicate;

public class CubePredicateFactory {
    public static Predicate<Cube> forID(long value) {
        return (cube) -> cube.getId() == value;
    }

    // the same
    public static <T extends Comparable<T>> Predicate<T> valueEqualTo(T equalValue) {
        return value -> value.compareTo(equalValue) == 0;
    }

    public static <T extends Comparable<T>> Predicate<T> valueLessThen(T max) {
        return value -> value.compareTo(max) <= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> valueMoreThen(T min) {
        return value -> value.compareTo(min) >= 0;
    }

    public static Predicate<Cube> forCubeProperties(Predicate<CubeProperties> cubePropertiesPredicate) {
        return (cube) -> {
            CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());
            return cubePropertiesPredicate.test(cubeProperties);
        };
    }

    public static <T, K> Predicate<K> createPredicate(Function<K, T> fieldExtractor, Predicate<T> predicate) {
        return value -> predicate.test(fieldExtractor.apply(value));
    }

    public static <T, K extends Comparable<K>> Predicate<Cube> lessThen(double value, Function<Cube, Double> function) {
        return (cube) -> function.apply(cube) <= value;
    }

    public static Predicate<Cube> moreThen(double value, Function<Cube, Double> function) {
        return (cube) -> function.apply(cube) >= value;
    }

    public static Predicate<Cube> range(double min, double max, Function<Cube, Double> function) {
        return lessThen(max, function).and(moreThen(min, function));
    }
}
