package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_ConditionStatement_Switch_Case {

	Scanner scanner = new Scanner(System.in);
	
	
	public void TC_01() {
		System.out.println("Nhap so nguyen:");
		int n= scanner.nextInt();
		switch (n) {
		case 1: {
			System.out.println("One");
			break;
		}
		case 2: {
			System.out.println("Two");
			break;
		}
		case 3: {
			System.out.println("Three");
			break;
		}
		case 4: {
			System.out.println("Four");
			break;
		}
		case 5: {
			System.out.println("Five");
			break;
		}
		case 6: {
			System.out.println("Six");
			break;
		}
		case 7: {
			System.out.println("Seven");
			break;
		}
		case 8: {
			System.out.println("Eight");
			break;
		}
		case 9: {
			System.out.println("Nine");
			break;
		}
		case 10: {
			System.out.println("Ten");
			break;
		}
		
		default:
			System.out.println("Invalid value. Please input data!");
			break;
		}

	}

	
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operation = scanner.next();
		switch (operation) {
		case "+": {
			
			System.out.println("Tong cua a va b: " + (a+b));
			break;
		}
		case "-": {
			
			System.out.println("Hieu cua a va b: " + (a-b));
			break;
		}
		case "*": {
			
			System.out.println("Tich cua a va b: " + (a*b));
			break;
		}
		case "/": {
			
			System.out.println("Thuong cua a va b: " + (a/b));
			break;
		}
		case "%": {
			
			System.out.println("Phan du cua a va b: " + (a%b));
			break;
		}
		
		default:
			System.out.println("Du lieu khong hop le. Vui long nhap lai!");
			break;
		}
		

	}

	@Test
	public void TC_03() {
		System.out.println("Nhap thang: ");
		int m = scanner.nextInt();
		switch(m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8: 
		case 10:
		case 12:
			System.out.println("Thang co 31 ngay");
			break;
		case 2:
			System.out.println("Thang cos 28 hoac 29 ngay");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Thang co 30 ngay");
			break;
		default:
			System.out.println("Du lieu khong hop le. Vui long nhap lai!");
			break;
		}

	}


}
