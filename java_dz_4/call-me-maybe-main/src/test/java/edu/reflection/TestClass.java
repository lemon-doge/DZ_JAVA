package edu.reflection;

public class TestClass {
	@Order(1)
	@CallMe
	void callMeTrueOrder1() {
		System.out.println("callMe = true, order = 1");
	}

	@Order(1)
	@CallMe(maybe = false)
	void callMeFalseOrder1() {
		System.out.println("callMe = false, order = 1");
	}

	@Order(3)
	@CallMe
	void callMeTrueOrderGrt1() {
		System.out.println("callMe = true, order > 1");
	}

	@Order(1)
	@CallMe(maybe = false)
	void callMeFalseOrderGrt1() {
		System.out.println("callMe = false, order > 1");
	}

	@CallMe
	void callMeTrueNoOrder() {
		System.out.println("callMe = true, order = none");
	}

	@CallMe(maybe = false)
	void callMeFalseNoOrder() {
		System.out.println("callMe = false, order = none");
	}

	@Order(0)
	void noCallMeOrder0() {
		System.out.println("callMe = none, order = 0");
	}

	void noCallMeNoOrder() {
		System.out.println("callMe = none, order = none");
	}
}
