package io.github.luiswolff.calc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SampleCalculatorTest {

  private CalculatorInstance calculatorInstance;
  private DummyUser dummyUser;

  @BeforeEach
  void setUp() {
    calculatorInstance = new CalculatorInstance();
    dummyUser = new DummyUser();
  }

  @AfterEach
  void tearDown() {
    calculatorInstance.close();
  }

  @Test
  void testAddition() {
    clickOnComponent(ExpectedUiComponents.BUTTON_ONE);
    clickOnComponent(ExpectedUiComponents.BUTTON_PLUS);
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    checkDisplayShows("3.0");
  }

  @Test
  void testSubtraction() {
    clickOnComponent(ExpectedUiComponents.BUTTON_FOUR);
    clickOnComponent(ExpectedUiComponents.BUTTON_MINUS);
    clickOnComponent(ExpectedUiComponents.BUTTON_THREE);
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    checkDisplayShows("1.0");
  }

  @Test
  void testMultiplication() {
    clickOnComponent(ExpectedUiComponents.BUTTON_FIVE);
    clickOnComponent(ExpectedUiComponents.BUTTON_MULTIPLY);
    clickOnComponent(ExpectedUiComponents.BUTTON_SIX);
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    checkDisplayShows("30.0");
  }

  @Test
  void testDivision() {
    clickOnComponent(ExpectedUiComponents.BUTTON_NINE);
    clickOnComponent(ExpectedUiComponents.BUTTON_EIGHT);
    clickOnComponent(ExpectedUiComponents.BUTTON_ZERO);
    clickOnComponent(ExpectedUiComponents.BUTTON_DEVIATE);
    clickOnComponent(ExpectedUiComponents.BUTTON_SEVEN);
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    checkDisplayShows("140.0");
  }

  private void clickOnComponent(ExpectedUiComponents uiComponent) {
    dummyUser.clickAt(calculatorInstance.posOf(uiComponent));
  }

  private void checkDisplayShows(String expected) {
    Assertions.assertEquals(expected, calculatorInstance.displayText());
  }
}