package edu.reflection;

import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name;
		while (true) {
			System.out.print("enter class name or «exit»:\n>>");
			name = in.nextLine().trim();

			if (name.equals("exit")) {
				System.out.println("bye");
				return;
			}

			try {
				Class<?> clazz = ReflectiveOperations.getClassByName(name);
				Constructor<?> constructor = ReflectiveOperations.getParameterlessConstructor(clazz);
				ReflectiveOperations.invokeMethods(constructor.newInstance(), ReflectiveOperations.getDeclaredMethods(clazz));
			} catch (ReflectiveOperationException ex) {
				ex.printStackTrace();
			}

			System.out.print("continue? y/n\n>>");
			if (Objects.equals(in.next(), "y")) {
				in.nextLine();
			} else {
				System.out.println("bye");
				return;
			}
		}
	}
}
