package edu.cancellablefibonacci;

public abstract class Fibonacci {
	private Fibonacci() {
	}

	public static long fibonacciOf(long n) {
		if (Thread.currentThread().isInterrupted()) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("calculation cancelled");
		}
		if (n < 0) {
			throw new IllegalArgumentException("n must be >= 0, but was = '" + n + "'");
		}
		if (n == 0) {
			return 0;
		}
		if (n <= 2) {
			return 1;
		}
		return Math.addExact(fibonacciOf(n - 1), fibonacciOf(n - 2));
	}
}
