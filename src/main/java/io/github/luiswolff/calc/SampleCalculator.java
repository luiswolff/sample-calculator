package io.github.luiswolff.calc;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class SampleCalculator extends JFrame {

  public SampleCalculator() {
    Container contentPane = getContentPane();
    contentPane.add(new DisplayPane(), BorderLayout.NORTH);
    contentPane.add(new NumberFieldPanel(), BorderLayout.CENTER);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(200, 300);
  }

  public static void main(String[] args) {
    SampleCalculator app = new SampleCalculator();
    app.setVisible(true);
  }

}
