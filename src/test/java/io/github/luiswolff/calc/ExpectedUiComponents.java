package io.github.luiswolff.calc;

enum ExpectedUiComponents {
  BUTTON_ZERO("button-0"),
  BUTTON_ONE("button-1"),
  BUTTON_TWO("button-2"),
  BUTTON_THREE("button-3"),
  BUTTON_FOUR("button-4"),
  BUTTON_FIVE("button-5"),
  BUTTON_SIX("button-6"),
  BUTTON_SEVEN("button-7"),
  BUTTON_EIGHT("button-8"),
  BUTTON_NINE("button-9"),
  BUTTON_PLUS("button-+"),
  BUTTON_MINUS("button--"),
  BUTTON_MULTIPLY("button-*"),
  BUTTON_DEVIATE("button-/"),
  BUTTON_EQUALS("button-="),
  BUTTON_CLEAR("button-C"),
  DISPLAY("display"),
  ;

  private final String componentName;

  ExpectedUiComponents(String componentName) {
    this.componentName = componentName;
  }

  String getComponentName() {
    return componentName;
  }
}
