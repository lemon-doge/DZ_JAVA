package edu.reflection;

public class TestClass {
	private static String output = "";

	public static String getString() {
		return new String(output);
	}

	@Order(1)
	@CallMe
	void callMeTrueOrder1() {
		output += "callMe = true, order = 1\n";
	}

	@Order(1)
	@CallMe(maybe = false)
	void callMeFalseOrder1() {
		output += "callMe = false, order = 1\n";
	}

	@Order(3)
	@CallMe
	void callMeTrueOrderGrt1() {
		output += "callMe = true, order > 1\n";
	}

	@Order(1)
	@CallMe(maybe = false)
	void callMeFalseOrderGrt1() {
		output += "callMe = false, order > 1\n";
	}

	@CallMe
	void callMeTrueNoOrder() {
		output += "callMe = true, order = none\n";
	}

	@CallMe(maybe = false)
	void callMeFalseNoOrder() {
		output += "callMe = false, order = none\n";
	}

	@Order(0)
	void noCallMeOrder0() {
		output += "callMe = none, order = 0\n";
	}

	void noCallMeNoOrder() {
		output += "callMe = none, order = none\n";
	}
}
