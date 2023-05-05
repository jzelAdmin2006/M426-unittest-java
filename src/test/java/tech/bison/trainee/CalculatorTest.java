package tech.bison.trainee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
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

    ThrowingCallable shouldRaiseThrowable = () -> new Calculator().factorial(x);

    assertThatThrownBy(shouldRaiseThrowable).isInstanceOf(UnsupportedOperationException.class)
        .hasMessageContaining("undefined");
  }

  @Test
  void threeAndFour_multiply_isTwelve() {
    int a = 3;
    int b = 4;
    int expected = 12;

    int actual = new Calculator().multiply(a, b);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void twentyOneandThree_divide_isSeven() {
    int a = 21;
    int b = 3;
    double expected = 7;

    double actual = new Calculator().divide(a, b);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void twoAndSeven_divide_isAboutTwoSeventh() {
    int a = 2;
    int b = 7;
    double expected = 0.2857142857;
    double tolerance = 0.000000001;

    double actual = new Calculator().divide(a, b);

    assertThat(actual).isCloseTo(expected, within(tolerance));
  }
}
