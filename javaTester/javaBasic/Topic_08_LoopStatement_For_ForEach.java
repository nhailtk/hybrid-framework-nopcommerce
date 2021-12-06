package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_LoopStatement_For_ForEach {

	Scanner scanner = new Scanner(System.in);

	public void TC_01() {
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
	}

	public void TC_02() {
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap so nguyen b (b>a): ");
		int b = scanner.nextInt();
		for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
		}
	}

	public void TC_03() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("Tong cac so chan tu 1 den 10: " + sum);

	}

	public void TC_04() {
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap so nguyen b (b>a): ");
		int b = scanner.nextInt();
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println("Tong cac so tu " + a + " den " + b + ": " + sum);
	}

	public void TC_05() {
		int sum = 0;
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		for (int i = 0; i <= n; i++) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println("Tong cac so le tu 0 den " + n + ": " + sum);
	}

	
	public void TC_06() {
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap so nguyen b (b>a): ");
		int b = scanner.nextInt();
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	@Test
	public void TC_07() {
		int giaithua = 1;
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			giaithua *= i;
		}
		System.out.println("Giai thua của " + n + ": " + giaithua);
	}

}
