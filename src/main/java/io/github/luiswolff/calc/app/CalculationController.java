package io.github.luiswolff.calc.app;


import io.github.luiswolff.calc.commands.CalculatorClient;
import io.github.luiswolff.calc.commands.CommandPanelData;
import java.util.Arrays;
import java.util.List;

class CalculationController {

  private final CalculatorClient calculatorClient;
  private final NumberFieldPanel numberFieldPanel;

  CalculationController(CalculatorFrame calculatorFrame) {
    calculatorClient = new CalculatorClient(calculatorFrame.getDisplayPane()::updateText);
    numberFieldPanel = calculatorFrame.getNumberFieldPanel();

    FrameMenuBar frameMenuBar = calculatorFrame.getFrameMenuBar();
    frameMenuBar.init(Arrays.stream(calculatorClient.menuCommands())
        .map(c -> new MenuCommandAction(c, this::onMenuChoiceChanged))
        .toList());

    onMenuChoiceChanged();
  }

  private void onMenuChoiceChanged() {
    CommandPanelData commandPanelData = calculatorClient.getCommandPanelData();
    List<CalculationCommandAction> actions = Arrays.stream(commandPanelData.commands())
        .map(CalculationCommandAction::new)
        .toList();
    numberFieldPanel.changeCommandPanel(commandPanelData.rows(), commandPanelData.columns(), actions);
  }

}
