package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class NumberCommandReceiver implements CalculationCommandReceiver {

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    float newRightTerm = Float.parseFloat(currentState.rightTerm().intValue() + command);
    return new CalculationState(currentState.leftTerm(), currentState.operation(), newRightTerm);
  }
}
