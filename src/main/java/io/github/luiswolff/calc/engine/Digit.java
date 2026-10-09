package io.github.luiswolff.calc.engine;

import java.math.BigDecimal;

public enum Digit {
  ZERO(0x0),
  ONE(0x1),
  TWO(0x2),
  THREE(0x3),
  FOUR(0x4),
  FIVE(0x5),
  SIX(0x6),
  SEVEN(0x7),
  EIGHT(0x8),
  NINE(0x9),
  A(0xA),
  B(0xB),
  C(0xC),
  D(0xD),
  E(0xE),
  F(0xF),
  ;

  private final long number;

  Digit(long number) {
    this.number = number;
  }

  BigDecimal appendIntegerPart(BigDecimal term) {
    return term.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(number));
  }

  int append(int term, int radix) {
    return Math.toIntExact((long) term * radix + number);
  }

  BigDecimal appendFractionalPart(BigDecimal term, Integer decimalPlace) {
    return  term.add(BigDecimal.valueOf(number, decimalPlace));
  }

  @Override
  public String toString() {
    return Long.toString(number, values().length).toUpperCase();
  }
}
