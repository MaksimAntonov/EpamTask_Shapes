package by.antonov.shapes.util;

public class IdGenerator {

  private static long uniqueID = 1;

  private IdGenerator() {
  }

  public static long generateID() {
    return uniqueID++;
  }
}
