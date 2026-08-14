package io.github.luiswolff.calc.engine;

import java.math.BigDecimal;

public enum Digit {
  ZERO(0L),
  ONE(1L),
  TWO(2L),
  THREE(3L),
  FOUR(4L),
  FIVE(5L),
  SIX(6L),
  SEVEN(7L),
  EIGHT(8L),
  NINE(9L)
  ;

  private final long number;

  Digit(long number) {
    this.number = number;
  }

  BigDecimal appendIntegerPart(BigDecimal term) {
    return term.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(number));
  }

  BigDecimal appendFractionalPart(BigDecimal term, Integer decimalPlace) {
    return  term.add(BigDecimal.valueOf(number, decimalPlace));
  }

  @Override
  public String toString() {
    return Long.toString(number);
  }
}
