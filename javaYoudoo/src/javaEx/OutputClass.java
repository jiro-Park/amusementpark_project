package javaEx;

public class OutputClass {

	public void printResultUSD(double result, int USD100, int USD50, int USD20, int USD10, 
			int USD5, int USD2, int USD1) {

		System.out.println("ȯ�� ��� : " 
		                    + result + "�޷�");
		System.out.println("100�޷� "          // ������ ���� �� �����Բ� �� �ٲ�
				            + USD100 + "��");
		System.out.println("50�޷� " 
				            + USD50 + "��");
		System.out.println("20�޷� " 
				            + USD20 + "��");
		System.out.println("10�޷� " 
				            + USD10 + "��");
		System.out.println("5�޷� " 
				            + USD5 + "��");
		System.out.println("2�޷� " 
				            + USD2 + "��");
		System.out.println("1�޷� " 
				            + USD1 + "��"); // �޷� ���� ��� ��
	}

	public void printResultEUR(int result, int EUR500, int EUR200, int EUR100, int EUR50, int EUR20, 
			int EUR10, int EUR5) {

		System.out.println("ȯ�� ��� : " 
		                    + result + "����");
		System.out.println("500���� " 
		                    + EUR500 + "��");
		System.out.println("200���� " 
		                    + EUR200 + "��");
		System.out.println("100���� " 
		                    + EUR100 + "��");
		System.out.println("50���� " 
		                    + EUR50 + "��");
		System.out.println("20���� " 
		                    + EUR20 + "��");
		System.out.println("10���� " 
		                    + EUR10 + "��");
		System.out.println("5���� " 
		                    + EUR5 + "��");
	}

	public void printResultJPY(double result, int JPY10000, int JPY5000, int JPY2000, int JPY1000) {
        int intResult = (int)result;
		System.out.println("ȯ�� ��� : " 
		                    + intResult + "��");
		System.out.println("1���� " 
		                    + JPY10000 + "��");
		System.out.println("5õ�� " 
		                    + JPY5000 + "��");
		System.out.println("2õ�� " 
		                    + JPY2000 + "��");
		System.out.println("õ�� " 
		                    + JPY1000 + "��");
	}

	public void printResultWon(int exchgWon, int exchgWon10000, int exchgWon5000, int exchgWon1000, 
			int exchgWon500, int exchgWon100, int exchgWon50, int exchgWon10) {

		System.out.println("\n�Ž����� : " 
		                    + exchgWon + "��");
		System.out.println("10000�� " 
		                    + exchgWon10000 + "��");
		System.out.println("5000�� " 
		                    + exchgWon5000 + "��");
		System.out.println("1000�� " 
		                    + exchgWon1000 + "��");
		System.out.println("500�� " 
		                    + exchgWon500 + "��");
		System.out.println("100�� " 
		                    + exchgWon100 + "��");
		System.out.println("50�� " 
		                    + exchgWon50 + "��");
		System.out.println("10�� " 
		                    + exchgWon10 + "��\n");
	}

	public void printErrorMessage(int errorCode) {
		switch(errorCode) {
		case ConstValueClass.ERR_BALANCE_USD:
			System.out.println("�޷�");
			break;
		case ConstValueClass.ERR_BALANCE_EUR:
			System.out.println("����");
			break;
		case ConstValueClass.ERR_BALANCE_JPY:
			System.out.println("��ȭ");
			break;
		}
		
		System.out.println("��ȭ ���� �ܰ� �����մϴ�.\n");
	}
	public void printBalance() {
		System.out.println( "USD : " + ConstValueClass.BALANCE_USD + " �޷�\n"
				          + "EUR : " + ConstValueClass.BALANCE_EUR + " ����\n"
				          + "JPY : " + ConstValueClass.BALANCE_JPY + "�� ��\n");
	}
	
	public void outputResultUSD(int result) {

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

	public void outputResultEUR(int result) {
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

	public void outputResultJPY(double result) {
		int JPY10000, JPY5000, JPY2000, JPY1000;
		JPY10000 = (int) (result / 10000);
		JPY5000 = (int) (result % 10000 / 5000);
		JPY2000 = (int) (result % 10000 % 5000 / 2000);
		JPY1000 = (int) (result % 10000 % 5000 % 2000 / 1000);

		printResultJPY(result, JPY10000, JPY5000, JPY2000, JPY1000);

	}

	public void outputResultWon(int exchgWon) {
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

