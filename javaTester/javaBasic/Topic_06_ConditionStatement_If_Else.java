package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_ConditionStatement_If_Else {

	Scanner scanner = new Scanner(System.in);

	public void TC_01() {
		System.out.println("Nhap vao so nguyen: ");
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("So " + number + " la so chan");
		} else {
			System.out.println("So " + number + " la so le");
		}

	}

	public void TC_02() {
		System.out.println("Nhap vao so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao so nguyen b: ");
		int b = scanner.nextInt();
		if (a >= b) {
			System.out.println("So " + a + "lon hon hoac bang so " + b);
		} else {
			System.out.println("So " + a + " nho hon so " + b);
		}

	}

	public void TC_03() {
		System.out.println("Nhap ten nguoi thu nhat: ");
		String a = scanner.nextLine();
		System.out.println("Nhap ten nguoi thu hai: ");
		String b = scanner.nextLine();
		if (a.equals(b)) {
			System.out.println("Hai nguoi cung ten");
		} else {
			System.out.println("Hai nguoi khac ten");
		}

	}

	public void TC_04() {
		System.out.println("Nhap vao so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao so nguyen b: ");
		int b = scanner.nextInt();
		System.out.println("Nhap vao so nguyen c: ");
		int c = scanner.nextInt();
		if (a > b && a > c) {
			System.out.println("So " + a + " la so lon nhat");
		} else if (b > c) {
			System.out.println("So " + b + " la so lon nhat");
		} else {
			System.out.println("So " + c + " la so lon nhat");
		}

	}

	public void TC_05() {
		System.out.println("Nhap vao so nguyen: ");
		int a = scanner.nextInt();
		if (a >= 10 && a <= 100) {
			System.out.println("So " + a + "nam trong [10,100]");
		} else {
			System.out.println("So " + a + " khong nam trong [10,100]");
		}
	}

	public void TC_06() {
		System.out.println("Nhap vao so diem: ");
		float a = scanner.nextFloat();
		if (a >= 0 && a < 5) {
			System.out.println("Diem xep hang: D");
		} else if (a >= 5 && a < 7.5) {
			System.out.println("Diem xep hang: C");
		} else if (a >= 7.5 && a <= 8.5) {
			System.out.println("Diem xep hang: B");
		} else if (a > 8.5 && a <= 10) {
			System.out.println("Diem xep hang: A");
		} else {
			System.out.println("Nhap khong dung dinh dang");

		}
	}

	@Test
	public void TC_07() {
		System.out.println("Nhap thang: ");
		int a = scanner.nextInt();
		if (a == 1 || a == 5 || a == 3 || a == 7 || a == 8 || a == 10 || a == 12) {
			System.out.println("Thang " + a + " co 31 ngay");
		} else if (a == 4 || a == 6 || a == 9 || a == 11) {
			System.out.println("Thang " + a + " co 30 ngay");
		} else if (a == 2) {
			System.out.println("Thang " + a + " co 28 hoac 29 ngay");
		} else {
			System.out.println("Nhap khong dung dinh dang. Hay nhap lai");
		}
	}

}
