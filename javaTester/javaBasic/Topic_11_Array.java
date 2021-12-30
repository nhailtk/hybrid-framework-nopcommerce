package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_Array {

	int arr[] = { 1, 8, 6, 9, 4, 5, 10 };

	public void TC_01_Max_In_Array() {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (temp < arr[i]) {
				temp = arr[i];
			}
		}
		System.out.println("Max numer: " + temp);

	}

	public void TC_02_Sum_Of_Begin_And_End() {
		System.out.println("Sum: " + (arr[0] + arr[arr.length - 1]));
	}

	public void TC_03_Even_number() {
		System.out.print("Even numers: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
			}
		}

	}

	public void TC_04_Sum_Condition() {
		int a[] = { 1, -2, -3, 5, 7, 8, 0, -4 };
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				sum += a[i];

			}
		}
		System.out.println("Sum: " + sum);

	}

	@Test
	public void TC_05() {
		int b[] = { 1, -2, -3, 5, 7, 8, 0, -4 };
		for (int i = 0; i < b.length; i++) {
			if (b[i] >= 0 && b[i] <= 10) {
				System.out.print(b[i] + " ");
			}
		}
	}

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
