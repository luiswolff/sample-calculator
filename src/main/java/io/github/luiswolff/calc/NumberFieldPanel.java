package io.github.luiswolff.calc;

import io.github.luiswolff.calc.commands.CalculationCommand;
import io.github.luiswolff.calc.commands.CalculatorPanel;
import java.awt.GridLayout;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JPanel;

class NumberFieldPanel extends JPanel implements CalculatorPanel {

  private Consumer<CalculationCommand> commandInvoker;

  NumberFieldPanel() {
    super(new GridLayout());
  }

  void setCommandInvoker(Consumer<CalculationCommand> commandInvoker) {
    this.commandInvoker = commandInvoker;
  }

  @Override
  public void setRowCount(int rows) {
    ((GridLayout) getLayout()).setRows(rows);
  }

  @Override
  public void setColumnCount(int columns) {
    ((GridLayout) getLayout()).setColumns(columns);
  }

  @Override
  public void populateCommand(CalculationCommand command) {
    add(new NumberButton(command));
  }

  private class NumberButton extends JButton {

    NumberButton(CalculationCommand command) {
      setText(command.appearance());
      setName("button-" + getText());
      addActionListener(_ -> commandInvoker.accept(command));
    }
  }
}
