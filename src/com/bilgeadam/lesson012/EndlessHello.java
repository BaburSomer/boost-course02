package com.bilgeadam.lesson012;

public class EndlessHello {

	public static void main(String[] args) {
		sayHello(1);
	}

	private static void sayHello(int counter) {
		System.out.println(counter + ". Hello");
		sayHello(++counter);
	}
}
