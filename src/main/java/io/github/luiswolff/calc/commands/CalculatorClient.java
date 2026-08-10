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

  private void simpleCalculatorCommands() {
    var simpleCalculator = new SimpleCalculator();
    display.accept(simpleCalculator.getDisplay());
    commandPanelData = new CommandPanelData(4, 4,
        // Top Row
        new CommandPanelCell(new NumberCommand(Digit.SEVEN, simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.EIGHT, simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.NINE, simpleCalculator, display)),
        new CommandPanelCell(new OperationCommand(Operation.DIVIDING, simpleCalculator, display)),

        // Upper middle row
        new CommandPanelCell(new NumberCommand(Digit.FOUR, simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.FIVE, simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.SIX, simpleCalculator, display)),
        new CommandPanelCell(new OperationCommand(Operation.MULTIPLYING, simpleCalculator, display)),

        // Under middle row
        new CommandPanelCell(new NumberCommand(Digit.ONE, simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.TWO, simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.THREE, simpleCalculator, display)),
        new CommandPanelCell(new OperationCommand(Operation.SUBTRACTING, simpleCalculator, display)),

        // Bottom row
        new CommandPanelCell(new ClearCommand(simpleCalculator, display)),
        new CommandPanelCell(new NumberCommand(Digit.ZERO, simpleCalculator, display)),
        new CommandPanelCell(new EqualsCommand(simpleCalculator, display)),
        new CommandPanelCell(new OperationCommand(Operation.ADDING, simpleCalculator, display))
    );
  }

  public CommandPanelData getCommandPanelData() {
    return commandPanelData;
  }
}
