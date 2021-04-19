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
		
		// ��ȭ �ܰ� ��Ȳ�� ���� �ٸ��� �����Ѵ�.
		if (result <= ConstValueClass.BALANCE_USD) {
			bw.write(String.valueOf("ȯ���ݾ� : "+result+"�޷�/"));
			outClass.outputResultUSD(result);

			exchgWon = (int) ((inputWon - result * ConstValueClass.USD_RATE) / 10) * 10;
			outClass.outputResultWon(exchgWon);
			bw.write(String.valueOf("�Ž����� : "+exchgWon+"��/"));
			bw.flush();

			ConstValueClass.BALANCE_USD-=result;
			outClass.printBalance(); // �ܰ� ���� ��� ȯ���� ���� �� ���� ��ȭ �ܰ� �����.
			
		} else { 
			int errorCode = ConstValueClass.ERR_BALANCE_USD;
			outClass.printErrorMessage(errorCode); 
		} // �ܰ� ������ ��� ������ ��ȭ ������ �Բ� �����޼����� �����.

	}

	public void changeToEUR(int inputWon) {
		int result;
		int exchgWon;
        
		result = (int) (inputWon / (ConstValueClass.EUR_RATE * 5)) * 5;
		// ������ ȯ���ҿ� 1,2���ΰ� ���뼭 5���� �������� �����غ��Ҵ�. 

		// ��ȭ �ܰ� ��Ȳ�� ���� �ٸ��� �����Ѵ�.
		if (result<=ConstValueClass.BALANCE_EUR) {
			outClass.outputResultEUR(result);

			exchgWon = (int) ((inputWon - result * ConstValueClass.EUR_RATE) / 10) * 10;
			outClass.outputResultWon(exchgWon);

			ConstValueClass.BALANCE_EUR-=result;
			outClass.printBalance(); // �ܰ� ���� ��� ȯ���� ���� �� ���� ��ȭ �ܰ� �����.
					
		} else { 
			int errorCode = ConstValueClass.ERR_BALANCE_EUR;
			outClass.printErrorMessage(errorCode); 
		} // �ܰ� ������ ��� ������ ��ȭ ������ �Բ� �����޼����� �����.
	}

	public void changeToJPY(int inputWon) {
		double result;
		int exchgWon;
            
		result = (int)((inputWon / ConstValueClass.JPY_RATE )/10) * 1000; 

		if (result/10000<=ConstValueClass.BALANCE_JPY) { // result/10000 =>�� �� ����
			outClass.outputResultJPY(result);

			exchgWon = (int) ((inputWon - result / 1000 * ConstValueClass.JPY_RATE * 10) / 10) * 10;
            outClass.outputResultWon(exchgWon);
            
            ConstValueClass.BALANCE_JPY-=result/10000; // result/10000 => �� �� ����
			outClass.printBalance(); // �ܰ� ���� ��� ȯ���� ���� �� ���� ��ȭ �ܰ� �����.
		} else {
			int errorCode = ConstValueClass.ERR_BALANCE_JPY;
			outClass.printErrorMessage(errorCode);
		} // �ܰ� ������ ��� ������ ��ȭ ������ �Բ� �����޼����� �����.
	}
}
