package org.some.generic.project;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

  private Calculator calc;
  private int x = 15;
  private int y = 3;

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
    int n = 15;
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = calc.add(x, result);
    }
    assertThat(n).isEqualTo(calc.getAddCalls());
  }

  @Test
  public void mulCallsWorks() {
    int n = 10;
    int result = 1;
    for (int i = 0; i < n; i++) {
      result = calc.mul(x, result);
    }
    assertThat(n).isEqualTo(calc.getMulCalls());
  }
}