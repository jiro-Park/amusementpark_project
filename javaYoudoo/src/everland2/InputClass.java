package everland2;

import java.util.Scanner;

public class InputClass {
	Scanner sc = null;

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int InputTicketType() {
		System.out.println("권종을 선택하세요.\n1. 주간권\n2. 야간권\n");
		int TicketType = sc.nextInt();
		return TicketType;
	}

	public String InputResidentNum() {
		System.out.println("주민번호를 입력하세요.\n");
		String ResidentNum = sc.next();
		return ResidentNum;
	}
	
	public int InputTicketNum() {
		System.out.println("몇 개를 주문하시겠습니까? (최대 10개)\n");
		int ticketNum = sc.nextInt();
		return ticketNum;
	}

	public int InputAdvantageType() {
		System.out.println("우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인\n3. 국가유공자\n4. 다자녀\n5. 임산부\n");
		int advantageType = sc.nextInt();
		return advantageType;
	}

	public int InputStopOrContinue() {
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
		int stopOrContinue = sc.nextInt();
		return stopOrContinue;
	}

}
