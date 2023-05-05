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
}
