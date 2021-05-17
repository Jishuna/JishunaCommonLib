package me.jishuna.commonlib;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class WeightedRandom<T> {
	private final NavigableMap<Double, T> map = new TreeMap<Double, T>();
	private final Random random;
	private double total = 0;

	public WeightedRandom() {
		this(new Random());
	}

	public WeightedRandom(Random random) {
		this.random = random;
	}

	public WeightedRandom<T> add(double weight, T result) {
		if (weight <= 0)
			return this;

		total += weight;
		map.put(total, result);
		return this;
	}

	public T poll() {
		double value = random.nextDouble() * total;
		return map.higherEntry(value).getValue();
	}
}