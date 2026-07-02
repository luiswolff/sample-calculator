package io.github.luiswolff.calc.app;

import io.github.luiswolff.calc.commands.CalculationCommand;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CalculationCommandAction extends AbstractAction {
  private final CalculationCommand calculationCommand;

  CalculationCommandAction(CalculationCommand calculationCommand) {
    super(calculationCommand.appearance());
    this.calculationCommand = calculationCommand;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    calculationCommand.execute();
  }

  public int width() {
    return calculationCommand.width();
  }

  public int height() {
    return calculationCommand.height();
  }
}
