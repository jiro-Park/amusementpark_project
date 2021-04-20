package everland2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomerInfo {                         // 자료구조 클래스
	CalculateClass cc = new CalculateClass();

	private String date;
	private int ticketType;
	private String residentNum;
	private int ticketNum;
	private int advantageType;
	private int miniSum;
	private int ageType;

	public CustomerInfo() {
		date = "";
		ticketType = 0;
		residentNum = "";
		ticketNum = 0;
		advantageType = 0;
		miniSum = 0;
		ageType = 0;
	}

	public CustomerInfo(String date, String ticketType_string, String ageType_string, int ticketNum,
			String advantageType_string, int miniSum) {                                     // 생성자 

		this.date = date;
		setTicketType(ticketType_string);
		setAgeType(ageType_string);
		this.ticketNum = ticketNum;
		setAdvantageType(advantageType_string);
		this.miniSum = miniSum;

	}

	public CustomerInfo(String date, int ticketType, String residentNum, int ticketNum, int advantageType, 
			int miniSum, int ageType) {                                                      // 생성자

		this.date = date;
		this.ticketType = ticketType;
		this.residentNum = residentNum;
		this.ticketNum = ticketNum;
		this.advantageType = advantageType;
		this.miniSum = miniSum;
		this.ageType = ageType;

	}

	public String getResidentNum() {
		return residentNum;
	}

	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}

	public String getTicketType() {                       // 문자열 타입으로 권종 값 받기
		String ticketType_string = "";
		if (ticketType == 1) {
			ticketType_string = "주간권";
		} else if (ticketType == 2) {
			ticketType_string = "야간권";
		}
		return ticketType_string;
	}

	public int getTicketType(String anything) {             // 정수 타입으로 권종 값 받기
		return this.ticketType;
	}

	public void setTicketType(String ticketType_string) {     // 문자열 타입으로 입력해도
		if (ticketType_string.equals("주간권")) {             // 정수 타입으로 권종 값 저장
			ticketType = 1;
			this.ticketType = ticketType;
		} else if (ticketType_string.equals("야간권")) {
			ticketType = 2;
			this.ticketType = ticketType;
		}
	}

	public void setTicketType(int ticketType) {           
		this.ticketType = ticketType;
	}

	public String getAgeType() {                           // 문자열 타입으로 연령 값 받기
		String ageType_string = "";
		if (ageType == 0) {
			ageType_string = "대인";
		} else if (ageType == 1) {
			ageType_string = "청소년";
		} else if (ageType == 2) {
			ageType_string = "소아";
		} else if (ageType == 3) {
			ageType_string = "경로";
		} else if (ageType == 4) {
			ageType_string = "유아";
		}
		return ageType_string;
	}

	public int getAgeType(String anythine) {                // 정수 타입으로 연령 값 받기
		return this.ageType;
	}

	public void setAgeType(int ageType) {
		this.ageType = ageType;
	}

	public void setAgeType(String ageType_string) {           // 문자열 타입으로 입력해도
                                                            // 정수 타입으로 연령 값 저장
		if (ageType_string.equals("대인")) {
			this.ageType = 0;
		} else if (ageType_string.equals("청소년")) {
			this.ageType = 1;
		} else if (ageType_string.equals("소인")) {
			this.ageType = 2;
		} else if (ageType_string.equals("경로")) {
			this.ageType = 3;
		} else if (ageType_string.equals("유아")) {
			this.ageType = 4;
		}
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getAdvantageType() {                     // 문자열 타입으로 우대 값 받기
		String advantageType_string = "";
		if (advantageType == 1) {
			advantageType_string = "없음";
		} else if (advantageType == 2) {
			advantageType_string = "장애인";
		} else if (advantageType == 3) {
			advantageType_string = "국가유공자";
		} else if (advantageType == 4) {
			advantageType_string = "다자녀";
		} else if (advantageType == 5) {
			advantageType_string = "임산부";
		}
		return advantageType_string;
	}

	public int getAdvantageType(String anything) {          // 정수 타입으로 우대 값 받기
		return this.advantageType;
	}

	public void setAdvantageType(int advantageType) {
		this.advantageType = advantageType;
	}

	public void setAdvantageType(String advantageType_string) {        // 문자열 타입으로 입력해도
		if (advantageType_string.equals("없음")) {                    // 정수 타입으로 우대 값 저장    
			this.advantageType = 1;
		} else if (advantageType_string.equals("장애인")) {
			this.advantageType = 2;
		} else if (advantageType_string.equals("국가유공자")) {
			this.advantageType = 3;
		} else if (advantageType_string.equals("다자녀")) {
			this.advantageType = 4;
		} else if (advantageType_string.equals("임산부")) {
			this.advantageType = 5;
		}
	}

	public int getMiniSum() {
		return miniSum;
	}

	public void setMiniSum(int miniSum) {
		this.miniSum = miniSum;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		SimpleDateFormat ymd = new SimpleDateFormat("YYYY/MM/dd");
		Calendar cal = Calendar.getInstance();
		this.date = ymd.format(cal.getTime());
	}

}
