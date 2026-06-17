package io.github.luiswolff.calc.commands;

class EqualsCommand implements CalculationCommand {
  private final SimpleCalculator receiver;

  EqualsCommand(SimpleCalculator receiver) {
    this.receiver = receiver;
  }

  @Override
  public String execute() {
    receiver.equals();
    return receiver.getDisplay();
  }

  @Override
  public String appearance() {
    return "=";
  }
}
