package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

interface CalculationCommandReceiver {
	CalculationState action(CalculationState currentState, String command);

	static CalculationCommandReceiver dummy() {
		return ((currentState, command) -> {
			System.out.println("Pressed " + command);
			return currentState;
		});
	}
}
