package javaEx2;

public class OutputClass {

	public void printResultUSD(int result, int USD100, int USD50, int USD20, int USD10, 
			int USD5, int USD2, int USD1) {

		System.out.println("환전 결과 : " 
		                    + result + "달러");
		System.out.println("100달러 "          // 변수가 눈에 잘 들어오게끔 줄 바꿈
				            + USD100 + "개");
		System.out.println("50달러 " 
				            + USD50 + "개");
		System.out.println("20달러 " 
				            + USD20 + "개");
		System.out.println("10달러 " 
				            + USD10 + "개");
		System.out.println("5달러 " 
				            + USD5 + "개");
		System.out.println("2달러 " 
				            + USD2 + "개");
		System.out.println("1달러 " 
				            + USD1 + "개"); //          받을 달러 화폐 수량 출력
	}

	public void printResultEUR(int result, int EUR500, int EUR200, int EUR100, int EUR50, int EUR20, 
			int EUR10, int EUR5) {

		System.out.println("환전 결과 : " 
		                    + result + "유로");
		System.out.println("500유로 " 
		                    + EUR500 + "개");
		System.out.println("200유로 " 
		                    + EUR200 + "개");
		System.out.println("100유로 " 
		                    + EUR100 + "개");
		System.out.println("50유로 " 
		                    + EUR50 + "개");
		System.out.println("20유로 " 
		                    + EUR20 + "개");
		System.out.println("10유로 " 
		                    + EUR10 + "개");
		System.out.println("5유로 " 
		                    + EUR5 + "개");  //         받을 유로 화폐 수량 출력
	}

	public void printResultJPY(double result, int JPY10000, int JPY5000, int JPY2000, int JPY1000) {
        int intResult = (int)result;
		System.out.println("환전 결과 : " 
		                    + intResult + "엔");
		System.out.println("1만엔 " 
		                    + JPY10000 + "개");
		System.out.println("5천엔 " 
		                    + JPY5000 + "개");
		System.out.println("2천엔 " 
		                    + JPY2000 + "개");
		System.out.println("천엔 " 
		                    + JPY1000 + "개");        // 받을 엔화 화폐 수량 출력
	}

	public void printResultWon(int exchgWon, int exchgWon10000, int exchgWon5000, int exchgWon1000, 
			int exchgWon500, int exchgWon100, int exchgWon50, int exchgWon10) {

		System.out.println("\n거스름돈 : " 
		                    + exchgWon + "원");
		System.out.println("10000원 " 
		                    + exchgWon10000 + "개");
		System.out.println("5000원 " 
		                    + exchgWon5000 + "개");
		System.out.println("1000원 " 
		                    + exchgWon1000 + "개");
		System.out.println("500원 " 
		                    + exchgWon500 + "개");
		System.out.println("100원 " 
		                    + exchgWon100 + "개");
		System.out.println("50원 " 
		                    + exchgWon50 + "개");
		System.out.println("10원 " 
		                    + exchgWon10 + "개\n");       // 원화 거스름돈 화폐 수량 출력
	}

	public void printErrorMessage(int errorCode) { // 은행 외화잔고 부족시 에러 메시지 출력
		switch(errorCode) {
		case ConstValueClass.ERR_BALANCE_USD:
			System.out.println("달러");
			break;
		case ConstValueClass.ERR_BALANCE_EUR:
			System.out.println("유로");
			break;
		case ConstValueClass.ERR_BALANCE_JPY:
			System.out.println("엔화");
			break;
		}
		
		System.out.println("외화 보유 잔고가 부족합니다.\n");
	}
	public void printBalance() {  //                             은행 외화 잔고 출력
		System.out.println( "은행 외화 잔고 : \n"
				          + "USD : " + (int)ConstValueClass.BALANCE_USD + " 달러\n"
				          + "EUR : " + (int)ConstValueClass.BALANCE_EUR + " 유로\n"
				          + "JPY : " + ConstValueClass.BALANCE_JPY + "만 엔\n");
	}
	
	public void outputResultUSD(int result) {          // 환전받을 달러 수량 계산 

		int USD100, USD50, USD20, USD10;
		int USD5, USD2, USD1;

		USD100 = (int) (result / ConstValueClass.USD100);
		USD50 = (int) (result % ConstValueClass.USD100 / 50);
		USD20 = (int) (result % ConstValueClass.USD100 % 50 / 20);
		USD10 = (int) (result % ConstValueClass.USD100 % 50 % 20 / 10);
		USD5 = (int) (result % ConstValueClass.USD100 % 50 % 20 % 10 / 5);
		USD2 = (int) (result % ConstValueClass.USD100 % 50 % 20 % 10 % 5 / 2);
		USD1 = (int) (result % ConstValueClass.USD100 % 50 % 20 % 10 % 5 % 2);

		printResultUSD(result, USD100, USD50, USD20, USD10, USD5, USD2, USD1);

	}

	public void outputResultEUR(int result) {         // 환전받을 유로 수량 계산
		int EUR500, EUR200, EUR100, EUR50;
		int EUR20, EUR10, EUR5;

		EUR500 = (int) (result / 500);
		EUR200 = (int) (result % 500 / 200);
		EUR100 = (int) (result % 500 % 200 / 100);
		EUR50 = (int) (result % 500 % 200 % 100 / 50);
		EUR20 = (int) (result % 500 % 200 % 100 % 50 / 20);
		EUR10 = (int) (result % 500 % 200 % 100 % 50 % 20 / 10);
		EUR5 = (int) (result % 500 % 200 % 100 % 50 % 20 % 10 / 5);

		printResultEUR(result, EUR500, EUR200, EUR100, EUR50, EUR20, EUR10, EUR5);

	}

	public void outputResultJPY(double result) {       // 환전받을 엔화 수량 계산
		int JPY10000, JPY5000, JPY2000, JPY1000;
		JPY10000 = (int) (result / 10000);
		JPY5000 = (int) (result % 10000 / 5000);
		JPY2000 = (int) (result % 10000 % 5000 / 2000);
		JPY1000 = (int) (result % 10000 % 5000 % 2000 / 1000);

		printResultJPY(result, JPY10000, JPY5000, JPY2000, JPY1000);

	}

	public void outputResultWon(int exchgWon) {         // 원화 거스름돈 수량 계산  
		int exchgWon10000, exchgWon5000, exchgWon1000, exchgWon500; 
		int exchgWon100, exchgWon50, exchgWon10;

		exchgWon10000 = (int) (exchgWon / 10000);
		exchgWon5000 = (int) (exchgWon % 10000 / 5000);
		exchgWon1000 = (int) (exchgWon % 10000 % 5000 / 1000);
		exchgWon500 = (int) (exchgWon % 10000 % 5000 % 1000 / 500);
		exchgWon100 = (int) (exchgWon % 10000 % 5000 % 1000 % 500 / 100);
		exchgWon50 = (int) (exchgWon % 10000 % 5000 % 1000 % 500 % 100 / 50);
		exchgWon10 = (int) (exchgWon % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10);

		printResultWon(exchgWon, exchgWon10000, exchgWon5000, exchgWon1000, exchgWon500, 
				exchgWon100, exchgWon50, exchgWon10);

	}
}

