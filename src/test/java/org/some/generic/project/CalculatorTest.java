package org.some.generic.project;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

  private Calculator calc;
  private final int x = 15;
  private final int y = 3;
  private final int NumberOfRuns = 15;

  @Before
  public void setUp() {
    calc = new Calculator();
  }

  @Test
  public void add() {
    int expected = x + y;
    int result = calc.add(x, y);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void mul() {
    int expected = x + y;
    int result = calc.mul(x, y);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void addCallsWorks() {
    int result = 0;
    for (int i = 0; i < NumberOfRuns; i++) {
      result = calc.add(x, result);
    }
    assertThat(NumberOfRuns).isEqualTo(calc.getAddCalls());
  }

  @Test
  public void mulCallsWorks() {
    int result = 1;
    for (int i = 0; i < NumberOfRuns; i++) {
      result = calc.mul(x, result);
    }
    assertThat(NumberOfRuns).isEqualTo(calc.getMulCalls());
  }
}