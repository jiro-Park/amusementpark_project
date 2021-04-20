package statistics;

import java.io.IOException;

public class Main_st {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CalculateClass_st cac = new CalculateClass_st();
		
		cac.saveData();       // 파일을 읽어와서 매출 분석에 필요한 데이터를 저장
		cac.saveStatistics();                           // 매출을 분석
		cac.printStatistics();                        // 매출 분석 출력
        cac.saveToFile();                // 새로운 파일에 매출 분석하여 저장
	}
}
