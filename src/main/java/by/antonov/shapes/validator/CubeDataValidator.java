package by.antonov.shapes.validator;

public class CubeDataValidator {

  private static final String COORDINATE_REGEXP = "^(-?\\d+(.\\d+)?)$";
  private static final String SIDE_LENGTH_REGEXP = "^(\\d+(.\\d+)?)$";

  private CubeDataValidator() {
  }

  public static boolean isCoordinate(String stringForCheck) {
    return stringForCheck.matches(COORDINATE_REGEXP);
  }

  public static boolean isSideLength(String stringForCheck) {
    return stringForCheck.matches(SIDE_LENGTH_REGEXP);
  }
}
