package io.github.luiswolff.calc;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class SampleCalculator extends JFrame {

  private final DisplayPane displayPane = new DisplayPane();
  private final NumberFieldPanel numberFieldPanel = new NumberFieldPanel(this);
  private final FrameMenuBar frameMenuBar = new FrameMenuBar();

  public SampleCalculator() {
    new CalculationController(this);

    Container contentPane = getContentPane();
    contentPane.add(displayPane, BorderLayout.NORTH);
    contentPane.add(numberFieldPanel, BorderLayout.CENTER);
    setJMenuBar(frameMenuBar);

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setResizable(false);
  }

  DisplayPane getDisplayPane() {
    return displayPane;
  }

  NumberFieldPanel getNumberFieldPanel() {
    return numberFieldPanel;
  }

  FrameMenuBar getFrameMenuBar() {
    return frameMenuBar;
  }

  static void main() {
    SampleCalculator app = new SampleCalculator();
    app.setVisible(true);
  }

}
