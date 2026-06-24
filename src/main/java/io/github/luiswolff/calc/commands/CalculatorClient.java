package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Digit;
import io.github.luiswolff.calc.engine.Operation;
import io.github.luiswolff.calc.engine.SimpleCalculator;
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
        new NumberCommand(Digit.SEVEN, simpleCalculator, display),
        new NumberCommand(Digit.EIGHT, simpleCalculator, display),
        new NumberCommand(Digit.NINE, simpleCalculator, display),
        new OperationCommand(Operation.DIVIDING, simpleCalculator, display),

        // Upper middle row
        new NumberCommand(Digit.FOUR, simpleCalculator, display),
        new NumberCommand(Digit.FIVE, simpleCalculator, display),
        new NumberCommand(Digit.SIX, simpleCalculator, display),
        new OperationCommand(Operation.MULTIPLYING, simpleCalculator, display),

        // Under middle row
        new NumberCommand(Digit.ONE, simpleCalculator, display),
        new NumberCommand(Digit.TWO, simpleCalculator, display),
        new NumberCommand(Digit.THREE, simpleCalculator, display),
        new OperationCommand(Operation.SUBTRACTING, simpleCalculator, display),

        // Bottom row
        new ClearCommand(simpleCalculator, display),
        new NumberCommand(Digit.ZERO, simpleCalculator, display),
        new EqualsCommand(simpleCalculator, display),
        new OperationCommand(Operation.ADDING, simpleCalculator, display)
    );
  }

}
