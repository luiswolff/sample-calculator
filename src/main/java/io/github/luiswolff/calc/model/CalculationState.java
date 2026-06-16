package io.github.luiswolff.calc.model;

public record CalculationState(Float leftTerm, String operation, Float rightTerm) {
	public static final CalculationState INITIAL_STATE = new CalculationState(null, null, 0f);
}
