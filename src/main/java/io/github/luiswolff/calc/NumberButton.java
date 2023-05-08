package io.github.luiswolff.calc;

import javax.swing.JButton;

public class NumberButton extends JButton {

  public NumberButton(String text) {
    setName("button-" + text);
    setText(text);
    addActionListener(l -> System.out.println("Pressed " + text));
  }
}
