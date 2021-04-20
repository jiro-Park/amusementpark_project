package everland2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculateClass {

	public int calAgeType(String residentNum) {               // 주민번호 입력받아 연령 타입 산출
		Calendar cal = Calendar.getInstance();
		int ageType;
		int bornYear = 0;
		
		if (residentNum.charAt(6) == '1' || residentNum.charAt(6) == '2') {
			bornYear = 1900 + Integer.parseInt(residentNum.substring(0, 2));
		} else if (residentNum.charAt(6) == '3' || residentNum.charAt(6) == '4') {
			bornYear = 2000 + Integer.parseInt(residentNum.substring(0, 2));
		}
		int koreanAge = cal.get(cal.YEAR) - bornYear + 1;

		if (koreanAge <= DataClass.AGELIMIT_BABY) {
			ageType = DataClass.AGETYPE_BABY;
		} else if (koreanAge <= DataClass.AGELIMIT_CHILD) {
			ageType = DataClass.AGETYPE_CHILD;
		} else if (koreanAge <= DataClass.AGELIMIT_ADOLESCENT) {
			ageType = DataClass.AGETYPE_ADOLESCENT;
		} else if (koreanAge > DataClass.AGELIMIT_ADULT) {
			ageType = DataClass.AGETYPE_ELDER;
		} else {
			ageType = DataClass.AGETYPE_ADULT;
		}
		return ageType;
	}
                                                                // 해당 주문건에 대한 합계액 산출
	public int calMiniSum(int ticketType, String residentNum, int ticketNum, int advantageType) {
		double miniSum = 0;
		int ageType = calAgeType(residentNum);
		double discountRate = calDiscountRate(advantageType);

		if (ticketType == 1) {
			miniSum = DataClass.DAY_TICKET_PRICE[ageType] * ticketNum * discountRate;
		} else if (ticketType == 2) {
			miniSum = DataClass.NIGHT_TICKET_PRICE[ageType] * ticketNum * discountRate;
		} 
		return (int)miniSum;
	}
	
	public double calDiscountRate(int advantageType) {            // 우대 타입에 따른 할인율 리턴
		double discountRate = 1;
		switch(advantageType) {
		case 1:
			discountRate = 1;
			break;
		case 2:
			discountRate = 0.6;
			break;
		case 3:
			discountRate = 0.5;
			break;
		case 4:
			discountRate = 0.8;
			break;
		case 5:
			discountRate = 0.85;
			break;
		}
		return discountRate;
	}
	
	public String setDate() {                                               // 현재 날짜를 리턴
		SimpleDateFormat ymd = new SimpleDateFormat("YYYY/MM/dd");
		Calendar cal = Calendar.getInstance();
		return ymd.format(cal.getTime());
	}
	
}
