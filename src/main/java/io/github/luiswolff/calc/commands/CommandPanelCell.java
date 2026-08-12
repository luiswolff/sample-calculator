package io.github.luiswolff.calc.commands;

public record CommandPanelCell(int gridx, int gridy, int width, int height, CalculationCommand command) {
}
