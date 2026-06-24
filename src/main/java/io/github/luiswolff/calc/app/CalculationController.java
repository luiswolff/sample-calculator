package io.github.luiswolff.calc.app;


import io.github.luiswolff.calc.commands.CalculationCommand;
import io.github.luiswolff.calc.commands.CalculatorClient;
import java.util.Arrays;
import java.util.List;

class CalculationController {

  CalculationController(CalculatorFrame calculatorFrame) {
    CalculationCommand[] menuCommands = CalculatorClient.menuCommands(
        calculatorFrame.getDisplayPane()::updateText,
        commandPanelData -> {
          CalculationCommand[] panelCommands = commandPanelData.commands();
          calculatorFrame.getNumberFieldPanel()
              .changeCommandPanel(commandPanelData.rows(), commandPanelData.columns(),
                  convert(panelCommands));
        });
    calculatorFrame.getFrameMenuBar().init(convert(menuCommands));
  }

  private List<CalculationCommandAction> convert(CalculationCommand[] commands) {
    return Arrays.stream(commands).map(CalculationCommandAction::new).toList();
  }
}
