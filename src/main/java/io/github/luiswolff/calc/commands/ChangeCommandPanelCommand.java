package io.github.luiswolff.calc.commands;

import java.util.function.Consumer;
import java.util.function.Supplier;

class ChangeCommandPanelCommand implements CalculationCommand {
  private final String appearance;
  private final Consumer<CommandPanelData> commandPanel;
  private final Supplier<CommandPanelData> commandPanelDataFactory;

  public ChangeCommandPanelCommand(String appearance, Consumer<CommandPanelData> commandPanel,
      Supplier<CommandPanelData> commandPanelDataFactory) {
    this.appearance = appearance;
    this.commandPanel = commandPanel;
    this.commandPanelDataFactory = commandPanelDataFactory;
  }

  @Override
  public void execute() {
    commandPanel.accept(commandPanelDataFactory.get());
  }

  @Override
  public String appearance() {
    return appearance;
  }
}
