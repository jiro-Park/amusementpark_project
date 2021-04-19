package everland2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomerInfo {
	CalculateClass cc = new CalculateClass();

	// 날짜 넣기
	private String date = "";
	
	private int ticketType=0;
	private String residentNum="";
	private int ticketNum=0;
	private int advantageType=0;
	private int miniSum=0;
	private int ageType =0;
	
	private String ticketType_string;
	private String ageType_string;
	private String advantageType_string;
	
	
	public final String getResidentNum() {
		return residentNum;
	}
	public final void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}
	public final String getTicketType_string() {
		return ticketType_string;
	}
	public final void setTicketType_string() {
		ticketType_string="";
		switch (ticketType) {
		case 1 :
			ticketType_string = "주간권";
			break;
		case 2 :
			ticketType_string = "야간권";
			break;
		}
		
		this.ticketType_string = ticketType_string;
	}
	public final String getAgeType_string() {
		return ageType_string;
	}
	public final void setAgeType_string() {
		ageType_string = "";
		switch (ageType) {
		case 0:
			ageType_string = "대인";
			break;
		case 1:
			ageType_string = "청소년";
			break;
		case 2:
			ageType_string = "소인";
			break;
		case 3:
			ageType_string = "경로";
			break;
		case 4:
			ageType_string = "유아";
			break;

		}
		
		this.ageType_string = ageType_string;
	}
	public final String getAdvantegeType_string() {
		return advantageType_string;
	}
	public final void setAdvantageType_string() {
		String advantageType_string = ""; 
		switch(advantageType) {
		case 1:
			advantageType_string = "없음";
			break;
		case 2:
			advantageType_string = "장애인";
			break;
		case 3:
			advantageType_string = "국가유공자";
			break;
		case 4:
			advantageType_string = "다자녀";
			break;
		case 5:
			advantageType_string = "임산부";
			break;
		}
		this.advantageType_string = advantageType_string;
	}

	public final int getTicketType() {
		return ticketType;
	}
	public final void setTicketType(int ticketType) {
		this.ticketType = ticketType;
		setTicketType_string();
	}
	public final String getAgeType() {
		return residentNum;
	}
	public final void setAgeType(String residentNum) {
		int ageType = cc.calAgeType(residentNum);
		this.ageType = ageType;
		setAgeType_string();
	}
	public final int getTicketNum() {
		return ticketNum;
	}
	public final void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	public final int getAdvantageType() {
		return advantageType;
	}
	public final void setAdvantageType(int advantageType) {
		this.advantageType = advantageType;
		setAdvantageType_string();
	}
	public final int getMiniSum() {
		return miniSum;
	}
	public final void setMiniSum(int miniSum) {
		this.miniSum = miniSum;
	}
	
	public final String getDate() {
		return date;
	}

	public final void setDate() {

		SimpleDateFormat ymd = new SimpleDateFormat("YYYY/MM/dd");
		Calendar cal = Calendar.getInstance();
		this.date = ymd.format(cal.getTime());
	}

}
