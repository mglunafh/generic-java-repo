package org.some.generic.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Calculator {

  private int addCalls;
  private int mulCalls;
  private int subsCalls;
  private int divCalls;
  private int gcdCalls;
  private int factCalls;

  /**
   * Calculates sum of two integers.
   * @param x first operand
   * @param y second operand
   * @return the sum of passed numbers
   */
  public int add(int x, int y) {
    addCalls++;
    return x + y;
  }

  public int mul(int x, int y) {
    mulCalls++;
    return x * y;
  }

  public int subtract(int x, int y) {
    subsCalls++;
    return x - y;
  }

  public int div(int x, int y) {
    divCalls++;
    return x / y;
  }

  public int gcd(int x, int y) {
    gcdCalls++;
    if (x == 0 || y == 0) {
      return 0;
    }
    x = Math.abs(x);
    y = Math.abs(y);

    int t = x % y;
    while (t != 0) {
      x = y;
      y = t;
      t = x % y;
    }
    return y;
  }

  public long fact(int n) {
    factCalls++;
    if (n < 0) {
      return 0;
    }
    long acc = 1;
    for (int i = 2; i <= n; i++) {
      acc *= i;
    }

    return acc;
  }

  public int arithmProgression(int a, int b, int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n should be non-negative");
    }

    int acc = a;
    for (int i = 0; i <= n; i++)  {
      acc += b;
    }
    return acc;
  }
}
