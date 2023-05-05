package tech.bison.trainee.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AverageTest {
  @Test
  void oneAndFour_mean_isTwoPointFive() {
    double[] numbers = new double[] { 1, 4 };
    double expected = 2.5;

    double actual = new Average(numbers).mean();

    assertThat(actual).isEqualTo(expected);
  }
}
