package io.github.luiswolff.calc.commands;

public interface CalculatorPanel {
  void setRowCount(int rows);
  void setColumnCount(int columns);
  void populateCommand(CalculationCommand command);
}
