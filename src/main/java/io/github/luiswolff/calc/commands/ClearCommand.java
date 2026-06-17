package io.github.luiswolff.calc.commands;

class ClearCommand implements CalculationCommand {
  private final SimpleCalculator receiver;

  ClearCommand(SimpleCalculator receiver) {
    this.receiver = receiver;
  }

  @Override
  public String execute() {
    receiver.clear();
    return receiver.getDisplay();
  }

  @Override
  public String appearance() {
    return "C";
  }
}
