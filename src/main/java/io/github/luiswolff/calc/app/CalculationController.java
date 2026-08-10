package io.github.luiswolff.calc.app;


import io.github.luiswolff.calc.commands.CalculatorClient;
import io.github.luiswolff.calc.commands.CommandPanelCell;
import io.github.luiswolff.calc.commands.CommandPanelData;
import java.util.Arrays;
import java.util.List;

class CalculationController {

  CalculationController(CalculatorFrame calculatorFrame) {
    CalculatorClient calculatorClient = new CalculatorClient(
        calculatorFrame.getDisplayPane()::updateText);
    NumberFieldPanel numberFieldPanel = calculatorFrame.getNumberFieldPanel();

    CommandPanelData commandPanelData = calculatorClient.getCommandPanelData();
    List<CalculationCommandAction> actions = Arrays.stream(commandPanelData.cells())
        .map(this::toAction)
        .toList();
    numberFieldPanel.changeCommandPanel(commandPanelData.rows(), commandPanelData.columns(), actions);
  }

  CalculationCommandAction toAction(CommandPanelCell panelCell) {
    return new CalculationCommandAction(
        panelCell.command().appearance(),
        panelCell.command()::execute,
        panelCell.width(),
        panelCell.height()
    );
  }
}
