package javaBasic;

import org.testng.annotations.Test;

public class Topic_03_DataType {

	@Test
	public void TC_01() {
		int a = 6, b = 2;
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("a / b = " + (a / b));
	}

	@Test
	public void TC_02() {
		float chieuDai = 7.5f, chieuRong = 3.8f;
		System.out.println("Area = " + (chieuDai * chieuRong));
	}

	@Test
	public void TC_03() {
		String name = "Automation Testing";
		System.out.println("Hello " + name);
	}

}
