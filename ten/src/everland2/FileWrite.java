package everland2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	private BufferedWriter bw = null;
	CustomerInfo cuc = null;

	public FileWrite() throws IOException {                  
		try {
			bw = new BufferedWriter(new FileWriter(DataClass.FILE_LOCATION, true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveTitle() throws IOException {          // 파일에 카테고리 저장           
		bw.write("날짜,권종,연령구분,수량,우대사항,가격");
		bw.newLine();
		bw.flush();
	}
	
	public void saveData() throws IOException {          // 파일에 데이터 값 저장
		for(int i = 0; i<Main.customerArr.size(); i++) {
			cuc = Main.customerArr.get(i);
			bw.write(cuc.getDate() + ",");
			bw.write(cuc.getTicketType() + ",");
			bw.write(cuc.getAgeType() + ",");
			bw.write(cuc.getTicketNum() + ",");
			bw.write(cuc.getAdvantageType() + ",");
			bw.write(String.valueOf(cuc.getMiniSum()));
			
			bw.newLine();
			bw.flush();
		}
	}
}