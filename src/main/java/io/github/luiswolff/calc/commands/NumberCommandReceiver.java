package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class NumberCommandReceiver implements CalculationCommandReceiver {

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    System.out.println("Received number command: " + command);
    return currentState;
  }
}
