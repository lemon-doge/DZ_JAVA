package edu.reflection;

public class CarlyRaeJepsen {
	@Order(1)
	@CallMe
	void sayHello() {
		System.out.println("Hello");
	}

	@Order(2)
	@CallMe
	void hereIsMyNumber() {
		System.out.println("Here's my number");
	}

	@Order(3)
	@CallMe
	void soCallMe() {
		System.out.println("So call me");
	}

	@Order(4)
	@CallMe(maybe = false)
	void maybe() {
		System.out.println("Maybe");
	}

	@Order(Integer.MAX_VALUE)
	@CallMe
	void theLastOne() {
		System.out.println("А меня надо вызвать последним");
	}

	@CallMe
	void withoutOrder() {
		System.out.println("А я без @Order'а меня можно вызывать в любом порядке");
	}
}
