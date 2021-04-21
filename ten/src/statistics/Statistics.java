package statistics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import everland2.CustomerInfo;
import everland2.DataClass;
import everland2.Main;

public class Statistics {
	
	private Connection conn;
	private Statement stmt;
	private ValueClass_st vc;
	
	public Statistics() {                                                      // 생성자
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");
			stmt = conn.createStatement();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printStatistics() {              // 데이터베이스에 저장된 값을 이용한 매출분석 출력
		vc = new ValueClass_st();
		try {
			ResultSet rset = stmt.executeQuery("SELECT * FROM `customerdata`");
			System.out.println("===========================권종 별 판매현황=========================\n");
			System.out.printf("%11s %13s %6s %3s %9s %9s \n", DataClass.DATE, DataClass.TICKET_TYPE, 
					DataClass.AGE_TYPE, DataClass.TICKET_NUM, DataClass.ADVANTAGE, DataClass.PRICE);
			while (rset.next()) {
				System.out.printf("%s %6s %5s %5d %10s %11d\n",rset.getString("date"), rset.getString("ticketType"),
						rset.getString("ageType"), rset.getInt("ticketNum"), rset.getString("advantageType"), 
						rset.getInt("sum"));
		
				if (rset.getString("ticketType").equals("주간권")) {
					vc.day_ticketSum += rset.getInt("ticketNum");
					vc.day_revenue += rset.getInt("sum");

					if (rset.getInt("ageType") == 0) {
						vc.day_adultSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 1) {
						vc.day_adolescentSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 2) {
						vc.day_childSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 3) {
						vc.day_elderSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 4) {
						vc.day_babySum += rset.getInt("ticketNum");
					}
				} else if (rset.getString("ticketType").equals("야간권")) {
					vc.night_ticketSum += rset.getInt("ticketNum");
					vc.night_revenue += rset.getInt("sum");

					if (rset.getInt("ageType") == 0) {
						vc.night_adultSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 1) {
						vc.night_adolescentSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 2) {
						vc.night_childSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 3) {
						vc.night_elderSum += rset.getInt("ticketNum");
					} else if (rset.getInt("ageType") == 4) {
						vc.night_babySum += rset.getInt("ticketNum");
					}
				}
			}
			System.out.println("-----------------------------------------------------------------\n");
			System.out.println("============================권종 별 판매현황=========================\n");
			System.out.printf("주간권 총 %d 매\n", vc.day_ticketSum);
			System.out.printf("유아 %d 매, 소인 %d 매, 청소년 %d 매, 대인 %d 매, 노인 %d매\n", vc.day_babySum, vc.day_childSum,
					vc.day_adolescentSum, vc.day_adultSum, vc.day_elderSum);
			System.out.printf("주간권 매출 : %d 원\n\n", vc.day_revenue);
			System.out.printf("야간권 총 %d 매\n", vc.night_ticketSum);
			System.out.printf("유아 %d 매, 소인 %d 매, 청소년 %d 매, 대인 %d 매, 노인 %d매\n", vc.night_babySum, vc.night_childSum,
					vc.night_adolescentSum, vc.night_adultSum, vc.night_elderSum);
			System.out.printf("야간권 매출 : %d 원\n", vc.night_revenue);
			System.out.println("-----------------------------------------------------------------\n");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.printf("==================================================================\n");
	}

}
