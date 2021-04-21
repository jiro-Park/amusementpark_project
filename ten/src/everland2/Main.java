package everland2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList; 

public class Main {                                                                          // 메인 클래스
	static ArrayList<CustomerInfo> customerArr = new ArrayList<CustomerInfo>();

	public static void main(String[] args) throws IOException {
		InputClass ic = new InputClass();
		OutputClass oc = new OutputClass();
		CalculateClass cc = new CalculateClass();
		FileWrite fw = new FileWrite();
		FileRead fr = new FileRead();
		CustomerInfo customerInfo = null;
		Database db = new Database();
		int ticketType, ticketNum, advantageType, sum;
		String residentNum;

		fr.fileCheck();             // 파일이 존재하는지 체크하고, 없으면 파일 생성과 함께 카테고리 입력 

		do {
			ticketType = ic.InputTicketType();                                 // 권종 입력
			residentNum = ic.InputResidentNum();                            // 주민번호 입력
			ticketNum = ic.InputTicketNum();                               // 티켓 매수 입력
			advantageType = ic.InputAdvantageType();                        // 우대사항 입력
			sum = cc.calMiniSum(ticketType, residentNum, ticketNum, advantageType);      // 현 주문에 대한 합계액 산출
			customerInfo = new CustomerInfo(cc.setDate(), ticketType, residentNum, ticketNum, advantageType, sum,
					cc.calAgeType(residentNum));                                             // 자료구조에 데이터 저장
			customerArr.add(customerInfo);                                               // arraylist에 자료구조 저장
			db.saveToDatabase(customerInfo);                                                // 데이터베이스에 자료 저장
			oc.printSum(ticketType, residentNum, ticketNum, advantageType);                    // 현 주문건 정보 출력

			if (ic.InputStopOrContinue() == 2)                                             // 계속 진행할 지 여부 입력
				break;
		} while (true);
		oc.printTotal();          // 모든 주문건 합산 출력                               
		fw.saveData();                 // 파일에 값 저장
	}
}
