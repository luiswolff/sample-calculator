package io.github.luiswolff.calc.app;

import io.github.luiswolff.calc.commands.CalculatorClient;
import io.github.luiswolff.calc.commands.CalculatorClient.CalculatorTypes;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

class CalculatorMenuBar extends JMenuBar {

  CalculatorMenuBar(CalculatorFrame frame) {
    JMenu calculatorTypeMenu = new JMenu("Change Calculator Type");
    for (CalculatorTypes type : CalculatorTypes.values()) {
      if (type == CalculatorClient.CALCULATOR_TYPE) {
        continue;
      }
      JMenuItem calculatorTypeMenuItem = new JMenuItem(type.name());
      calculatorTypeMenuItem.addActionListener(_ -> disposeAndRestart(frame, type));
      calculatorTypeMenu.add(calculatorTypeMenuItem);
    }
    add(calculatorTypeMenu);
  }

  private static void disposeAndRestart(CalculatorFrame frame, CalculatorTypes type) {
    CalculatorClient.CALCULATOR_TYPE = type;
    frame.dispose();
    SwingUtilities.invokeLater(() -> {
      CalculatorFrame newFrame = new CalculatorFrame();
      newFrame.setVisible(true);
    });
  }
}
