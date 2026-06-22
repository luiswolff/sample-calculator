package io.github.luiswolff.calc.commands;

import java.util.function.Consumer;

class OperationCommand implements CalculationCommand {
  private final Operation operation;
  private final SimpleCalculator receiver;
  private final Consumer<String> display;

  OperationCommand(Operation operation, SimpleCalculator receiver, Consumer<String> display) {
    this.operation = operation;
    this.receiver = receiver;
    this.display = display;
  }

  @Override
  public void execute() {
    receiver.define(operation);
    display.accept(receiver.getDisplay());
  }

  @Override
  public String appearance() {
    return operation.getAppearance();
  }
}
