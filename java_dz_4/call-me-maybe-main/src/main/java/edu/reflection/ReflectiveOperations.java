package edu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

public class ReflectiveOperations {

	@org.jetbrains.annotations.NotNull
	public static Class<?> getClassByName(String name) throws ClassNotFoundException {
		return Class.forName(name);
	}

	@org.jetbrains.annotations.NotNull
	public static Constructor<?> getParameterlessConstructor(Class<?> clazz) throws NoSuchMethodException {
		return clazz.getConstructor();
	}

	@org.jetbrains.annotations.NotNull
	public static Method[] getDeclaredMethods(Class<?> clazz) throws IllegalAccessException {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (!method.trySetAccessible()) {
				throw new IllegalAccessException("unable to set accessible on method:" + method.toString());
			}
		}
		return methods;
	}

	public static void invokeMethods(Object instance, Method[] methods) throws InvocationTargetException, IllegalAccessException {
		var sortedMethods = Arrays.stream(methods)
				.filter(method -> method.getAnnotation(CallMe.class) != null)
				.filter(method -> method.getAnnotation(CallMe.class).maybe())
				.sorted(Comparator.comparing(method -> method.getAnnotation(Order.class) == null ? 0 : method.getAnnotation(Order.class).value())).toList();
		for (Method method : sortedMethods) {
			// todo запуск методов с параметрами ?
//			var params = method.getParameterTypes();
//			var instances = Arrays.stream(params).map(x -> x.newInstance()).toList();
//			method.invoke(instance, instances);
			method.invoke(instance);
		}
	}


}
