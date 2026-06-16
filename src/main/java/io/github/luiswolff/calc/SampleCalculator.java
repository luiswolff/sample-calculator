package io.github.luiswolff.calc;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class SampleCalculator extends JFrame {

  public SampleCalculator() {
    DisplayPane displayPane = new DisplayPane();
    CalculationController controller = new CalculationController(displayPane::updateText);
    NumberFieldPanel numberFieldPanel = new NumberFieldPanel(controller.createNumberFieldData());
    numberFieldPanel.setHandler(controller::onAction);

    Container contentPane = getContentPane();
    contentPane.add(displayPane, BorderLayout.NORTH);
    contentPane.add(numberFieldPanel, BorderLayout.CENTER);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(200, 300);
  }

  static void main() {
    SampleCalculator app = new SampleCalculator();
    app.setVisible(true);
  }

}
