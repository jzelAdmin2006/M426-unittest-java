package tech.bison.trainee.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

public class AverageTest {
	@Test
	void oneAndFour_mean_isTwoPointFive() {
		double[] numbers = new double[] { 1, 4 };
		double expected = 2.5;

		double actual = new Average(numbers).mean();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void fiveNumbers_mean_isCorrect() {
		double[] numbers = new double[] { 1, 2, 3, 4, 5 };
		double expected = 3;

		double actual = new Average(numbers).mean();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void noNumbers_mean_isNotSupported() {
		double[] numbers = new double[] {};

		ThrowingCallable shouldRaiseThrowable = () -> new Average(numbers).mean();

		assertThatThrownBy(shouldRaiseThrowable).isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("undefined");
	}

	@Test
	void oddNumberOfElements_median_isMiddleElement() {
		double[] numbers = new double[] { 2, 4, 5, 6, 7, 10, 12 };
		double expected = 6;

		double actual = new Average(numbers).median();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void evenNumberOfElements_median_isMeanOfMiddleElements() {
		double[] numbers = new double[] { 2, 4, 5, 6, 7, 20, 63, 100 };
		double expected = 6.5;

		double actual = new Average(numbers).median();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void noNumbers_median_isNotSupported() {
		double[] numbers = new double[] {};

		ThrowingCallable shouldRaiseThrowable = () -> new Average(numbers).median();

		assertThatThrownBy(shouldRaiseThrowable).isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("undefined");
	}
}
