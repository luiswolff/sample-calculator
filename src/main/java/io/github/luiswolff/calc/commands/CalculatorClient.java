package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Digit;
import io.github.luiswolff.calc.engine.Operation;
import io.github.luiswolff.calc.engine.SimpleCalculator;
import java.util.function.Consumer;

public class CalculatorClient {

  private final Consumer<String> display;
  private CommandPanel commandPanel;

  public CalculatorClient(Consumer<String> display) {
    this.display = display;
    simpleCalculatorCommands();
  }

  private void simpleCalculatorCommands() {
    var simpleCalculator = new SimpleCalculator();
    display.accept(simpleCalculator.getDisplay());
    commandPanel = new CommandPanel(5, 4);
    // Top Row
    commandPanel.add(new ClearCommand(simpleCalculator, display));
    commandPanel.add(new OperationCommand(Operation.DIVIDING, simpleCalculator, display));
    commandPanel.add(new OperationCommand(Operation.MULTIPLYING, simpleCalculator, display));
    commandPanel.add(new OperationCommand(Operation.SUBTRACTING, simpleCalculator, display));

    // Upper middle row
    commandPanel.add(new NumberCommand(Digit.SEVEN, simpleCalculator, display));
    commandPanel.add(new NumberCommand(Digit.EIGHT, simpleCalculator, display));
    commandPanel.add(new NumberCommand(Digit.NINE, simpleCalculator, display));
    commandPanel.add(1, 2, new OperationCommand(Operation.ADDING, simpleCalculator, display));

    // Center middle row
    commandPanel.add(new NumberCommand(Digit.FOUR, simpleCalculator, display));
    commandPanel.add(new NumberCommand(Digit.FIVE, simpleCalculator, display));
    commandPanel.add(new NumberCommand(Digit.SIX, simpleCalculator, display));

    // Under middle row
    commandPanel.add(new NumberCommand(Digit.ONE, simpleCalculator, display));
    commandPanel.add(new NumberCommand(Digit.TWO, simpleCalculator, display));
    commandPanel.add(new NumberCommand(Digit.THREE, simpleCalculator, display));
    commandPanel.add(1, 2, new EqualsCommand(simpleCalculator, display));

    // Bottom row
    commandPanel.add(2, 1, new NumberCommand(Digit.ZERO, simpleCalculator, display));
    commandPanel.add(new DecimalPointCommand(simpleCalculator, display));
  }

  public CommandPanel getCommandPanel() {
    return commandPanel;
  }
}
