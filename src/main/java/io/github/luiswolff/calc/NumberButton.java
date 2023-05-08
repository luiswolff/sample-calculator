package io.github.luiswolff.calc;

import javax.swing.JButton;

public class NumberButton extends JButton {

  public NumberButton(String text) {
    setText(text);
    addActionListener(l -> System.out.println("Pressed " + text));
  }
}
