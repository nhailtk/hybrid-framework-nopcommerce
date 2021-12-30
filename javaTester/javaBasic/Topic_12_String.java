package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String {
	public void TC_01() {
		String a = "AutoMation TesTing Basic";
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			char temp = a.charAt(i);
			if (temp >= 'A' && temp <= 'Z') {
				count++;
			}
		}
		System.out.println("Count: " + count);

	}

	
	public void TC_02() {
		String s = "Automation Testing 345 Tutorials Online 789";
		int countc = 0, count = 0;
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == 'a') {
				countc++;
			}
			if (temp >= '0' && temp <= '9') {
				count++;
			}
		}
		System.out.println("So luong ki tu '" +"a': "  + countc);
		System.out.println("Chuoi co chua tu '" + "Testing': " + s.contains("Testing"));
		System.out.println("Bat dau voi tu '" + "Automation': " + s.startsWith("Automation"));
		System.out.println("Ket thuc voi tu '" + "Online': " + s.endsWith("Online"));
		System.out.println("Vi tri cua tu  '" + "Tutorials': " + s.indexOf("Tutorials"));
		System.out.println("Thay the tu '" + "Online'" + " bang tu '" + "Offline': " + s.replace("Online", "Offline"));
		System.out.println("So luong ki tu la so: "  + count);
	}
	
	@Test
	public void TC_03() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap chuoi: ");
		String a = scanner.nextLine();
		System.out.print("Chuoi dao nguoc: ");
		for(int i= a.length()-1;i>=0; i--) {
			char temp = a.charAt(i);
			System.out.print(temp);
		}
		
	}
		}
