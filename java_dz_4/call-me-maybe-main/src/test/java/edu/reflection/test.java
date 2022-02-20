package edu.reflection;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class test {
	String name = TestClass.class.getName();
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	@Order(1)
	public void testClassByNameExists() throws ClassNotFoundException {
		assertEquals(TestClass.class, ReflectiveOperations.getClassByName(name));
	}

	@Test
	@Order(2)
	public void testClassByNameDoesntExist() {
		assertNotNull(assertThrows(ClassNotFoundException.class, () -> {
			ReflectiveOperations.getClassByName("asd");
		}));
	}

	@Test
	@Order(3)
	public void testGetParameterlessConstructor() {
		assertDoesNotThrow(() -> assertNotNull(ReflectiveOperations.getParameterlessConstructor(ReflectiveOperations.getClassByName(name))));
	}

	@Test
	@Order(4)
	public void testGetMarkedMethods() {
		assertDoesNotThrow(() -> assertEquals(8, ReflectiveOperations.getDeclaredMethods(ReflectiveOperations.getClassByName(name)).length));
	}

	@Order(5)
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	@Order(6)
	public void testInvokeMarkedMethods() {
		assertDoesNotThrow(
				() -> ReflectiveOperations.invokeMethods(
						ReflectiveOperations.getParameterlessConstructor(
								ReflectiveOperations.getClassByName(name)).newInstance(),
						ReflectiveOperations.getDeclaredMethods(
								ReflectiveOperations.getClassByName(name))));

//		assertEquals(
//				"""
//						callMe = true, order = none
//						callMe = true, order = 1
//						callMe = true, order > 1
//						""", outputStreamCaptor.toString());
	}

	@Order(7)
	public void tearDown() {
		System.setOut(standardOut);
	}

}
