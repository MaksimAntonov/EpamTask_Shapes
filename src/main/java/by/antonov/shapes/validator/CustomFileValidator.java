package by.antonov.shapes.validator;

public class CustomFileValidator {

  private static final String ROW_REGEXP = "^(-?\\d+(\\.\\d+)?)\\s(-?\\d+(\\.\\d+)?)\\s(-?\\d+(\\.\\d+)?)\\s(\\d+(\\.\\d+)?)$";

  private CustomFileValidator() {
  }

  public static boolean rowValidator(String row) {
    return row.matches(ROW_REGEXP);
  }
}
