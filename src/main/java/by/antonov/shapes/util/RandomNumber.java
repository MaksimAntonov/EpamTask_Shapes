package by.antonov.shapes.util;

public class RandomNumber {
    private RandomNumber() {};

    public static int getRandomIntFromRange(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
