package everland2;

public class OutputClass {
	CalculateClass cc = null;
	CustomerInfo ci = null;
                                
	public void printSum(int ticketType, String residentNum, int ticketNum, int advantageType) {
		cc = new CalculateClass();                          
		double miniSum = cc.calMiniSum(ticketType, residentNum, ticketNum, advantageType);
		System.out.printf("가격은 %.0f 원 입니다.", miniSum);                              // 현 주문건 출력
	}

	public void printTotal() {                                             
		CustomerInfo cuc = null;
		int sum = 0;
		System.out.printf("===========================%s=======================\n", " 에버랜드 ");
		for (int i = 0; i < Main.customerArr.size(); i++) {
			cuc = Main.customerArr.get(i);
			System.out.printf("%s %5s X %2d  %8d  *우대적용 %6s\n", cuc.getTicketType(), cuc.getAgeType(), 
					cuc.getTicketNum(), cuc.getMiniSum(), cuc.getAdvantageType());
			sum += cuc.getMiniSum();
		}
		System.out.printf("입장료 총액은 %d 원 입니다\n", sum);
		System.out.printf("==========================================================\n");
	}                                                                              // 모든 주문건 합산 출력

}
