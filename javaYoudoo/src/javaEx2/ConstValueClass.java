package javaEx2;

public class ConstValueClass {
	public static final double USD_RATE = 1134.30;
	public static final double EUR_RATE = 1332.60;
	public static final double JPY_RATE = 1030.16; // 환율
	public static final int CHANGE_TYPE_USD = 1;
	public static final int CHANGE_TYPE_EUR = 2;
	public static final int CHANGE_TYPE_JPY = 3; // 어떤 case인지 알기 쉬움
	public static final int USD100 = 100;

	public static final int ERR_BALANCE_USD = 1;
	public static final int ERR_BALANCE_EUR = 2;
	public static final int ERR_BALANCE_JPY = 3; // 외화 부족시 에러코드

	public static double BALANCE_USD = 500;
	public static double BALANCE_EUR = 500;
	public static double BALANCE_JPY = 100; // 은행의 외화 잔고
	
	public static final double getBALANCE_USD() {
		return BALANCE_USD;
	}
	public static final void setBALANCE_USD(double bALANCE_USD) {
		BALANCE_USD = bALANCE_USD;
	}
	public static final double getBALANCE_EUR() {
		return BALANCE_EUR;
	}
	public static final void setBALANCE_EUR(double bALANCE_EUR) {
		BALANCE_EUR = bALANCE_EUR;
	}
	public static final double getBALANCE_JPY() {
		return BALANCE_JPY;
	}
	public static final void setBALANCE_JPY(double bALANCE_JPY) {
		BALANCE_JPY = bALANCE_JPY;
	}

}
