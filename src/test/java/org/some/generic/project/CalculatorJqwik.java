package org.some.generic.project;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

public class CalculatorJqwik {

  private Calculator calc = new Calculator();

  @Property
  boolean isAdditionCommutative(@ForAll int first, @ForAll int second) {
    int result1 = calc.add(first, second);
    int result2 = calc.add(second, first);
    return result1 == result2;
  }

  @Property
  boolean isMultiplicationCommutative(@ForAll int first, @ForAll int second) {
    int result1 = calc.mul(first, second);
    int result2 = calc.mul(second, first);
    return result1 == result2;
  }

  @Property
  boolean isMultiplicationAssociative(@ForAll int first, @ForAll int second, @ForAll int third) {
    int product1 = calc.mul(first, second);
    int result1 = calc.mul(product1, third);
    int product2 = calc.mul(second, third);
    int result2 = calc.mul(first, product2);
    return result1 == result2;
  }

  @Property
  boolean isDivisionMakesProperRemainder(@ForAll int first, @Positive @ForAll int second) {
    int result = calc.div(first, second);
    int remainder = first - second * result;
    return Math.abs(remainder) < second;
  }
}
