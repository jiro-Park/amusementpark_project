package javaEverland;

import java.util.Calendar;

public class CalculateClass {

	public int calAgeType(String residentNum) {
		Calendar cal = Calendar.getInstance();
		int ageType, bornYear;
		
		bornYear = Integer.parseInt(residentNum.substring(0, 2));
		int koreanAge = cal.YEAR - bornYear + 1;
		
		if(koreanAge<=ConstValueClass.getAGELIMIT_BABY()) {
			ageType = ConstValueClass.getAgetypeBaby();
	    } else if (koreanAge <= ConstValueClass.getAGELIMIT_CHILD()) {
	    	ageType =ConstValueClass.getAGETYPE_CHILD();
	    } else if (koreanAge <= ConstValueClass.getAGELIMIT_ADOLESCENT()) {
	    	ageType = ConstValueClass.getAGETYPE_ADOLESCENT();
	    } else if (koreanAge > ConstValueClass.getAGELIMIT_ADULT()) {
	    	ageType = ConstValueClass.getAGETYPE_ELDER();
	    } else {
	    	ageType = ConstValueClass.getAGELIMIT_ADULT();
	    }
		return ageType;
	}
}
