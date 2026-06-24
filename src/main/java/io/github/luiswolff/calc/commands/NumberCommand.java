package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Digit;
import io.github.luiswolff.calc.engine.SimpleCalculator;
import java.util.function.Consumer;

class NumberCommand implements CalculationCommand {
  private final Digit digit;
  private final SimpleCalculator receiver;
  private final Consumer<String> display;

  NumberCommand(Digit digit, SimpleCalculator receiver, Consumer<String> display) {
    this.digit = digit;
    this.receiver = receiver;
    this.display = display;
  }

  @Override
  public void execute() {
    receiver.append(digit);
    display.accept(receiver.getDisplay());
  }

  @Override
  public String appearance() {
    return digit.toString();
  }
}
