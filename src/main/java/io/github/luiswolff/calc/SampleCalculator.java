package io.github.luiswolff.calc;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class SampleCalculator extends JFrame {

  public SampleCalculator() {
    DisplayPane displayPane = new DisplayPane();
    NumberFieldPanel numberFieldPanel = new NumberFieldPanel(this);
    new CalculationController(displayPane, numberFieldPanel);

    Container contentPane = getContentPane();
    contentPane.add(displayPane, BorderLayout.NORTH);
    contentPane.add(numberFieldPanel, BorderLayout.CENTER);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setResizable(false);
  }

  static void main() {
    SampleCalculator app = new SampleCalculator();
    app.setVisible(true);
  }

}
