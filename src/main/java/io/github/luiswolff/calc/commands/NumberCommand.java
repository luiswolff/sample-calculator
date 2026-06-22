package io.github.luiswolff.calc.commands;

import java.util.function.Consumer;

class NumberCommand implements CalculationCommand {
  private final String number;
  private final SimpleCalculator receiver;
  private final Consumer<String> display;

  NumberCommand(String number, SimpleCalculator receiver, Consumer<String> display) {
    this.number = number;
    this.receiver = receiver;
    this.display = display;
  }

  @Override
  public void execute() {
    receiver.append(number);
    display.accept(receiver.getDisplay());
  }

  @Override
  public String appearance() {
    return number;
  }
}
