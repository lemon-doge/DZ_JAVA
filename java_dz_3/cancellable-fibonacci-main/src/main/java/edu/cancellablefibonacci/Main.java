package edu.cancellablefibonacci;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Future<?> future = null;
		final ExecutorService pool = Executors.newCachedThreadPool();

		int n;

		while (true) {
			System.out.println("enter n or <exit>: ");
			String input = scanner.nextLine();

			if (Objects.equals(input, "exit")) {
				pool.shutdownNow();
				break;
			}

			try {
				n = Integer.parseInt(input);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				continue;
			}

			if (future != null && !future.isDone()) {
				future.cancel(true);
			}

			int finalN = n;
			future = pool.submit(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("fibonacci of " + finalN + " is: " + Fibonacci.fibonacciOf(finalN));
					} catch (IllegalArgumentException ex) {
						System.out.println(ex.getMessage());
					} catch (RuntimeException ex) {
						System.out.println("calculation cancelled for: " + finalN);
					}
				}
			});
		}
	}
}
