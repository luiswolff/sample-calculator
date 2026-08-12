package io.github.luiswolff.calc.app;


import io.github.luiswolff.calc.commands.CalculatorClient;

class CalculationController {

  CalculationController(CalculatorFrame calculatorFrame) {
    CalculatorClient calculatorClient = new CalculatorClient(
        calculatorFrame.getDisplayPane()::updateText);
    NumberFieldPanel numberFieldPanel = calculatorFrame.getNumberFieldPanel();

    numberFieldPanel.changeCommandPanel(calculatorClient.getCommandPanel());
  }

}
