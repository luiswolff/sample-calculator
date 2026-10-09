package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Digit;
import io.github.luiswolff.calc.engine.IntCalculator;
import io.github.luiswolff.calc.engine.Operation;
import io.github.luiswolff.calc.engine.SimpleCalculator;
import java.util.function.Consumer;

@SuppressWarnings("DuplicatedCode")
public class CalculatorClient {

  public static CalculatorTypes CALCULATOR_TYPE = CalculatorTypes.SIMPLE_CALCULATOR;

  private final Consumer<String> display;
  private CommandPanel commandPanel;

  public CalculatorClient(Consumer<String> display) {
    this.display = display;
    CALCULATOR_TYPE.commandsAction.accept(this);
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

  private void octalCalculatorCommands() {
    var octalCalculator = new IntCalculator(8);
    display.accept(octalCalculator.getDisplay());
    commandPanel = new CommandPanel(5, 4);
    // Top Row
    commandPanel.add(new ClearCommand(octalCalculator, display));
    commandPanel.add(new OperationCommand(Operation.DIVIDING, octalCalculator, display));
    commandPanel.add(new OperationCommand(Operation.MULTIPLYING, octalCalculator, display));
    commandPanel.add(new OperationCommand(Operation.SUBTRACTING, octalCalculator, display));

    // Upper middle row
    commandPanel.add(3, 1, new NumberCommand(Digit.SEVEN, octalCalculator, display));
    commandPanel.add(1, 2, new OperationCommand(Operation.ADDING, octalCalculator, display));

    // Center middle row
    commandPanel.add(new NumberCommand(Digit.FOUR, octalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.FIVE, octalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.SIX, octalCalculator, display));

    // Under middle row
    commandPanel.add(new NumberCommand(Digit.ONE, octalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.TWO, octalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.THREE, octalCalculator, display));
    commandPanel.add(1, 2, new EqualsCommand(octalCalculator, display));

    // Bottom row
    commandPanel.add(3, 1, new NumberCommand(Digit.ZERO, octalCalculator, display));
  }

  private void hexadecimalCalculatorCommands() {
    var hexadecimalCalculator = new IntCalculator(16);
    display.accept(hexadecimalCalculator.getDisplay());
    commandPanel = new CommandPanel(7, 4);
    // Top Row
    commandPanel.add(new ClearCommand(hexadecimalCalculator, display));
    commandPanel.add(new OperationCommand(Operation.DIVIDING, hexadecimalCalculator, display));
    commandPanel.add(2, 1, new OperationCommand(Operation.MULTIPLYING, hexadecimalCalculator, display));

    // Upper middle row
    commandPanel.add(new NumberCommand(Digit.D, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.E, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.F, hexadecimalCalculator, display));
    commandPanel.add(1, 2, new OperationCommand(Operation.SUBTRACTING, hexadecimalCalculator, display));

    // Upper middle row
    commandPanel.add(new NumberCommand(Digit.A, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.B, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.C, hexadecimalCalculator, display));

    // Upper middle row
    commandPanel.add(new NumberCommand(Digit.SEVEN, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.EIGHT, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.NINE, hexadecimalCalculator, display));
    commandPanel.add(1, 2, new OperationCommand(Operation.ADDING, hexadecimalCalculator, display));

    // Center middle row
    commandPanel.add(new NumberCommand(Digit.FOUR, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.FIVE, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.SIX, hexadecimalCalculator, display));

    // Under middle row
    commandPanel.add(new NumberCommand(Digit.ONE, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.TWO, hexadecimalCalculator, display));
    commandPanel.add(new NumberCommand(Digit.THREE, hexadecimalCalculator, display));
    commandPanel.add(1, 2, new EqualsCommand(hexadecimalCalculator, display));

    // Bottom row
    commandPanel.add(3, 1, new NumberCommand(Digit.ZERO, hexadecimalCalculator, display));
  }

  public CommandPanel getCommandPanel() {
    return commandPanel;
  }

  public enum CalculatorTypes {
    SIMPLE_CALCULATOR(CalculatorClient::simpleCalculatorCommands),
    OCTAL_CALCULATOR(CalculatorClient::octalCalculatorCommands),
    HEXADECIMAL_CALCULATOR(CalculatorClient::hexadecimalCalculatorCommands),
    ;

    private final Consumer<CalculatorClient> commandsAction;

    CalculatorTypes(Consumer<CalculatorClient> commandsAction) {
      this.commandsAction = commandsAction;
    }
  }
}
