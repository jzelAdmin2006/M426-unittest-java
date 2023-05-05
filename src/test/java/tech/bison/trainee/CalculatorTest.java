package tech.bison.trainee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
  @Test
  void threeAndTwo_add_isFive() {
    int a = 2;
    int b = 3;
    int expected = 5;

    int actual = new Calculator().add(a, b);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void sixAndFour_subtract_isTwo() {
    int a = 6;
    int b = 4;
    int expected = 2;

    int actual = new Calculator().subtract(a, b);

    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{index} => {0}_factorial_is{1}")
  @CsvSource({ "0, 1", "1, 1", "2, 2", "5, 120" })
  void factorialTest(int x, int expected) {
    Calculator calculator = new Calculator();

    int actual = calculator.factorial(x);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void negativeNumber_factorial_isNotSupported() {
    int x = -1;

    assertThatThrownBy(() -> new Calculator().factorial(x)).isInstanceOf(UnsupportedOperationException.class)
        .hasMessageContaining("undefined");
  }
}
