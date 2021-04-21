package everland2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	private Connection conn;
	private Statement stmt;
	
	public Database() {                                                      // 생성자
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");
			stmt = conn.createStatement();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveToDatabase(CustomerInfo cusInfo) {             // 현 주문건에서 생성된 데이터를 DB에 저장

		try {
			String str = "INSERT INTO `customerdata`(`date`,`ticketType`,`residentNum`,`ticketNum`,"
					+ "`advantageType`,`sum`,`ageType`)"
					+ "VALUES(now(),"
					+ "'"+ cusInfo.getTicketType() + "',"
					+ "'"+ cusInfo.getResidentNum() + "',"
					+ "'"+ cusInfo.getTicketNum() + "',"
					+ "'"+ cusInfo.getAdvantageType() + "',"
					+ "'"+ cusInfo.getMiniSum() + "',"
					+ "'"+ cusInfo.getAgeType("int") 
					+ "');";		
			stmt.execute(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
