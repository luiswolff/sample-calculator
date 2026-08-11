package io.github.luiswolff.calc.engine;

public enum Digit {
  ZERO(0f),
  ONE(1f),
  TWO(2f),
  THREE(3f),
  FOUR(4f),
  FIVE(5f),
  SIX(6f),
  SEVEN(7f),
  EIGHT(8f),
  NINE(9f)
  ;

  private final float number;

  Digit(float number) {
    this.number = number;
  }

  Float append(Float term, Short decimalPlace) {
    return (float) (term * (decimalPlace == 0 ? 10 : 1) + number / Math.pow(10, decimalPlace));
  }

  @Override
  public String toString() {
    return String.format("%.0f", number);
  }
}
