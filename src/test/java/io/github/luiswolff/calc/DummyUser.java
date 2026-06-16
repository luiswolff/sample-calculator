package io.github.luiswolff.calc;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;

class DummyUser {

  private final Robot robot;
  DummyUser() {
    try {
      robot = new Robot();
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }
    robot.setAutoWaitForIdle(true);
    robot.setAutoDelay(250);
  }

  void clickAt(Point componentsLocationOnScreen) {
    robot.mouseMove(componentsLocationOnScreen.x, componentsLocationOnScreen.y);
    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
  }
}
