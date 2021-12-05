package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Operator {

	@Test
	public void TC_01() {
		String name = " Nguyen Thi Mai Anh";
		int age = 21;
		System.out.println("After 15 years, age of " + name + " will be " + (age + 15));
	}

	@Test
	public void TC_02() {
		int a = 6;
		int b = 8;
		a = b;
		b = a - 2;
		System.out.println("After swapping then a = " + a + ", b = " + b);
	}

	@Test
	public void TC_03() {
		boolean c = compareNumber(8, 6);
		System.out.println(c);
	}

	public boolean compareNumber(int a, int b) {
		return (a > b) ? true : false;
	}
}
