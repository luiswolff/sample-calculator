package io.github.luiswolff.calc.engine;

import java.math.BigDecimal;

public enum Operation {
  ADDING("+") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      return leftTerm.add(rightTerm);
    }
  },
  SUBTRACTING("-") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      return leftTerm.subtract(rightTerm);
    }
  },
  MULTIPLYING("*") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      return leftTerm.multiply(rightTerm);
    }
  },
  DIVIDING("/") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      //noinspection BigDecimalMethodWithoutRoundingCalled
      return leftTerm.divide(rightTerm);
    }
  };
  private final String appearance;

  Operation(String appearance) {
    this.appearance = appearance;
  }

  abstract BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm);

  @Override
  public String toString() {
    return appearance;
  }
}
