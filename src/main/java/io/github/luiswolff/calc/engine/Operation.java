package io.github.luiswolff.calc.engine;

import java.math.BigDecimal;

public enum Operation {
  ADDING("+") {
    @Override
    Float perform(Float leftTerm, Float rightTerm) {
      return leftTerm + rightTerm;
    }
  },
  SUBTRACTING("-") {
    @Override
    Float perform(Float leftTerm, Float rightTerm) {
      return leftTerm - rightTerm;
    }
  },
  MULTIPLYING("*") {
    @Override
    Float perform(Float leftTerm, Float rightTerm) {
      return leftTerm * rightTerm;
    }
  },
  DIVIDING("/") {
    @Override
    Float perform(Float leftTerm, Float rightTerm) {
      return leftTerm / rightTerm;
    }
  };
  private final String appearance;

  Operation(String appearance) {
    this.appearance = appearance;
  }

  abstract Float perform(Float leftTerm, Float rightTerm);

  @Override
  public String toString() {
    return appearance;
  }
}
