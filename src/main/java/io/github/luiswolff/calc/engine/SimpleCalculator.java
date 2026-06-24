package io.github.luiswolff.calc.engine;

public class SimpleCalculator {

  private Float leftTerm;
  private Operation operation;
  private Float rightTerm;
  private Float result;

  public SimpleCalculator() {
    clear();
  }

  public void append(Digit digit) {
    if (result != null) {
      clear();
    }
    if (operation == null) {
      leftTerm = digit.append(leftTerm);
    } else {
      rightTerm = digit.append(rightTerm);
    }
  }

  public void define(Operation operation) {
    if (this.operation != null) {
      leftTerm = operation.perform(leftTerm, rightTerm);
    }
    this.operation = operation;
    rightTerm = 0f;
  }

  public void equals() {
    if (operation != null) {
      result = operation.perform(result == null ? leftTerm : result, rightTerm);
    }
  }

  public void clear() {
    leftTerm = 0f;
    operation = null;
    rightTerm = null;
    result = null;
  }

  public String getDisplay() {
    return (result != null ? result
        : operation == null || rightTerm == 0f ? leftTerm : rightTerm).toString();
  }
}
