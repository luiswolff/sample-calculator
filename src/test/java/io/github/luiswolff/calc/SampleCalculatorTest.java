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
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_PLUS);
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("2.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("3.0");
  }

  @Test
  void testSubtraction() {
    clickOnComponent(ExpectedUiComponents.BUTTON_FOUR);
    expectDisplayShowsText("4.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MINUS);
    expectDisplayShowsText("4.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_THREE);
    expectDisplayShowsText("3.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("1.0");
  }

  @Test
  void testMultiplication() {
    clickOnComponent(ExpectedUiComponents.BUTTON_FIVE);
    expectDisplayShowsText("5.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MULTIPLY);
    expectDisplayShowsText("5.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SIX);
    expectDisplayShowsText("6.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("30.0");
  }

  @Test
  void testDivision() {
    clickOnComponent(ExpectedUiComponents.BUTTON_NINE);
    expectDisplayShowsText("9.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EIGHT);
    expectDisplayShowsText("98.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_DEVIATE);
    expectDisplayShowsText("98.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SEVEN);
    expectDisplayShowsText("7.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("14.0");
  }

  @Test
  void testClear() {
    clickOnComponent(ExpectedUiComponents.BUTTON_ONE);
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("12.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_CLEAR);
    expectDisplayShowsText("0.0");
  }

  @Test
  void testChainAddition() {
    clickOnComponent(ExpectedUiComponents.BUTTON_ONE);
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_ZERO);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_PLUS);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("2.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_PLUS);
    expectDisplayShowsText("12.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_THREE);
    expectDisplayShowsText("3.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("15.0");
  }

  @Test
  void testChainSubtraction() {
    clickOnComponent(ExpectedUiComponents.BUTTON_ONE);
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_ZERO);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MINUS);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("2.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MINUS);
    expectDisplayShowsText("8.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_THREE);
    expectDisplayShowsText("3.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("5.0");
  }

  @Test
  void testChainMultiplication() {
    clickOnComponent(ExpectedUiComponents.BUTTON_FOUR);
    expectDisplayShowsText("4.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SIX);
    expectDisplayShowsText("46.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MULTIPLY);
    expectDisplayShowsText("46.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SEVEN);
    expectDisplayShowsText("7.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MULTIPLY);
    expectDisplayShowsText("322.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EIGHT);
    expectDisplayShowsText("8.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("2576.0");
  }

  @Test
  void testChainDivision() {
    clickOnComponent(ExpectedUiComponents.BUTTON_NINE);
    expectDisplayShowsText("9.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EIGHT);
    expectDisplayShowsText("98.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_DEVIATE);
    expectDisplayShowsText("98.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SEVEN);
    expectDisplayShowsText("7.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_DEVIATE);
    expectDisplayShowsText("14.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("2.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("7.0");
  }

  @Test
  void testAdditionEqualsTwoTimes() {
    clickOnComponent(ExpectedUiComponents.BUTTON_ONE);
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_ZERO);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_PLUS);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("2.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("12.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("14.0");
  }

  @Test
  void testSubtractionEqualsTowTimes() {
    clickOnComponent(ExpectedUiComponents.BUTTON_ONE);
    expectDisplayShowsText("1.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_ZERO);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MINUS);
    expectDisplayShowsText("10.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_TWO);
    expectDisplayShowsText("2.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("8.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("6.0");
  }

  @Test
  void testMultiplicationEqualsTwoTimes() {
    clickOnComponent(ExpectedUiComponents.BUTTON_FOUR);
    expectDisplayShowsText("4.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SIX);
    expectDisplayShowsText("46.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_MULTIPLY);
    expectDisplayShowsText("46.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SEVEN);
    expectDisplayShowsText("7.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("322.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("2254.0");
  }

  @Test
  void testDivisionEqualsTwoTimes() {
    clickOnComponent(ExpectedUiComponents.BUTTON_NINE);
    expectDisplayShowsText("9.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EIGHT);
    expectDisplayShowsText("98.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_DEVIATE);
    expectDisplayShowsText("98.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_SEVEN);
    expectDisplayShowsText("7.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("14.0");
    clickOnComponent(ExpectedUiComponents.BUTTON_EQUALS);
    expectDisplayShowsText("2.0");
  }

  @Test
  void testConsecutiveCalculations() {
    testAddition();
    testSubtraction();
    testMultiplication();
    testDivision();
    testAddition();
  }


  private void clickOnComponent(ExpectedUiComponents uiComponent) {
    dummyUser.clickAt(calculatorInstance.posOf(uiComponent));
  }

  private void expectDisplayShowsText(String text) {
    Assertions.assertEquals(text, calculatorInstance.displayText());
  }
}