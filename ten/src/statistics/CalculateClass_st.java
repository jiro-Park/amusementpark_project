package statistics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import everland2.CustomerInfo;
import everland2.DataClass;

public class CalculateClass_st {
	static ArrayList<CustomerInfo> arr = new ArrayList<CustomerInfo>();
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private ValueClass_st vc = null;
	int cnt = 0;

	public CalculateClass_st() throws IOException {                                            // 생성자

		try {
			br = new BufferedReader(new FileReader(DataClass.FILE_LOCATION));
			bw = new BufferedWriter(new FileWriter(DataClass.FILE_LOCATION_STATISTICS));
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveData() throws IOException {         // 파일로부터 읽어온 값을 자료구조에 넣고 arraylist에 추가  
		String line;
		String[] temp = new String[6];

		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			if (cnt != 0) {
				temp = line.split(",");
				CustomerInfo cui = new CustomerInfo(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), 
						temp[4], Integer.parseInt(temp[5]));
				arr.add(cui);
			}
			cnt++;
		}
	}

	public void saveStatistics() {                               // 매출분석에 필요한 변수들의 값 산출하여 저장
		vc = new ValueClass_st();

		for (int i = 0; i < cnt - 1; i++) {
			if (arr.get(i).getTicketType("int") == 1) {
				vc.day_ticketSum += arr.get(i).getTicketNum();
				vc.day_revenue += arr.get(i).getMiniSum();

				if (arr.get(i).getAgeType().equals(DataClass.BABY)) {
					vc.day_babySum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.CHILD)) {
					vc.day_childSum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.ADOLESCENT)) {
					vc.day_adolescentSum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.ADULT)) {
					vc.day_adultSum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.ELDER)) {
					vc.day_elderSum += arr.get(i).getTicketNum();
				}
			} else if (arr.get(i).getTicketType("int") == 2) {
				vc.night_ticketSum += arr.get(i).getTicketNum();
				vc.night_revenue += arr.get(i).getMiniSum();

				if (arr.get(i).getAgeType().equals(DataClass.BABY)) {
					vc.night_babySum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.CHILD)) {
					vc.night_childSum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.ADOLESCENT)) {
					vc.night_adolescentSum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.ADULT)) {
					vc.night_adultSum += arr.get(i).getTicketNum();
				} else if (arr.get(i).getAgeType().equals(DataClass.ELDER)) {
					vc.night_elderSum += arr.get(i).getTicketNum();
				}
			}
		}
	}

	public void printStatistics() {                                                 // 매출 분석 통계 출력
		System.out.printf("%6s %13s %10s %9s %9s %10s \n", DataClass.DATE, DataClass.TICKET_TYPE, DataClass.AGE_TYPE,
				DataClass.TICKET_NUM, DataClass.ADVANTAGE, DataClass.PRICE);
		for (int i = 0; i < cnt-1; i++) {
			System.out.printf("%10s %10s %10s %10s %10s %12s \n", arr.get(i).getDate(), arr.get(i).getTicketType("int"),
					arr.get(i).getAgeType("int"), arr.get(i).getTicketNum(), arr.get(i).getAdvantageType("int"),
					arr.get(i).getMiniSum());
		}
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("=============================권종 별 판매현황===========================\n");
		System.out.printf("주간권 총 %d 매\n", vc.day_ticketSum);
		System.out.printf("유아 %d 매, 소인 %d 매, 청소년 %d 매, 대인 %d 매, 노인 %d매\n", vc.day_babySum, vc.day_childSum,
				vc.day_adolescentSum, vc.day_adultSum, vc.day_elderSum);
		System.out.printf("주간권 매출 : %d 원\n\n", vc.day_revenue);
		System.out.printf("야간권 총 %d 매\n", vc.night_ticketSum);
		System.out.printf("유아 %d 매, 소인 %d 매, 청소년 %d 매, 대인 %d 매, 노인 %d매\n", vc.night_babySum, vc.night_childSum,
				vc.night_adolescentSum, vc.night_adultSum, vc.night_elderSum);
		System.out.printf("야간권 매출 : %d 원\n", vc.night_revenue);
		System.out.println("--------------------------------------------------------------------\n");
	}


	public void saveToFile() throws IOException {                       // 새로운 포맷의 매출 데이터를 파일에 저장  
		
		bw.write("구분,주간권,야간권");
		bw.newLine();
		bw.write("유아," + vc.day_babySum + "," + vc.night_babySum);
		bw.newLine();
		bw.write("어린이," + vc.day_childSum + "," + vc.night_childSum);
		bw.newLine();
		bw.write("청소년," + vc.day_adolescentSum + "," + vc.night_adolescentSum);
		bw.newLine();
		bw.write("대인," + vc.day_adultSum + "," + vc.night_adultSum);
		bw.newLine();
		bw.write("경로," + vc.day_elderSum + "," + vc.night_elderSum);
		bw.newLine();
		bw.write("합계," + vc.day_babySum + vc.day_childSum + vc.day_adolescentSum
				+ vc.day_adultSum + vc.day_elderSum + "," + vc.night_babySum
				+ vc.night_childSum + vc.night_adolescentSum + vc.night_adultSum
				+ vc.night_elderSum);
		bw.newLine();
		bw.write("매출," + vc.day_revenue + "," + vc.night_revenue);
		bw.newLine();
		bw.close();
	}

}

