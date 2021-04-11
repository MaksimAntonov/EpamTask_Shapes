package by.antonov.shapes.util;

public class IdGenerator {
    private static long uniqueID = 1;

    public static long generateID() {
        return uniqueID++;
    }
}
