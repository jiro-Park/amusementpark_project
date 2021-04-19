package javaEx2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWriteClass {

	private BufferedWriter bw = null;

	public FileWriteClass() throws IOException {                  // 생성자 호출시 파일 기록관련 객체 생성
		try {
			bw = new BufferedWriter(new FileWriter("C:\\Users\\p\\Desktop\\out.txt", true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveToFileTitle() throws IOException {                     // 파일의 첫줄 카테고리 기록
		bw.write("날짜,시간,환전요청금액,외화타입,환전한 외화,원화거스름돈,외화잔고");
	}

	public void saveToFileDate() throws IOException {                       // 파일에 현재 날짜를 기록    
		SimpleDateFormat ymd = new SimpleDateFormat("YYYY/MM/dd");
		Calendar cal = Calendar.getInstance();
		bw.newLine();
		bw.write(ymd.format(cal.getTime()) + ",");
		bw.flush();
	}

	public void saveToFileTime() throws IOException {                       // 파일에 현재 시간을 기록
		SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		bw.write(hms.format(cal.getTime()) + ",");
		bw.flush();
	}

	public void saveToFileWon(int inputWon) throws IOException {          // 파일에 환전요청금액을 기록
		bw.write(String.valueOf(inputWon) + ",");
		bw.flush();
	}

	public void saveToFileType(int inputChangeType) throws IOException {     // 파일에 외화타입을 기록
		switch (inputChangeType) {
		case 1:
			bw.write("USD,");
			break;
		case 2:
			bw.write("EUR,");
			break;
		case 3:
			bw.write("JPY,");
			break;
		}
		bw.flush();
	}

	public void saveToFileResult(int result) throws IOException {         // 파일에 환전한 금액을 기록
		bw.write(String.valueOf(result) + ",");
		bw.flush();
	}

	public void saveToFileExchgWon(int exchgWon) throws IOException {    // 파일에 원화 거스름돈을 기록
		bw.write(String.valueOf(exchgWon) + ",");
		bw.flush();
	}

	public void saveToFileBalance(double Balance) throws IOException {   // 파일에 은행 외화잔고를 기록
		bw.write(String.valueOf(Balance));
		bw.flush();
	}

	public void saveToFileError() throws IOException {                // 파일에 환전거절시 메시지를 기록
		bw.write("은행 외화잔고 부족으로 인한 환전거절");
		bw.flush();
	}
	public void saveToFileDefault() throws IOException{               // 파일에 환전취소시 메시지를 기록
		bw.write("환전취소");
		bw.close();
	}
}
