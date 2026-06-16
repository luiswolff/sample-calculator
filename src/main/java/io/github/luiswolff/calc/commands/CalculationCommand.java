package io.github.luiswolff.calc.commands;

import java.util.Arrays;
import java.util.Objects;

import io.github.luiswolff.calc.model.CalculationState;
import io.github.luiswolff.calc.model.NumberFieldData;

public enum CalculationCommand {
	// Top Row
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	DIVISION("/"),

	// Upper middle row
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	MULTIPLICATION("*"),

	// under middle row
	ONE("1"),
	TOW("2"),
	THREE("3"),
	SUBTRACTION("-"),

	// bottom row
	ZERO("0"),
	DOT("."),
	EQUALS("="),
	ADDITION("+"),
	;
	private static final int COUNT_ROWS = 4;
	private static final int COUNT_COLUMNS = 4;

	private final String display;

	CalculationCommand(String display) {
		this.display = display;
	}

	public static NumberFieldData createNumberFieldData() {
	  return new NumberFieldData(COUNT_ROWS, COUNT_COLUMNS,
			  Arrays.stream(values()).map(CalculationCommand::getDisplay).toArray(String[]::new));
	}

	public String getDisplay() {
		return display;
	}

	public CalculationState execute(CalculationState currentState) {
		return CalculationCommandReceiver.dummy().action(currentState, display);
	}

	public static CalculationCommand fromDisplay(String display) {
		for (CalculationCommand value : values()) {
			if (Objects.equals(value.display, display)) {
				return value;
			}
		}
		throw new IllegalArgumentException("Unknown command " + display);
	}
}
