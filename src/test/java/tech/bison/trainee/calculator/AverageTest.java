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
}
