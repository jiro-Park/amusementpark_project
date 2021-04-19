package everland2;

import java.util.Calendar;

public class CalculateClass {

	public int calAgeType(String residentNum) {
		Calendar cal = Calendar.getInstance();
		int ageType;
		int bornYear = 0;

		if (residentNum.charAt(6) == '1' || residentNum.charAt(6) == '2') {
			bornYear = 1900 + Integer.parseInt(residentNum.substring(0, 2));
		} else if (residentNum.charAt(6) == '3' || residentNum.charAt(6) == '4') {
			bornYear = 2000 + Integer.parseInt(residentNum.substring(0, 2));

		}
		int koreanAge = cal.get(cal.YEAR) - bornYear + 1;

		if (koreanAge <= DataClass.getAGELIMIT_BABY()) {
			ageType = DataClass.getAGETYPE_BABY();
		} else if (koreanAge <= DataClass.getAGELIMIT_CHILD()) {
			ageType = DataClass.getAGETYPE_CHILD();
		} else if (koreanAge <= DataClass.getAGELIMIT_ADOLESCENT()) {
			ageType = DataClass.getAGETYPE_ADOLESCENT();
		} else if (koreanAge > DataClass.getAGELIMIT_ADULT()) {
			ageType = DataClass.getAGETYPE_ELDER();
		} else {
			ageType = DataClass.getAGETYPE_ADULT();
		}
		return ageType;
	}

	public int calMiniSum(int ticketType, String residentNum, int ticketNum, int advantageType) {
		double miniSum = 0;
		int ageType = calAgeType(residentNum);
		double discountRate = calDiscountRate(advantageType);

		if (ticketType == 1) {
			miniSum = DataClass.getDAY_TICKET_PRICE()[ageType] * ticketNum * discountRate;

		} else if (ticketType == 2) {
			miniSum = DataClass.getNIGHT_TICKET_PRICE()[ageType] * ticketNum * discountRate;
		} else {
		}

		return (int)miniSum;

	}
	public double calDiscountRate(int advantageType) {
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
}
