package se.kth.ood.daniel.duner.procesSale.view;

import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.Subject;

public class TotalRevenueView implements Observer{
	private Amount totalRevenue;
	
	public TotalRevenueView() throws Exception {
		this.totalRevenue = new Amount(0);
	}
	
	@Override
	public void update(Amount totalRevenue) {
		this.totalRevenue = totalRevenue;
		printDisplay();
	}
	
	public void printDisplay() {
		System.out.println("\n-------DISPLAY-------");
		System.out.println("Total Revenue: " + totalRevenue);
		System.out.println("---------------------\n");
	}
	
}
