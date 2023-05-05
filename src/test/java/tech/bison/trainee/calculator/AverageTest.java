package tech.bison.trainee.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

	@ParameterizedTest(name = "{2}_mode_is{3}")
	@MethodSource("provideValuesForMode")
	void one_mode_isOne(double[] numbers, double[] expected, String inputName, String resultName) {
		double[] actual = new Average(numbers).mode();

		assertThat(actual).isEqualTo(expected);
	}

	private static Stream<Arguments> provideValuesForMode() {
		return Stream.of(Arguments.of(new double[] { 1 }, new double[] { 1 }, "one", "One"),
				Arguments.of(new double[] { 1, 1 }, new double[] { 1 }, "oneOne", "OneOne"),
				Arguments.of(new double[] { 1, 1, 2 }, new double[] { 1 }, "oneOneTwo", "OneOne"),
				Arguments.of(new double[] { 1, 1, 2, 2 }, new double[] { 1, 2 }, "oneOneTwoTwo", "OneTwo"),
				Arguments.of(new double[] { 1, 1, 2, 2, 3 }, new double[] { 1, 2 }, "oneOneTwoTwoThree", "OneTwo"),
				Arguments.of(new double[] { 1, 1, 2, 2, 3, 3 }, new double[] { 1, 2, 3 }, "oneToThreeEachTwice",
						"OneTwoThree"),
				Arguments.of(new double[] { 1, 1, 2, 2, 3, 3, 3 }, new double[] { 3 }, "threeIsMostCommon", "Three"));
	}

	@ParameterizedTest(name = "noNumbers_{1}_isNotSupported")
	@MethodSource("provideThrowingCallables")
	void noNumbers_operations_areNotSupported(ThrowingCallable operation, String operationName) {
		assertThatThrownBy(operation).isInstanceOf(IllegalStateException.class).hasMessageContaining("undefined");
	}

	private static Stream<Arguments> provideThrowingCallables() {
		double[] numbers = new double[] {};
		Average average = new Average(numbers);

		return Stream.of(Arguments.of((ThrowingCallable) average::mean, "mean"),
				Arguments.of((ThrowingCallable) average::median, "median"),
				Arguments.of((ThrowingCallable) average::mode, "mode"));
	}
}
