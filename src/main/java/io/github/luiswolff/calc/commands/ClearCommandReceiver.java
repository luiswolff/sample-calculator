package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class ClearCommandReceiver implements CalculationCommandReceiver{

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    return CalculationState.INITIAL_STATE;
  }
}
