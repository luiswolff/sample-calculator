package io.github.luiswolff.calc.app;

import io.github.luiswolff.calc.commands.MenuCommand;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class MenuCommandAction extends AbstractAction {
  private final MenuCommand menuCommand;
  private final Runnable selectMenuChangedCallback;

  MenuCommandAction(MenuCommand menuCommand, Runnable selectMenuChangedCallback) {
    super(menuCommand.appearance());
    this.menuCommand = menuCommand;
    this.selectMenuChangedCallback = selectMenuChangedCallback;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    menuCommand.execute();
    selectMenuChangedCallback.run();
  }

  boolean isDefault() {
    return menuCommand.isDefault();
  }
}
