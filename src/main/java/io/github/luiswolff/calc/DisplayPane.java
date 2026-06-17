package io.github.luiswolff.calc;

import javax.swing.JTextField;

class DisplayPane extends JTextField {

  DisplayPane() {
    setEditable(false);
    setName("display");
  }

  void updateText(String text) {
    setText(text);
  }

}
