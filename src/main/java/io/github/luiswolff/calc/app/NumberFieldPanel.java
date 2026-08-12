package io.github.luiswolff.calc.app;

import io.github.luiswolff.calc.commands.CalculationCommand;
import io.github.luiswolff.calc.commands.CommandPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

class NumberFieldPanel extends JPanel {

  private final CalculatorFrame calculatorFrame;
  private final GridBagConstraints gbc = new GridBagConstraints();

  NumberFieldPanel(CalculatorFrame calculatorFrame) {
    this.calculatorFrame = calculatorFrame;
    GridBagLayout layout = new GridBagLayout();

    layout.setConstraints(this, gbc);
    setLayout(layout);
  }

  void changeCommandPanel(CommandPanel commandPanel) {
    removeAll();
    invalidate();

    calculatorFrame.setSize(commandPanel.getColumns() * 47, commandPanel.getRows() * 37 + 20);

    for (var action : commandPanel.getCommandPanelCells()) {
      gbc.gridx = action.gridx();
      gbc.gridy = action.gridy();
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridheight = action.height();
      gbc.gridwidth = action.width();

      add(new NumberButton(action.command()), gbc);
    }

    validate();
  }

  private static class NumberButton extends JButton {

    NumberButton(CalculationCommand action) {
      super(new AbstractAction(action.appearance()) {
        @Override
        public void actionPerformed(ActionEvent e) {
          action.execute();
        }
      });
      setName("button-" + getText());
    }
  }
}
