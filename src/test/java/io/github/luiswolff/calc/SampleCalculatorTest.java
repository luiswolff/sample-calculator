package io.github.luiswolff.calc;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SampleCalculatorTest {

  private SampleCalculator underTest;
  private Map<String, Component> componentByNameIndex;
  private Robot robot;

  @BeforeEach
  void setUp() {
    setUpUnderTest();
    setUpRobot();
  }

  private void setUpUnderTest() {
    underTest = new SampleCalculator();
    underTest.setVisible(true);
    componentByNameIndex = indexComponents(underTest);
  }

  private static Map<String, Component> indexComponents(Component comp) {
    Map<String, Component> result = new HashMap<>();
    if (comp instanceof Container) {
      Container cont = (Container) comp;
      for (int i = 0; i < cont.getComponentCount(); i++) {
        result.putAll(indexComponents(cont.getComponent(i)));
      }
    }
    if (comp.getName() != null) {
      result.put(comp.getName(), comp);
    }
    return result;
  }

  private void setUpRobot() {
    try {
      robot = new Robot();
      robot.setAutoWaitForIdle(true);
      robot.setAutoDelay(250);
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }
  }

  @AfterEach
  void tearDown() {
    if (underTest != null) {
      underTest.dispose();
    }
  }

  @Test
  void test() throws InterruptedException {
    clickOnComponent("button-1");
    clickOnComponent("button-+");
    clickOnComponent("button-2");
    clickOnComponent("button-=");
  }

  private void clickOnComponent(String componentName) throws InterruptedException {
    Component component = componentByNameIndex.get(componentName);
    Point componentsLocationOnScreen = middleOf(component);
    clickAt(componentsLocationOnScreen);
  }

  private static Point middleOf(Component component) {
    Point locationOnScreen = new Point(component.getLocationOnScreen());
    Dimension size = component.getSize();
    locationOnScreen.translate(size.width / 2, size.height / 2);
    return locationOnScreen;
  }

  private void clickAt(Point componentsLocationOnScreen) throws InterruptedException {
    robot.mouseMove(componentsLocationOnScreen.x, componentsLocationOnScreen.y);
    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(1000L);
  }

}