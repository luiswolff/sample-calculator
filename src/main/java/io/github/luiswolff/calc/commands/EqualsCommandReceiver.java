package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class EqualsCommandReceiver implements CalculationCommandReceiver{

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    System.out.println("Received equals command");
    return currentState;
  }
}
