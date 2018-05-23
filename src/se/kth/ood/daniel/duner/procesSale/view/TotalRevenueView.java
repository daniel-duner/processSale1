package se.kth.ood.daniel.duner.procesSale.view;

import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.InvalidAmountException;
import se.kth.ood.daniel.duner.procesSale.model.InvalidStringException;
import se.kth.ood.daniel.duner.procesSale.model.Observer;
import se.kth.ood.daniel.duner.procesSale.model.Subject;
/**
 * Represents the display that displays the total revenue during a run of the program
 * @author danielduner
 *
 */
public class TotalRevenueView implements Observer{
	private Amount totalRevenue;
	/**
	 * Creates an instance of the TotalRevenueView
	 * @throws InvalidStringException
	 * @throws InvalidAmountException If the Amount is negative
	 */
	public TotalRevenueView() throws InvalidStringException, InvalidAmountException {
		this.totalRevenue = new Amount(0);
	}
	/**
	 * Updates the value of total revenue
	 */
	@Override
	public void update(Amount totalRevenue) {
		this.totalRevenue = totalRevenue;
		printDisplay();
	}
	/**
	 * Prints the totalRevenue with format in the console (representing the display)
	 */
	public void printDisplay() {
		System.out.println("\n-------DISPLAY-------");
		System.out.println("Total Revenue: " + totalRevenue);
		System.out.println("---------------------\n");
	}
	
}
