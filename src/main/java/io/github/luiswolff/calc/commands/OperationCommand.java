package io.github.luiswolff.calc.commands;

class OperationCommand implements CalculationCommand {
  private final Operation operation;
  private final SimpleCalculator receiver;

  OperationCommand(Operation operation, SimpleCalculator receiver) {
    this.operation = operation;
    this.receiver = receiver;
  }

  @Override
  public String execute() {
    receiver.define(operation);
    return receiver.getDisplay();
  }

  @Override
  public String appearance() {
    return operation.getAppearance();
  }
}
