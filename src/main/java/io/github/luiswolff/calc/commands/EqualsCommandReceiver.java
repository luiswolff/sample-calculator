package io.github.luiswolff.calc.commands;

import io.github.luiswolff.calc.model.CalculationState;

class EqualsCommandReceiver implements CalculationCommandReceiver{

  @Override
  public CalculationState action(CalculationState currentState, String command) {
    return new CalculationState(currentState.leftTerm(), currentState.operation(), resolve(currentState));
  }

  private Float resolve(CalculationState currentState) {
    return switch (currentState.operation()) {
      case "+" -> currentState.leftTerm() + currentState.rightTerm();
      case "-" -> currentState.leftTerm() - currentState.rightTerm();
      case "*" -> currentState.leftTerm() * currentState.rightTerm();
      case "/" -> currentState.leftTerm() / currentState.rightTerm();
      default ->
          throw new UnsupportedOperationException("Not supported" + currentState.operation());
    };
  }
}
