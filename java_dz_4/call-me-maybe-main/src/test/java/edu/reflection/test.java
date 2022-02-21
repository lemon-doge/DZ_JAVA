package edu.reflection;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class test {
	String name = TestClass.class.getName();

	@Test
	public void testClassByNameExists() throws ClassNotFoundException {
		assertEquals(TestClass.class, ReflectiveOperations.getClassByName(name));
	}

	@Test
	public void testClassByNameDoesntExist() {
		assertNotNull(assertThrows(ClassNotFoundException.class, () -> {
			ReflectiveOperations.getClassByName("asd");
		}));
	}

	@Test
	public void testGetParameterlessConstructor() {
		assertDoesNotThrow(() -> assertNotNull(ReflectiveOperations.getParameterlessConstructor(ReflectiveOperations.getClassByName(name))));
	}

	@Test
	public void testGetMarkedMethods() {
		assertDoesNotThrow(() -> assertEquals(9, ReflectiveOperations.getDeclaredMethods(ReflectiveOperations.getClassByName(name)).length));
	}

	@Test
	public void testInvokeMarkedMethods() {
		assertDoesNotThrow(
				() -> ReflectiveOperations.invokeMethods(
						ReflectiveOperations.getParameterlessConstructor(
								ReflectiveOperations.getClassByName(name)).newInstance(),
						ReflectiveOperations.getDeclaredMethods(
								ReflectiveOperations.getClassByName(name))));

		assertEquals(
				"""
						callMe = true, order = none
						callMe = true, order = 1
						callMe = true, order > 1
						""", TestClass.getString());
	}
}
