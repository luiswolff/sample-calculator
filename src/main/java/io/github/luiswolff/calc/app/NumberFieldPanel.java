package io.github.luiswolff.calc.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

class NumberFieldPanel extends JPanel {

  private final CalculatorFrame calculatorFrame;
  private final GridBagConstraints gbc = new GridBagConstraints();

  NumberFieldPanel(CalculatorFrame calculatorFrame) {
    this.calculatorFrame = calculatorFrame;
    GridBagLayout layout = new GridBagLayout();

    layout.setConstraints(this, gbc);
    setLayout(layout);
  }

  void changeCommandPanel(int rows, int columns, List<CalculationCommandAction> actions) {
    removeAll();
    invalidate();

    calculatorFrame.setSize(columns * 47, rows * 37 + 20);

    record GridCell(int gridx, int gridy) {

      @Override
      public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        GridCell gridCell = (GridCell) o;
        return gridx == gridCell.gridx && gridy == gridCell.gridy;
      }

      @Override
      public int hashCode() {
        int result = gridx;
        result = 31 * result + gridy;
        return result;
      }
    }

    var gridCellsToSkip = new HashSet<GridCell>();
    var actionIterator = actions.iterator();
    for (int gridy = 0; gridy < rows; gridy++) {
      for (int gridx = 0; gridx < columns ; gridx++) {
        if (gridCellsToSkip.contains(new GridCell(gridx, gridy)) || !actionIterator.hasNext()) {
          continue;
        }
        var action = actionIterator.next();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridheight = action.height();
        gbc.gridwidth = action.width();

        add(new NumberButton(action), gbc);

        for (int skipX = 0; skipX < action.width(); skipX++) {
          for (int skipY = 0; skipY < action.height(); skipY++) {
            if (skipX == 0 && skipY == 0) {
              continue;
            }
            gridCellsToSkip.add(new GridCell(gridx + skipX, gridy + skipY));
          }
        }
      }
    }

    validate();
  }

  private static class NumberButton extends JButton {

    NumberButton(CalculationCommandAction action) {
      super(action);
      setName("button-" + getText());
    }
  }
}
