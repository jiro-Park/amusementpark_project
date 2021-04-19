package javaEx;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int inputFromConsoleWon() {
		int inputWon;

		System.out.println("원화 입력 : ");
		inputWon = sc.nextInt();
		return inputWon;
	}

	public int inputFromConsoleType() {
		int inputChangeType;

		System.out.println("환전할 종류 :\n " 
		                    + "1.USD\n " 
				            + "2.EUR\n " 
		                    + "3.JPY\n "
				            + "0.취소\n");
		inputChangeType = sc.nextInt();
		return inputChangeType;
	}
}

