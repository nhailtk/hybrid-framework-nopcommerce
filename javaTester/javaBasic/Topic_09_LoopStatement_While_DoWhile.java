package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_LoopStatement_While_DoWhile {

	Scanner scanner = new Scanner(System.in);

	public void TC_01() {
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		while (n <= 100) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
			n++;
		}
	}

	public void TC_02() {
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap so nguyen b (b>a): ");
		int b = scanner.nextInt();
		while (a <= b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.print(a + " ");
			}
			a++;

		}
	}

	public void TC_03() {
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		int i = 0, sum = 0;
		while (i <= n) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
			i++;
		}
		System.out.println("Sum: " + sum);

	}

	public void TC_04() {
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap so nguyen b (b>a): ");
		int b = scanner.nextInt();
		while (a <= b) {
			if (a % 3 == 0) {
				System.out.print(a + " ");
			}
			a++;
		}

	}

	public void TC_05() {
		int giaithua = 1;
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		int i = 1;
		while (i <= n) {
			giaithua *= i;
			i++;
		}
		System.out.println("Giai thua của " + n + ": " + giaithua);
	}

	public void TC_05_Do_While() {
		int giaithua = 1;
		System.out.println("Nhap so nguyen:");
		int n = scanner.nextInt();
		int i = 1;
		do {
			giaithua *= i;
			i++;
		} while (i <= n);
		System.out.println("Giai thua của " + n + ": " + giaithua);
	}

	@Test
	public void TC_06() {
		int i = 1, sum = 0;
		while (i <= 10) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("Sum: " + sum);
	}

}
