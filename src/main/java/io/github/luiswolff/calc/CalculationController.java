package io.github.luiswolff.calc;


import io.github.luiswolff.calc.commands.SimpleCalculatorClient;

class CalculationController {

  CalculationController(DisplayPane displayPane, NumberFieldPanel numberFieldPanel) {
    SimpleCalculatorClient.configure(numberFieldPanel);
    numberFieldPanel.setCommandInvoker(command -> displayPane.updateText(command.execute()));
  }
}
