package io.github.luiswolff.calc.commands;

class SimpleCalculator {

  private Float leftTerm;
  private Operation operation;
  private Float rightTerm;
  private Float result;

  SimpleCalculator() {
    clear();
  }

  void append(String number) {
    if (operation == null) {
      leftTerm = Float.parseFloat(leftTerm.intValue() + number);
    } else {
      rightTerm = Float.parseFloat(rightTerm.intValue() + number);
    }
  }

  void define(Operation operation) {
    this.operation = operation;
    rightTerm = 0f;
  }

  void equals() {
    if (operation != null) {
      result = operation.perform(result == null ? leftTerm : result, rightTerm);
    }
  }

  void clear() {
    leftTerm = 0f;
    operation = null;
    rightTerm = null;
    result = null;
  }

  String getDisplay() {
    return (result != null ? result
        : operation == null || rightTerm == 0f ? leftTerm : rightTerm).toString();
  }
}
