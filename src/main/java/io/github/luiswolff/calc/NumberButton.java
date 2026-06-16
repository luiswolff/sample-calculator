package io.github.luiswolff.calc;

import java.util.function.Consumer;

import javax.swing.JButton;

class NumberButton extends JButton {

  NumberButton(String text) {
    setName("button-" + text);
    setText(text);
  }

  void onClick(Consumer<String> handler) {
    addActionListener(_ -> handler.accept(getText()));
  }
}
