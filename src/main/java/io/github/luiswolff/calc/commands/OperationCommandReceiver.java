package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class OperationCommandReceiver implements CalculationCommandReceiver{

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    System.out.println("received operation command: " + command);
    return currentState;
  }
}
