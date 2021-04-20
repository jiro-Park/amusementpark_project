package everland2;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int InputTicketType() {          
		System.out.println("권종을 선택하세요.\n1. 주간권\n2. 야간권\n");
		int ticketType = sc.nextInt();
		while (ticketType != 1 && ticketType != 2) {
			System.out.println("다시 입력해주세요.");
			ticketType = sc.nextInt();
		}
		return ticketType;
	}

	public String InputResidentNum() {
		System.out.println("주민번호 7자리를 입력하세요.\n");
		String residentNum = sc.next();
		while (residentNum.length() != 7) {
			System.out.println("다시 입력해주세요.");
			residentNum = sc.next();
		}
		return residentNum;
	}

	public int InputTicketNum() {
		System.out.println("몇 개를 주문하시겠습니까? (최대 10개)\n");
		int ticketNum = sc.nextInt();
		while (ticketNum == 0 || ticketNum > 10) {
			System.out.println("다시 입력해주세요.");
			ticketNum = sc.nextInt();
		}
		return ticketNum;
	}

	public int InputAdvantageType() {
		System.out.println("우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인\n"
				+ "3. 국가유공자\n4. 다자녀\n5. 임산부\n");
		int advantageType = sc.nextInt();
		while (advantageType < 1 || advantageType > 5) {
			System.out.println("다시 입력해주세요.");
			advantageType = sc.nextInt();
		}
		return advantageType;
	}

	public int InputStopOrContinue() {
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
		int stopOrContinue = sc.nextInt();
		while (stopOrContinue != 1 && stopOrContinue != 2) {
			System.out.println("다시 입력해주세요.");
			stopOrContinue = sc.nextInt();
		}
		return stopOrContinue;
	}

}
