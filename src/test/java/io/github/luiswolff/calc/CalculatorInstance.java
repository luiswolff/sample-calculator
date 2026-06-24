package io.github.luiswolff.calc;

import io.github.luiswolff.calc.app.CalculatorFrame;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

class CalculatorInstance {

  private final CalculatorFrame underTest;
  private final Map<String, Component> componentByNameIndex;

  CalculatorInstance() {
    underTest = new CalculatorFrame();
    invokeAndWait(() -> underTest.setVisible(true));
    componentByNameIndex = indexComponents(underTest);
  }


  private static Map<String, Component> indexComponents(Component comp) {
    Map<String, Component> result = new HashMap<>();
    if (comp instanceof Container cont) {
      for (int i = 0; i < cont.getComponentCount(); i++) {
        result.putAll(indexComponents(cont.getComponent(i)));
      }
    }
    if (comp.getName() != null) {
      result.put(comp.getName(), comp);
    }
    return result;
  }

  Point posOf(ExpectedUiComponents uiComponents) {
    Component component = componentByNameIndex.get(uiComponents.getComponentName());
    Point locationOnScreen = new Point(component.getLocationOnScreen());
    Dimension size = component.getSize();
    locationOnScreen.translate(size.width / 2, size.height / 2);
    return locationOnScreen;
  }

  String displayText() {
    JTextComponent textField = (JTextComponent) componentByNameIndex.get(
        ExpectedUiComponents.DISPLAY.getComponentName());
    return textField.getText();
  }

  void close() {
    invokeAndWait(underTest::dispose);
  }

  void invokeAndWait(Runnable doRun) {
    try {
      SwingUtilities.invokeAndWait(doRun);
    } catch (InterruptedException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

}
