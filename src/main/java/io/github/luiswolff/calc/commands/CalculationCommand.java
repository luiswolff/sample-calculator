package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

public enum CalculationCommand {
  // Top Row
  SEVEN("7", NumberCommandReceiver::new),
  EIGHT("8", NumberCommandReceiver::new),
  NINE("9", NumberCommandReceiver::new),
  DIVISION("/", OperationCommandReceiver::new),

  // Upper middle row
  FOUR("4", NumberCommandReceiver::new),
  FIVE("5", NumberCommandReceiver::new),
  SIX("6", NumberCommandReceiver::new),
  MULTIPLICATION("*", OperationCommandReceiver::new),

  // under middle row
  ONE("1", NumberCommandReceiver::new),
  TOW("2", NumberCommandReceiver::new),
  THREE("3", NumberCommandReceiver::new),
  SUBTRACTION("-", OperationCommandReceiver::new),

  // bottom row
  DOT("C", ClearCommandReceiver::new),
  ZERO("0", NumberCommandReceiver::new),
  EQUALS("=", EqualsCommandReceiver::new),
  ADDITION("+", OperationCommandReceiver::new),
  ;
  public static final int COUNT_ROWS = 4;
  public static final int COUNT_COLUMNS = 4;

  private final String display;
  private final Supplier<CalculationCommandReceiver> commandReceiver;

  CalculationCommand(String display, Supplier<CalculationCommandReceiver> commandReceiver) {
    this.display = display;
    this.commandReceiver = commandReceiver;
  }

  public static String[] displays() {
    return Arrays.stream(values()).map(CalculationCommand::getDisplay).toArray(String[]::new);
  }

  public String getDisplay() {
    return display;
  }

  public CalculationState execute(CalculationState currentState) {
    return commandReceiver.get().action(currentState, display);
  }

  public static CalculationCommand fromDisplay(String display) {
    for (CalculationCommand value : values()) {
      if (Objects.equals(value.display, display)) {
        return value;
      }
    }
    throw new IllegalArgumentException("Unknown command " + display);
  }
}
