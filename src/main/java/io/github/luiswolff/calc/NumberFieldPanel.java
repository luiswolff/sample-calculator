package io.github.luiswolff.calc;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class NumberFieldPanel extends JPanel {

  public NumberFieldPanel() {
    super(new GridLayout(4, 4));
    add(new NumberButton("7"));
    add(new NumberButton("8"));
    add(new NumberButton("9"));
    add(new NumberButton("/"));
    add(new NumberButton("4"));
    add(new NumberButton("5"));
    add(new NumberButton("6"));
    add(new NumberButton("*"));
    add(new NumberButton("1"));
    add(new NumberButton("2"));
    add(new NumberButton("3"));
    add(new NumberButton("-"));
    add(new NumberButton("0"));
    add(new NumberButton("."));
    add(new NumberButton("="));
    add(new NumberButton("+"));
  }

}
