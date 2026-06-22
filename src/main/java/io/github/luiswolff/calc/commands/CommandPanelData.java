package io.github.luiswolff.calc.commands;

public record CommandPanelData(int rows, int columns, CalculationCommand... commands) {

}
