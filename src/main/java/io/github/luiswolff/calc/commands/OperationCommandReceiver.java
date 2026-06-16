package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class OperationCommandReceiver implements CalculationCommandReceiver {

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    return new CalculationState(currentState.rightTerm(), command, 0.0f);
  }
}
