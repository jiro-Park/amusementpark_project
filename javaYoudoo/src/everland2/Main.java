package everland2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList; //깃에 워크스페이스 이클립스 폴더 통째로 올려야..import하기 쉬움
							// 파일 경로.. 그냥 파일명으로 찾을 수 있게끔

import javaEx2.FileWriteClass;

public class Main {
	static ArrayList<CustomerInfo> customerArr = new ArrayList<CustomerInfo>();

	public static void main(String[] args) throws IOException {
		File file = new File("out0.txt");
		InputClass ic = new InputClass();
		OutputClass oc = new OutputClass();
		CalculateClass cc = new CalculateClass();
		FileWrite fw = new FileWrite();
		FileRead fr = new FileRead();
		int ticketType, ticketNum, advantageType;
		String residentNum;

		CustomerInfo customerInfo = null;

		if (file.exists()) { 
			fr.readFromFile();
		} else { 
			fw.saveTitle();
		}
		
		
		do {			
			customerInfo = new CustomerInfo();

			ticketType = ic.InputTicketType();
			residentNum = ic.InputResidentNum();
			ticketNum = ic.InputTicketNum();
			advantageType = ic.InputAdvantageType();
			oc.printSum(ticketType, residentNum, ticketNum, advantageType);
			
            customerInfo.setDate();
			customerInfo.setTicketType(ticketType);
			customerInfo.setAgeType(residentNum);
			customerInfo.setTicketNum(ticketNum);
			customerInfo.setAdvantageType(advantageType);
			customerInfo.setMiniSum(cc.calMiniSum(ticketType, residentNum, ticketNum, advantageType));
			customerInfo.setTicketType_string();
			customerArr.add(customerInfo);

			if (ic.InputStopOrContinue() == 2)
				break;

		} while (true);

		oc.printTotal();
		fw.saveData();

	}
}
