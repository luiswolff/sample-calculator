package io.github.luiswolff.calc;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SampleCalculatorTest {

  @Test
  void test() throws InterruptedException, AWTException {
    SampleCalculator calc = new SampleCalculator();
    calc.setVisible(true);
    calc.setLocation(100, 50);
    Thread.sleep(1000L);
    Component component = extracted(calc).get("button-1");
    System.out.println("Pos in App " + component.getLocation());
    System.out.println("Pos on Screen " + component.getLocationOnScreen());
    System.out.println("Size " + component.getSize());

    Robot robot = new Robot();
    robot.mouseMove(component.getLocationOnScreen().x + component.getSize().width / 2, component.getLocationOnScreen().y + component.getSize().height / 2);
    robot.mousePress(MouseEvent.BUTTON1_MASK);
    robot.mouseRelease(MouseEvent.BUTTON1_MASK);
    Thread.sleep(1000L);
    calc.dispose();
  }

  private static Map<String, Component> extracted(Component comp) {
    Map<String, Component> result = new HashMap<>();
    if (comp instanceof Container) {
      Container cont = (Container) comp;
      for (int i = 0; i < cont.getComponentCount(); i++) {
        result.putAll(extracted(cont.getComponent(i)));
      }
    }
    if (comp.getName() != null) {
      result.put(comp.getName(), comp);
    }
    return result;
  }

}