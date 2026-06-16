package io.github.luiswolff.calc;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.luiswolff.calc.model.NumberFieldData;

class NumberFieldPanel extends JPanel {

  NumberFieldPanel(NumberFieldData numberFieldData) {
    super(new GridLayout(numberFieldData.countRows(), numberFieldData.countColumns()));
    Arrays.stream(numberFieldData.buttons()).map(NumberButton::new).forEach(this::add);
  }

  void setHandler(Consumer<String> handler) {
    Arrays.stream(getComponents())
        .filter(NumberButton.class::isInstance)
        .map(NumberButton.class::cast)
        .forEach(b -> b.addActionListener(_ -> handler.accept(b.getText())));
  }

  private static class NumberButton extends JButton {

    NumberButton(String text) {
      setName("button-" + text);
      setText(text);
    }
  }
}
