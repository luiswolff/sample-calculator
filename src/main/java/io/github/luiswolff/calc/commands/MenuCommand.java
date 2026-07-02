package io.github.luiswolff.calc.commands;

public interface MenuCommand {
  void execute();
  String appearance();
  boolean isDefault();
}
