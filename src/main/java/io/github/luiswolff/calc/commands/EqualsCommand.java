package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Calculator;
import java.util.function.Consumer;

class EqualsCommand implements CalculationCommand {
  private final Calculator receiver;
  private final Consumer<String> display;

  EqualsCommand(Calculator receiver, Consumer<String> display) {
    this.receiver = receiver;
    this.display = display;
  }

  @Override
  public void execute() {
    receiver.equals();
    display.accept(receiver.getDisplay());
  }

  @Override
  public String appearance() {
    return "=";
  }
}
