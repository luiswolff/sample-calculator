package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Digit;
import io.github.luiswolff.calc.engine.Operation;
import io.github.luiswolff.calc.engine.SimpleCalculator;
import java.util.function.Consumer;

public class CalculatorClient {
  private final Consumer<String> display;
  private CommandPanelData commandPanelData;

  public CalculatorClient(Consumer<String> display) {
    this.display = display;
    simpleCalculatorCommands();
  }

  public MenuCommand[] menuCommands() {
    return new MenuCommand[]{
        menuCommand("Simple Calculator", true, this::simpleCalculatorCommands)
    };
  }

  private static MenuCommand menuCommand(String appearance, boolean isDefault, Runnable action) {
    return new MenuCommand() {
      @Override
      public void execute() {
        action.run();
      }

      @Override
      public String appearance() {
        return appearance;
      }

      @Override
      public boolean isDefault() {
        return isDefault;
      }
    };
  }

  private void simpleCalculatorCommands() {
    var simpleCalculator = new SimpleCalculator();
    display.accept(simpleCalculator.getDisplay());
    commandPanelData = new CommandPanelData(4, 4,
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

  public CommandPanelData getCommandPanelData() {
    return commandPanelData;
  }
}
