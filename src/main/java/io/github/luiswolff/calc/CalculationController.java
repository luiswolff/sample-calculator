package io.github.luiswolff.calc;


import io.github.luiswolff.calc.commands.CalculationCommand;
import io.github.luiswolff.calc.commands.CalculatorClient;
import java.util.Arrays;
import java.util.List;

class CalculationController {

  CalculationController(SampleCalculator sampleCalculator) {
    CalculationCommand[] menuCommands = CalculatorClient.menuCommands(
        sampleCalculator.getDisplayPane()::updateText,
        commandPanelData -> {
          CalculationCommand[] panelCommands = commandPanelData.commands();
          sampleCalculator.getNumberFieldPanel()
              .changeCommandPanel(commandPanelData.rows(), commandPanelData.columns(),
                  convert(panelCommands));
        });
    sampleCalculator.getFrameMenuBar().init(convert(menuCommands));
  }

  private List<CalculationCommandAction> convert(CalculationCommand[] commands) {
    return Arrays.stream(commands).map(CalculationCommandAction::new).toList();
  }
}
