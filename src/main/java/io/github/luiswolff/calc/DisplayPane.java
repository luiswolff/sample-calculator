package io.github.luiswolff.calc;

import javax.swing.JTextField;

import io.github.luiswolff.calc.model.CalculationState;

class DisplayPane extends JTextField {

  private CalculationState calculationState;

  DisplayPane() {
    setEditable(false);
    setName("display");
    setCalculationState(CalculationState.INITIAL_STATE);
  }

  void setCalculationState(CalculationState calculationState) {
    this.calculationState = calculationState;
    updateText();
  }

  public CalculationState getCalculationState() {
    return calculationState;
  }

  private void updateText() {
    setText(Float.toString(calculationState.rightTerm()));
  }

}
