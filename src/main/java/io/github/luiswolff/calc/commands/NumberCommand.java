package io.github.luiswolff.calc.commands;

class NumberCommand implements CalculationCommand {
  private final String number;
  private final SimpleCalculator receiver;

  NumberCommand(String number, SimpleCalculator receiver) {
    this.number = number;
    this.receiver = receiver;
  }

  @Override
  public String execute() {
    receiver.append(number);
    return receiver.getDisplay();
  }

  @Override
  public String appearance() {
    return number;
  }
}
