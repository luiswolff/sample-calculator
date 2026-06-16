package io.github.luiswolff.calc;

import javax.swing.JTextField;

import io.github.luiswolff.calc.model.CalculationState;

class DisplayPane extends JTextField {

  DisplayPane() {
    setEditable(false);
    setName("display");
  }

  void updateText(CalculationState calculationState) {
    setText(Float.toString(calculationState.rightTerm()));
  }

}
