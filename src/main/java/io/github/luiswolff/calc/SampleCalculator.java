package io.github.luiswolff.calc;

import io.github.luiswolff.calc.model.CalculationState;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import io.github.luiswolff.calc.commands.CalculationCommand;

public class SampleCalculator extends JFrame {

  private final DisplayPane displayPane = new DisplayPane();

  public SampleCalculator() {
    NumberFieldPanel numberFieldPanel = new NumberFieldPanel(
        CalculationCommand.createNumberFieldData());
    numberFieldPanel.setHandler(this::onAction);
    Container contentPane = getContentPane();
    contentPane.add(displayPane, BorderLayout.NORTH);
    contentPane.add(numberFieldPanel, BorderLayout.CENTER);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(200, 300);
  }

  private void onAction(String command) {
    CalculationCommand calculationCommand = CalculationCommand.fromDisplay(command);
    CalculationState calculationState = calculationCommand.execute(
        displayPane.getCalculationState());
    displayPane.setCalculationState(calculationState);
  }

  static void main() {
    SampleCalculator app = new SampleCalculator();
    app.setVisible(true);
  }

}
