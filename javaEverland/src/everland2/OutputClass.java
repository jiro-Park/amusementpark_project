package everland2;

public class OutputClass {

	CalculateClass cc = null;

	public void printSum(int ticketType, String residentNum, int ticketNum, int advantageType) {
		cc = new CalculateClass();
		double miniSum = cc.calMiniSum(ticketType, residentNum, ticketNum, advantageType);

		System.out.printf("가격은 %.0f 원 입니다.", miniSum);
	}

	public void printTotal() {
		CustomerInfo cuc = null;
		int sum = 0;
		System.out.printf("===========================%s=======================\n", " 에버랜드 ");
		for (int i = 0; i < Main.customerArr.size(); i++) {

			cuc = Main.customerArr.get(i);
			System.out.printf("%s %s X %d  %d *우대적용 %s\n", cuc.getTicketType_string(), cuc.getAgeType_string(),
					cuc.getTicketNum(), cuc.getMiniSum(), cuc.getAdvantegeType_string());
			sum += cuc.getMiniSum();
		}
		System.out.printf("입장료 총액은 %d 원 입니다\n", sum);

		System.out.printf("========================================================\n");

	}

}
