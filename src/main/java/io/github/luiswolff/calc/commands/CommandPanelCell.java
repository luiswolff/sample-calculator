package io.github.luiswolff.calc.commands;

import java.util.Objects;

public record CommandPanelCell(int width, int height, CalculationCommand command) {
  public CommandPanelCell {
    if (width < 1) {
      width = 1;
    }
    if (height < 1) {
      height = 1;
    }
    Objects.requireNonNull(command);
  }
  CommandPanelCell(CalculationCommand command) {
    this(1, 1, command);
  }
}
