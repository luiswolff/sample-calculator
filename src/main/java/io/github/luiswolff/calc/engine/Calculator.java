package io.github.luiswolff.calc.engine;

public interface Calculator {

  void append(Digit digit);

  void appendDecimalPlace();

  void define(Operation operation);

  void equals();

  void clear();

  String getDisplay();
}
