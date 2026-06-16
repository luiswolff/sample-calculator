package io.github.luiswolff.calc;

import io.github.luiswolff.calc.commands.CalculationCommand;
import io.github.luiswolff.calc.model.CalculationState;
import io.github.luiswolff.calc.model.NumberFieldData;
import java.util.function.Consumer;

class CalculationController {

  private CalculationState currentCalculationState = CalculationState.INITIAL_STATE;
  private final Consumer<CalculationState> stateChangeHandler;

  CalculationController(Consumer<CalculationState> stateChangeHandler) {
    this.stateChangeHandler = stateChangeHandler;
    notifyStateChangeHandler();
  }

  void onAction(String command) {
    CalculationCommand calculationCommand = CalculationCommand.fromDisplay(command);
    currentCalculationState = calculationCommand.execute(currentCalculationState);
    notifyStateChangeHandler();
  }

  private void notifyStateChangeHandler() {
    stateChangeHandler.accept(currentCalculationState);
  }

  public NumberFieldData createNumberFieldData() {
    return new NumberFieldData(CalculationCommand.COUNT_ROWS, CalculationCommand.COUNT_COLUMNS,
        CalculationCommand.displays());
  }

}
