package io.github.luiswolff.calc.commands;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CommandPanel {
  private final int rows;
  private final int columns;
  private final List<CommandPanelCell> commandPanelCells = new LinkedList<>();
  private GridCell nextGridCell = new GridCell(0, 0);
  private final Set<GridCell> gridCellsToSkip = new HashSet<>();

  CommandPanel(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public List<CommandPanelCell> getCommandPanelCells() {
    return Collections.unmodifiableList(commandPanelCells);
  }

  void add(CalculationCommand command) {
    add(1, 1, command);
  }

  void add(int wight, int height, CalculationCommand command) {
    commandPanelCells.add(new CommandPanelCell(nextGridCell.gridx(),
        nextGridCell.gridy(),
        wight,
        height,
        command));
    calculateGridCellsToSkip();
    calculateNextGridCell();
  }

  private void calculateGridCellsToSkip() {
    var cell = commandPanelCells.getLast();
    for (int skipX = 0; skipX < cell.width(); skipX++) {
      for (int skipY = 0; skipY < cell.height(); skipY++) {
        if (skipX == 0 && skipY == 0) {
          continue;
        }
        gridCellsToSkip.add(new GridCell(cell.gridx() + skipX, cell.gridy() + skipY));
      }
    }
  }

  private void calculateNextGridCell() {
    GridCell nextGridCell = this.nextGridCell;
    do {
      nextGridCell = new GridCell(nextGridCell.gridx() + 1, nextGridCell.gridy());
      if (nextGridCell.gridx() >= columns) {
        nextGridCell = new GridCell(0, nextGridCell.gridy() + 1);
      }
    } while (gridCellsToSkip.contains(nextGridCell));
    this.nextGridCell = nextGridCell;
  }

  private record GridCell (int gridx, int gridy) {}
}
