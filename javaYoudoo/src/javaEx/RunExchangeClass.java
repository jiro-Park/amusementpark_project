package javaEx2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RunExchangeClass {
	
	public OutputClass outClass = null;
	
	public RunExchangeClass() {
		outClass = new OutputClass();
	}

	public void changeToUSD(int inputWon) throws IOException {
		File f = new File("C:\\Users\\p\\Desktop\\out.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
		int result;
		int exchgWon;

		result = (int) (inputWon / ConstValueClass.USD_RATE);
		
		// 외화 잔고 상황에 따라 다르게 동작한다.
		if (result <= ConstValueClass.BALANCE_USD) {
			bw.write(String.valueOf("환전금액 : "+result+"달러/"));
			outClass.outputResultUSD(result);

			exchgWon = (int) ((inputWon - result * ConstValueClass.USD_RATE) / 10) * 10;
			outClass.outputResultWon(exchgWon);
			bw.write(String.valueOf("거스름돈 : "+exchgWon+"원/"));
			bw.flush();

			ConstValueClass.BALANCE_USD-=result;
			outClass.printBalance(); // 잔고가 있을 경우 환전을 해준 후 남은 외화 잔고를 출력함.
			
		} else { 
			int errorCode = ConstValueClass.ERR_BALANCE_USD;
			outClass.printErrorMessage(errorCode); 
		} // 잔고가 부족할 경우 부족한 외화 종류와 함께 에러메세지를 출력함.

	}

	public void changeToEUR(int inputWon) {
		int result;
		int exchgWon;
        
		result = (int) (inputWon / (ConstValueClass.EUR_RATE * 5)) * 5;
		// 요즘은 환전소에 1,2유로가 없대서 5유로 단위부터 시작해보았다. 

		// 외화 잔고 상황에 따라 다르게 동작한다.
		if (result<=ConstValueClass.BALANCE_EUR) {
			outClass.outputResultEUR(result);

			exchgWon = (int) ((inputWon - result * ConstValueClass.EUR_RATE) / 10) * 10;
			outClass.outputResultWon(exchgWon);

			ConstValueClass.BALANCE_EUR-=result;
			outClass.printBalance(); // 잔고가 있을 경우 환전을 해준 후 남은 외화 잔고를 출력함.
					
		} else { 
			int errorCode = ConstValueClass.ERR_BALANCE_EUR;
			outClass.printErrorMessage(errorCode); 
		} // 잔고가 부족할 경우 부족한 외화 종류와 함께 에러메세지를 출력함.
	}

	public void changeToJPY(int inputWon) {
		double result;
		int exchgWon;
            
		result = (int)((inputWon / ConstValueClass.JPY_RATE )/10) * 1000; 

		if (result/10000<=ConstValueClass.BALANCE_JPY) { // result/10000 =>만 엔 단위
			outClass.outputResultJPY(result);

			exchgWon = (int) ((inputWon - result / 1000 * ConstValueClass.JPY_RATE * 10) / 10) * 10;
            outClass.outputResultWon(exchgWon);
            
            ConstValueClass.BALANCE_JPY-=result/10000; // result/10000 => 만 엔 단위
			outClass.printBalance(); // 잔고가 있을 경우 환전을 해준 후 남은 외화 잔고를 출력함.
		} else {
			int errorCode = ConstValueClass.ERR_BALANCE_JPY;
			outClass.printErrorMessage(errorCode);
		} // 잔고가 부족할 경우 부족한 외화 종류와 함께 에러메세지를 출력함.
	}
}
