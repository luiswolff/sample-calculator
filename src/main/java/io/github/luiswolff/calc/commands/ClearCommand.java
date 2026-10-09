package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.engine.Calculator;
import java.util.function.Consumer;

class ClearCommand implements CalculationCommand {
  private final Calculator receiver;
  private final Consumer<String> display;

  ClearCommand(Calculator receiver, Consumer<String> display) {
    this.receiver = receiver;
    this.display = display;
  }

  @Override
  public void execute() {
    receiver.clear();
    display.accept(receiver.getDisplay());
  }

  @Override
  public String appearance() {
    return "C";
  }
}
