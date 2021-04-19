package javaEx;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileW {
	
	
	public void filewrite() throws IOException {
		File f = new File("C:\\Users\\p\\Desktop\\out.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		
	int inputWon =0;
	int inputChangeType =0;
	InputClass inputClass = new InputClass();
	Calendar cal = Calendar.getInstance();
	
	do {
		inputWon = inputClass.inputFromConsoleWon();
		inputChangeType = inputClass.inputFromConsoleType();
		bw.write(sdf.format(cal.getTime()));
		bw.write(String.valueOf(inputWon));
				
		RunExchangeClass runClass = new RunExchangeClass();
		switch (inputChangeType) {
		case ConstValueClass.CHANGE_TYPE_USD:
			runClass.changeToUSD(inputWon);
			break;
			
		case ConstValueClass.CHANGE_TYPE_EUR:
			runClass.changeToEUR(inputWon);
			break;
			
		case ConstValueClass.CHANGE_TYPE_JPY:
			runClass.changeToJPY(inputWon);
			break;
			
			
		}
		bw.flush();
	} while (inputChangeType != 0);
}
}
