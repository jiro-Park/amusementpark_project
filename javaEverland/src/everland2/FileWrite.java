package everland2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	private BufferedWriter bw = null;
	CustomerInfo cuc = null;

	public FileWrite() throws IOException {                  // 생성자 호출시 파일 기록관련 객체 생성
		try {
			bw = new BufferedWriter(new FileWriter("C:\\Users\\p\\Desktop\\out.txt", true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveTitle() throws IOException {                     // 파일의 첫줄 카테고리 기록
		bw.write("날짜,권종,연령구분,수량,가격,우대사항");
		bw.newLine();
		bw.flush();
	}
	
	public void saveData() throws IOException {
		for(int i = 0; i<Main.customerArr.size(); i++) {
			cuc = Main.customerArr.get(i);
			bw.write(cuc.getDate() + ",");
			bw.write(cuc.getTicketType_string() + ",");
			bw.write(cuc.getAgeType_string() + ",");
			bw.write(cuc.getTicketNum() + ",");
			bw.write(cuc.getAdvantegeType_string() + ",");
			bw.write(String.valueOf(cuc.getMiniSum()));
			
			bw.newLine();
			bw.flush();

		}
	}
}