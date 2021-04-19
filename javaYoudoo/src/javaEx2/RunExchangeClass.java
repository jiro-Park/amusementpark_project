package javaEx2;

import java.io.IOException;

public class RunExchangeClass {
	public OutputClass outClass = null;
	public FileWriteClass fwc = null;

	public RunExchangeClass() {
		outClass = new OutputClass();
	}

	public void changeToUSD(int inputWon) throws IOException {          // 외화타입 달러를 선택했을 시의 동작
		fwc = new FileWriteClass();
		int result;                                                               //  환전 받을 달러 액수
		int exchgWon;                                                                   // 원화 거스름돈         

		result = (int) (inputWon / ConstValueClass.USD_RATE);                      // 환전 받는 달러 액수

		                                                        // 환전요청금액과 외화잔고상황에 따라 다르게 실행
		if (result <= ConstValueClass.BALANCE_USD) {                  // 제공할 외화보다 은행잔고가 더 클 경우
			outClass.outputResultUSD(result);                                       // 받을 달러 화폐 수량
			fwc.saveToFileResult(result);                                  // 파일에 환전 받는 달러 액수 기록

			exchgWon = (int) ((inputWon - result * ConstValueClass.USD_RATE) / 10) * 10;
			outClass.outputResultWon(exchgWon);                                   // 받을 원화 거스름돈 수량
			fwc.saveToFileExchgWon(exchgWon);                                       // 파일에 거스름돈 기록

			ConstValueClass.BALANCE_USD -= result;                         // 은행잔고에서 환전해간 외화를 제함
			fwc.saveToFileBalance(ConstValueClass.BALANCE_USD);               // 파일에 은행 달러 잔고를 기록
			outClass.printBalance();                         // 잔고가 있을 경우 환전해준 후 남은 외화 잔고를 출력

		} else {
			int errorCode = ConstValueClass.ERR_BALANCE_USD;
			outClass.printErrorMessage(errorCode);                         // 은행잔고 부족시 에러 메세지 출력
			fwc.saveToFileError();                                                // 파일에 에러 메세지 기록
		}                                              // 잔고가 부족할 경우 부족한 외화종류와 함께 에러메세지를 출력

	}

	public void changeToEUR(int inputWon) throws IOException {            // 외화타입 유로를 선택했을 시의 동작
		fwc = new FileWriteClass();
		int result;
		int exchgWon;
        
		result = (int) (inputWon / (ConstValueClass.EUR_RATE * 5)) * 5;              // 환전 받는 유로 액수
		                                            // 요즘은 환전소에서 1,2유로를 안 바꿔준대서? 5유로 단위부터 시작 

		                                                          // 환전요청금액과 외화잔고상황에 따라 다르게 실행
		if (result<=ConstValueClass.BALANCE_EUR) {                       // 제공할 외화보다 은행잔고가 더 클 경우
			outClass.outputResultEUR(result);                                         // 받을 유로 화폐 수량
			fwc.saveToFileResult(result);                                    // 파일에 환전 받는 유로 금액 기록

			exchgWon = (int) ((inputWon - result * ConstValueClass.EUR_RATE) / 10) * 10;
			outClass.outputResultWon(exchgWon);                                    // 받을 원화 거스름돈 수량
			fwc.saveToFileExchgWon(exchgWon);                                        // 파일에 거스름돈 기록

			ConstValueClass.BALANCE_EUR-=result;                            // 은행잔고에서 환전해간 외화를 제함
			fwc.saveToFileBalance(ConstValueClass.BALANCE_EUR);                // 파일에 은행 유로 잔고를 기록
			outClass.printBalance();                          // 잔고가 있을 경우 환전해준 후 남은 외화 잔고를 출력
			
					
		} else { 
			int errorCode = ConstValueClass.ERR_BALANCE_EUR;
			outClass.printErrorMessage(errorCode);                           // 은행잔고 부족시 에러 메세지 출력
			fwc.saveToFileError();                                                  // 파일에 에러 메세지 기록
		}                                                // 잔고가 부족할 경우 부족한 외화종류와 함께 에러메세지를 출력
	}

	public void changeToJPY(int inputWon) throws IOException {              // 외화타입 엔화를 선택했을 시의 동작
		fwc = new FileWriteClass();
		int result;
		int exchgWon;
            
		result = (int)((inputWon / ConstValueClass.JPY_RATE )/10) * 1000;              // 환전 받는 엔화 액수

		if (result/10000<=ConstValueClass.BALANCE_JPY) {                      // result/10000 => 만 엔 단위
			outClass.outputResultJPY(result);                                          // 받을 엔화 화폐 수량
			fwc.saveToFileResult(result);                                     // 파일에 환전 받는 엔화 금액 기록

			exchgWon = (int) ((inputWon - result / 1000 * ConstValueClass.JPY_RATE * 10) / 10) * 10;
            outClass.outputResultWon(exchgWon);                                      // 받을 원화 거스름돈 수량
            fwc.saveToFileExchgWon(exchgWon);                                          // 파일에 거스름돈 기록  
            
            
            ConstValueClass.BALANCE_JPY-=(double)result/10000;                 // result/10000 => 만 엔 단위
            fwc.saveToFileBalance(ConstValueClass.BALANCE_JPY);                   // 파일에 은행 엔화 잔고를 기록
			outClass.printBalance();                             // 잔고가 있을 경우 환전해준 후 남은 외화 잔고를 출력
		} else {
			int errorCode = ConstValueClass.ERR_BALANCE_JPY; 
			outClass.printErrorMessage(errorCode);                             // 은행잔고 부족시 에러 메세지 출력
			fwc.saveToFileError();                                                    // 파일에 에러 메세지 기록
		}                                                  // 잔고가 부족할 경우 부족한 외화종류와 함께 에러메세지를 출력
	}
}
