package tech.bison.trainee.calculator;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

public class Average {

	private final double[] numbers;

	public Average(double[] numbers) {
		this.numbers = numbers;
	}

	public double mean() {
		if (numbers.length >= 1) {
			return new Mean().evaluate(numbers);
		} else {
			throw new IllegalStateException("mean of no numbers is undefined.");
		}
	}

	public double median() {
		// TODO Auto-generated method stub
		return 0;
	}
}
