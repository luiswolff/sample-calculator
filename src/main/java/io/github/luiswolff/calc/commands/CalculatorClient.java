package io.github.luiswolff.calc.commands;

import java.util.function.Consumer;

public class CalculatorClient {

  public static CalculationCommand[] menuCommands(Consumer<String> display,
      Consumer<CommandPanelData> commandPanel) {
    return new CalculationCommand[]{
        new ChangeCommandPanelCommand("Simple Calculator", commandPanel, () -> simpleCalculatorCommands(display))
    };
  }

  private static CommandPanelData simpleCalculatorCommands(Consumer<String> display) {
    var simpleCalculator = new SimpleCalculator();
    display.accept(simpleCalculator.getDisplay());
    return new CommandPanelData(4, 4,
        // Top Row
        new NumberCommand("7", simpleCalculator, display),
        new NumberCommand("8", simpleCalculator, display),
        new NumberCommand("9", simpleCalculator, display),
        new OperationCommand(Operation.DIVIDING, simpleCalculator, display),

        // Upper middle row
        new NumberCommand("4", simpleCalculator, display),
        new NumberCommand("5", simpleCalculator, display),
        new NumberCommand("6", simpleCalculator, display),
        new OperationCommand(Operation.MULTIPLYING, simpleCalculator, display),

        // Under middle row
        new NumberCommand("1", simpleCalculator, display),
        new NumberCommand("2", simpleCalculator, display),
        new NumberCommand("3", simpleCalculator, display),
        new OperationCommand(Operation.SUBTRACTING, simpleCalculator, display),

        // Bottom row
        new ClearCommand(simpleCalculator, display),
        new NumberCommand("0", simpleCalculator, display),
        new EqualsCommand(simpleCalculator, display),
        new OperationCommand(Operation.ADDING, simpleCalculator, display)
    );
  }

}
