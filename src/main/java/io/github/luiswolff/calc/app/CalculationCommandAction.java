package io.github.luiswolff.calc.app;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CalculationCommandAction extends AbstractAction {
  private final Runnable action;
  private final int width;
  private final int height;

  CalculationCommandAction(String name, Runnable action, int width, int height) {
    super(name);
    this.action = action;
    this.width = width;
    this.height = height;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    action.run();
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }
}
