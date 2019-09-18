package org.some.generic.project;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  private Calculator calc = new Calculator();
  private final int x = 15;
  private final int y = 3;
  private final int numberOfRuns = 15;

  @BeforeEach
  public void setUp() {
    System.out.println("Running new test");
  }

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
  public void divRegular() {
    int result = calc.div(x, y);
    int expected = x / y;
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void divExceptional() {
    int divisor = 0;
    assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> calc.div(x, divisor));
  }

  @Test
  public void gcd() {
    int result = calc.gcd(1024, 36);
    int expected = 4;
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void fact() {
    long result = calc.fact(5);
    long expected = 120;
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void addCallsWorks() {
    int result = 0;
    int initial = calc.getAddCalls();
    for (int i = 0; i < numberOfRuns; i++) {
      result = calc.add(x, result);
    }
    assertThat(numberOfRuns).isEqualTo(calc.getAddCalls() - initial);
  }

  @Test
  public void mulCallsWorks() {
    int result = 1;
    int initial = calc.getMulCalls();
    for (int i = 0; i < numberOfRuns; i++) {
      result = calc.mul(x, result);
    }
    assertThat(numberOfRuns).isEqualTo(calc.getMulCalls() - initial);
  }

  @Test
  public void subsCallsWorks() {
    int result = 1;
    int initial = calc.getSubsCalls();
    for (int i = 0; i < numberOfRuns; i++) {
      result = calc.subtract(x, result);
    }
    assertThat(numberOfRuns).isEqualTo(calc.getSubsCalls() - initial);
  }

  @Test
  public void divCallsWorks() {
    int result = 1;
    int initial = calc.getSubsCalls();
    for (int i = 0; i < numberOfRuns; i++) {
      result = calc.div(x, result);
    }
    assertThat(numberOfRuns).isEqualTo(calc.getDivCalls() - initial);
  }

  @Test
  public void gcdCallsWorks() {
    int result = 1;
    int initial = calc.getGcdCalls();
    for (int i = 1; i <= numberOfRuns; i++) {
      result = calc.gcd(x, i);
    }
    assertThat(numberOfRuns).isEqualTo(calc.getGcdCalls() - initial);
  }

  @Test
  public void factCallsWorks() {
    long result = 1;
    int initial = calc.getFactCalls();
    for (int i = 0; i < numberOfRuns; i++) {
      result = calc.fact(i);
    }
    assertThat(numberOfRuns).isEqualTo(calc.getFactCalls() - initial);
  }
}