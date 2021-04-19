package javaEverland;

public class RunClass {
	InputClass ic = null;
	
	public void runCycle() {
		ic = new InputClass();
		
		
	do {
		ic.InputTicketType();
		ic.InputResidentNum();
		ic.InputTicketNum();
		ic.InputAdvantageType();
	
		ic.InputStopOrContinue();
		
		
		
	}while(true);

}
}