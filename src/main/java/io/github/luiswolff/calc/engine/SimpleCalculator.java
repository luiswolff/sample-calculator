package io.github.luiswolff.calc.engine;

import java.math.BigDecimal;

public class SimpleCalculator {

  private BigDecimal leftTerm;
  private Operation operation;
  private BigDecimal rightTerm;
  private BigDecimal result;
  private Integer decimalPlace;

  public SimpleCalculator() {
    clear();
  }

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

  private BigDecimal append(Digit digit, BigDecimal term) {
    return decimalPlace == null ?
        digit.appendIntegerPart(term)
        : digit.appendFractionalPart(term, decimalPlace++);
  }

  public void appendDecimalPlace() {
    if (decimalPlace == null) {
      decimalPlace = 1;
    }
  }

  public void define(Operation operation) {
    if (this.operation != null) {
      leftTerm = operation.perform(leftTerm, rightTerm);
    }
    this.operation = operation;
    rightTerm = BigDecimal.ZERO;
    decimalPlace = null;
  }

  public void equals() {
    if (operation != null) {
      result = operation.perform(result == null ? leftTerm : result, rightTerm);
    }
    decimalPlace = null;
  }

  public void clear() {
    leftTerm = BigDecimal.ZERO;
    operation = null;
    rightTerm = null;
    result = null;
    decimalPlace = null;
  }

  public String getDisplay() {
    BigDecimal displayValue;
    if (result != null) {
      displayValue = result;
    } else if (operation == null || rightTerm.compareTo(BigDecimal.ZERO) == 0) {
      displayValue = leftTerm;
    } else {
      displayValue = rightTerm;
    }
    // using toString from Float because JUnit-Tests are based on this formatter logic
    return Float.toString(displayValue.floatValue());
  }
}
