package org.some.generic.project;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CalculatorTest {

  private Calculator calc = new Calculator();
  private final int x = 15;
  private final int y = 3;
  private final int NumberOfRuns = 15;

  @Test
  public void add() {
    int expected = x + y;
    int result = calc.add(x, y);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void mul() {
    int expected = x * y;
    int result = calc.mul(x, y);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void subs() {
    int result = calc.subtract(x, y);
    int expected = x - y;
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void addCallsWorks() {
    int result = 0;
    int initial = calc.getAddCalls();
    for (int i = 0; i < NumberOfRuns; i++) {
      result = calc.add(x, result);
    }
    assertThat(NumberOfRuns).isEqualTo(calc.getAddCalls() - initial);
  }

  @Test
  public void mulCallsWorks() {
    int result = 1;
    int initial = calc.getMulCalls();
    for (int i = 0; i < NumberOfRuns; i++) {
      result = calc.mul(x, result);
    }
    assertThat(NumberOfRuns).isEqualTo(calc.getMulCalls() - initial);
  }

  @Test
  public void subsCallsWorks() {
    int result = 1;
    int initial = calc.getSubsCalls();
    for (int i = 0; i < NumberOfRuns; i++) {
      result = calc.subtract(x, result);
    }
    assertThat(NumberOfRuns).isEqualTo(calc.getSubsCalls() - initial);
  }
}