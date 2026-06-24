package io.github.luiswolff.calc.engine;

public enum Digit {
  ZERO('0'),
  ONE('1'),
  TWO('2'),
  THREE('3'),
  FOUR('4'),
  FIVE('5'),
  SIX('6'),
  SEVEN('7'),
  EIGHT('8'),
  NINE('9')
  ;

  private final char c;

  Digit(char c) {
    this.c = c;
  }

  Float append(Float term) {
    return Float.parseFloat(Integer.toString(term.intValue()) + c);
  }

  @Override
  public String toString() {
    return Character.toString(c);
  }
}
