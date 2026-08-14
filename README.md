Sample Calculator
===

This is a programming sample showing how a calculator application can be implemented in Java.

Motivation
---

The motivation was to build a Java application that is tested using an automated UI approach.
Furthermore, the implementation uses my interpretation of the command pattern defined by the Gang of Four.

Implementation
---

### Testing

For testing, I use a modern JUnit implementation as the test driver and for validation.
It instantiates the application UI and indexes the components by their names.
For UI automation, I use the JVM‑internal `java.awt.Robot` class.
Based on the screen positions of the expected UI components, the test performs mouse movements and clicks.

When working with the code, please be aware of the following:

 * While executing the tests, do not move your mouse, as this may lead to incorrect clicks.
 * When changing code, stay consistent with the expected naming conventions; otherwise, the expected components will not be found.

**Hint**: Particular attention can be paid to the tests for decimal calculations.
These are all test cases that will not work when calculations are performed using the primitive data types `float` or `double`.

### Command Pattern

The command pattern is implemented by separating the application in three main parts
 * Package `io.github.luiswolff.calc.engine`: Defines the logic for how calculations are performed.
 * Package `io.github.luiswolff.calc.commands`: Contains the commands that control the calculator engine. They are arranged into panels to define raster positions.
 * Package `io.github.luiswolff.calc.app`: Uses the command panels to render the UI using `javax.swing.*`.

**Hint**: Calculating the raster positions in the commands package makes the UI independent of the number of commands.

### Dependencies

The source code of the application is written for **Java SE 25** and can be built using **Maven 3**.

The project uses the following dependency:

 * __JUnit Jupiter Engine__: Test driver and validation

### Build

The following command builds the project:

```(cmd)
mvn clean package
```

After a build the application can be started with the following command:

```(cmd)
java -classpath target/sample-calculator-1.0-SNAPSHOT.jar io.github.luiswolff.calc.Launcher
```