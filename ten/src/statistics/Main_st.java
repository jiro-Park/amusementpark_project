package statistics;

import java.io.IOException;

public class Main_st {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CalculateClass_st cac = new CalculateClass_st();
		Statistics st = new Statistics();
		
	//	cac.saveData();         // 파일을 읽어와서 매출 분석에 필요한 데이터를 저장
	//	cac.saveStatistics();                // 자료구조를 이요하여 매출을 분석
		//cac.printStatistics();                           // 매출 분석 출력
        //cac.saveToFile();                   // 새로운 파일에 매출 분석하여 저장
        
       st.printStatistics();     // 데이터베이스에 저장된 값을 이용한 매출 분석 
	}
}
