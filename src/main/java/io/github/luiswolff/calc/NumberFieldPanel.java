package io.github.luiswolff.calc;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

class NumberFieldPanel extends JPanel {

  private final SampleCalculator sampleCalculator;

  NumberFieldPanel(SampleCalculator sampleCalculator) {
    super(new GridLayout());
    this.sampleCalculator = sampleCalculator;
  }

  void changeCommandPanel(int rows, int columns, List<CalculationCommandAction> action) {
    removeAll();
    invalidate();

    GridLayout gridLayout = (GridLayout) getLayout();
    gridLayout.setRows(rows);
    gridLayout.setColumns(columns);
    sampleCalculator.setSize(sampleCalculator.getWidth(), rows * 50 + 20);
    sampleCalculator.setSize(columns * 47, sampleCalculator.getHeight());

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
