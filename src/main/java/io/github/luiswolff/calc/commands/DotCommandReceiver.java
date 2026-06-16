package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class DotCommandReceiver implements CalculationCommandReceiver{

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    System.out.println("received dot command");
    return currentState;
  }
}
