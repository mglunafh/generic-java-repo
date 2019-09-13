package org.some.generic.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Calculator {

  private int addCalls;
  private int mulCalls;

  public int add(int x, int y) {
    addCalls++;
    return x + y;
  }

  public int mul(int x, int y) {
    mulCalls++;
    return x * y;
  }
}
