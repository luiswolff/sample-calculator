package io.github.luiswolff.calc.commands;

public class SimpleCalculatorClient {

  public static void configure(CalculatorPanel panel) {
    panel.setRowCount(4);
    panel.setColumnCount(4);

    var simpleCalculator = new SimpleCalculator();

    // Top Row
    panel.populateCommand(new NumberCommand("7", simpleCalculator));
    panel.populateCommand(new NumberCommand("8", simpleCalculator));
    panel.populateCommand(new NumberCommand("9", simpleCalculator));
    panel.populateCommand(new OperationCommand(Operation.DIVIDING, simpleCalculator));

    // Upper middle row
    panel.populateCommand(new NumberCommand("4", simpleCalculator));
    panel.populateCommand(new NumberCommand("5", simpleCalculator));
    panel.populateCommand(new NumberCommand("6", simpleCalculator));
    panel.populateCommand(new OperationCommand(Operation.MULTIPLYING, simpleCalculator));

    // Under middle row
    panel.populateCommand(new NumberCommand("1", simpleCalculator));
    panel.populateCommand(new NumberCommand("2", simpleCalculator));
    panel.populateCommand(new NumberCommand("3", simpleCalculator));
    panel.populateCommand(new OperationCommand(Operation.SUBTRACTING, simpleCalculator));

    // Bottom row
    panel.populateCommand(new ClearCommand(simpleCalculator));
    panel.populateCommand(new NumberCommand("0", simpleCalculator));
    panel.populateCommand(new EqualsCommand(simpleCalculator));
    panel.populateCommand(new OperationCommand(Operation.ADDING, simpleCalculator));
  }
}
