package io.github.luiswolff.calc.commands;

public interface CalculationCommand {
  void execute();
  String appearance();
  default int width() {
    return 1;
  }
  default int height() {
    return 1;
  }
}
