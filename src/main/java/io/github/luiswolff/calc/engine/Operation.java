package io.github.luiswolff.calc.engine;

import java.math.BigDecimal;

public enum Operation {
  ADDING("+") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      return leftTerm.add(rightTerm);
    }

    @Override
    int perform(int leftTerm, int rightTerm) {
      return leftTerm + rightTerm;
    }
  },
  SUBTRACTING("-") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      return leftTerm.subtract(rightTerm);
    }

    @Override
    int perform(int leftTerm, int rightTerm) {
      return leftTerm - rightTerm;
    }
  },
  MULTIPLYING("*") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      return leftTerm.multiply(rightTerm);
    }

    @Override
    int perform(int leftTerm, int rightTerm) {
      return leftTerm * rightTerm;
    }
  },
  DIVIDING("/") {
    @Override
    BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm) {
      //noinspection BigDecimalMethodWithoutRoundingCalled
      return leftTerm.divide(rightTerm);
    }

    @Override
    int perform(int leftTerm, int rightTerm) {
      return leftTerm / rightTerm;
    }
  };
  private final String appearance;

  Operation(String appearance) {
    this.appearance = appearance;
  }

  abstract BigDecimal perform(BigDecimal leftTerm, BigDecimal rightTerm);
  abstract int perform(int leftTerm, int rightTerm);

  @Override
  public String toString() {
    return appearance;
  }
}
