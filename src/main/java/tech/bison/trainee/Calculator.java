package tech.bison.trainee;

import static java.util.stream.IntStream.rangeClosed;

public class Calculator {
  public int add(int summandA, int summandB) {
    return summandA + summandB;
  }

  public int subtract(int summandA, int summandB) {
    return summandA - summandB;
  }

  public int factorial(int x) {
    if (x < 0) {
      throw new UnsupportedOperationException("factorial undefined for negative values.");
    } else {
      return rangeClosed(1, x).reduce(1, (a, b) -> a * b);
    }
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public double divide(double a, double b) {
    if (b > 0) {
      return a / b;
    } else {
      throw new UnsupportedOperationException("division undefined for divisor zero.");
    }
  }
}
