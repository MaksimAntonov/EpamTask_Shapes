package by.antonov.shapes.repository;

import by.antonov.shapes.entity.Cube;
import by.antonov.shapes.entity.CubeProperties;
import by.antonov.shapes.warehouse.CubeWarehouse;

import java.util.function.Function;
import java.util.function.Predicate;

public class CubePredicateFactory {
    // Primitive predicates
    public static <T extends Comparable<T>> Predicate<T> valueEqualTo(T equalValue) {
        return value -> value.compareTo(equalValue) == 0;
    }

    public static <T extends Comparable<T>> Predicate<T> valueLessThen(T max) {
        return value -> value.compareTo(max) <= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> valueMoreThen(T min) {
        return value -> value.compareTo(min) >= 0;
    }

    // Predicate for elements from Warehouse
    public static Predicate<Cube> forCubeProperties(Predicate<CubeProperties> cubePropertiesPredicate) {
        return (cube) -> {
            CubeProperties cubeProperties = CubeWarehouse.getInstance().getProperty(cube.getId());
            return cubePropertiesPredicate.test(cubeProperties);
        };
    }

    // Main predicate creator
    public static <T, K> Predicate<K> createPredicate(Function<K, T> fieldExtractor, Predicate<T> predicate) {
        return value -> predicate.test(fieldExtractor.apply(value));
    }
}
