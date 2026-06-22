package io.github.luiswolff.calc;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

class FrameMenuBar extends JMenuBar {

  void init(List<CalculationCommandAction> actions) {
    JMenu calculatorMenu = new JMenu("Calculators");
    ButtonGroup calculatorGroup = new ButtonGroup();
    actions.stream()
        .map(JRadioButtonMenuItem::new)
        .peek(calculatorGroup::add)
        .peek(calculatorMenu::add)
        .limit(1)
        .forEach(FrameMenuBar::selectAndFire);
    add(calculatorMenu);
  }

  private static void selectAndFire(JRadioButtonMenuItem selected) {
    CalculationCommandAction action = (CalculationCommandAction) selected.getAction();

    selected.setSelected(true);
    action.actionPerformed(new ActionEvent(selected,
        ActionEvent.ACTION_PERFORMED,
        (String) action.getValue(CalculationCommandAction.ACTION_COMMAND_KEY)));
  }
}
