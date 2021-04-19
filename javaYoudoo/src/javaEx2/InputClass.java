package javaEx2;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int inputFromConsoleWon() {    // 안내메시지 출력과 환전요청금액 입력
		int inputWon;

		System.out.println("원화 입력 : ");
		inputWon = sc.nextInt();
		return inputWon;
	}

	public int inputFromConsoleType() {      // 안내메시지 출력과 외화타입 입력
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

