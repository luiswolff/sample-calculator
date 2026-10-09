package io.github.luiswolff.calc.engine;

public class IntCalculator implements Calculator {

  private final int radix;

  private Integer leftTerm;
  private Operation operation;
  private Integer rightTerm;
  private Integer result;

  public IntCalculator(int radix) {
    if (radix > Digit.values().length) {
      throw new IllegalArgumentException(
          "radix must be smaller or equals " + Digit.values().length);
    }
    this.radix = radix;
    clear();
  }

  @Override
  public void append(Digit digit) {
    if (result != null) {
      clear();
    }
    if (operation == null) {
      leftTerm = append(digit, leftTerm);
    } else {
      rightTerm = append(digit, rightTerm);
    }
  }

  @Override
  public void appendDecimalPlace() {
    throw new UnsupportedOperationException("DecimalPlaces are undefined for integer calculation");
  }

  private Integer append(Digit digit, Integer term) {
    return digit.append(term, radix);
  }

  @Override
  public void define(Operation operation) {
    if (this.operation != null) {
      leftTerm = operation.perform(leftTerm, rightTerm);
    }
    this.operation = operation;
    rightTerm = 0;
  }

  @Override
  public void equals() {
    if (operation != null) {
      result = operation.perform(result == null ? leftTerm : result, rightTerm);
    }
  }

  @Override
  public void clear() {
    leftTerm = 0;
    operation = null;
    rightTerm = null;
    result = null;
  }

  @Override
  public String getDisplay() {
    Integer displayValue;
    if (result != null) {
      displayValue = result;
    } else if (operation == null || rightTerm == 0) {
      displayValue = leftTerm;
    } else {
      displayValue = rightTerm;
    }
    return Integer.toString(displayValue, radix);
  }
}
