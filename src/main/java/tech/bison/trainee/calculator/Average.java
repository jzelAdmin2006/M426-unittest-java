package tech.bison.trainee.calculator;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

public class Average {

  private final double[] numbers;

  public Average(double[] numbers) {
    this.numbers = numbers;
  }

  public double mean() {
    return new Mean().evaluate(numbers);
  }
}
