package io.github.luiswolff.calc.app;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

class FrameMenuBar extends JMenuBar {

  void init(List<MenuCommandAction> actions) {
    JMenu calculatorMenu = new JMenu("Calculators");
    ButtonGroup calculatorGroup = new ButtonGroup();
    actions.stream()
        .map(MenuCommandItem::new)
        .peek(calculatorGroup::add)
        .forEach(calculatorMenu::add);
    add(calculatorMenu);
  }

  private static class MenuCommandItem extends JRadioButtonMenuItem {
    private MenuCommandItem(MenuCommandAction action) {
      super(action);
      setSelected(action.isDefault());
    }
  }

}
