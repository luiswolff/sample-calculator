package io.github.luiswolff.calc.app;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

class NumberFieldPanel extends JPanel {

  private final CalculatorFrame calculatorFrame;

  NumberFieldPanel(CalculatorFrame calculatorFrame) {
    super(new GridLayout());
    this.calculatorFrame = calculatorFrame;
  }

  void changeCommandPanel(int rows, int columns, List<CalculationCommandAction> action) {
    removeAll();
    invalidate();

    GridLayout gridLayout = (GridLayout) getLayout();
    gridLayout.setRows(rows);
    gridLayout.setColumns(columns);
    calculatorFrame.setSize(calculatorFrame.getWidth(), rows * 50 + 20);
    calculatorFrame.setSize(columns * 47, calculatorFrame.getHeight());

    action.stream().map(NumberButton::new).forEach(this::add);
    validate();
  }

  private static class NumberButton extends JButton {

    NumberButton(CalculationCommandAction action) {
      super(action);
      setName("button-" + getText());
    }
  }
}
