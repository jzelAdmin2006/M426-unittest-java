package tech.bison.trainee.calculator;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Median;

public class Average {

	private final double[] numbers;

	public Average(double[] numbers) {
		this.numbers = numbers;
	}

	public double mean() {
		if (numbersAreDefined()) {
			return new Mean().evaluate(numbers);
		} else {
			throw new IllegalStateException("mean of no numbers is undefined.");
		}
	}

	public double median() {
		if (numbersAreDefined()) {
			return new Median().evaluate(numbers);
		} else {
			throw new IllegalStateException("median of no numbers is undefined.");
		}
	}

	public double[] mode() {
		if (numbersAreDefined()) {
			return StatUtils.mode(numbers);
		} else {
			throw new IllegalStateException("mode of no numbers is undefined.");
		}
	}

	public double standardDevitation() {
		if (numbersAreDefined()) {
			return new StandardDeviation(false).evaluate(numbers);
		} else {
			throw new IllegalStateException("standard devitation of no numbers is undefined.");
		}
	}

	private boolean numbersAreDefined() {
		return numbers.length >= 1;
	}
}
