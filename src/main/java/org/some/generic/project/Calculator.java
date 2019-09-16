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
}
