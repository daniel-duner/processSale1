package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import se.kth.ood.daniel.duner.procesSale.view.Observer;
/**
 * Stores all revenues from all sales
 * @author danielduner
 *
 */
public class TotalRevenue implements Subject{
	private List <Observer> observers;
	private Amount totalRevenue;
	
	private static TotalRevenue instance = new TotalRevenue();
	
	private TotalRevenue(){
		observers = new ArrayList<Observer>();
		try {
			setTotalRevenue(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the only instance of the TotalRevenue object
	 * @return returns the intance of TotalRevenue
	 */
	public static TotalRevenue getInstance() {
		return instance;
	}
	/**
	 * Adds an instance of <Observer> to the ArrayList observers
	 */
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}
	/**
	 * removes an instance of <Observer> from the ArrayList observers
	 */
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}
	/**
	 * Notifies all observers in the ArrayList observers
	 */
	@Override
	public void notifyObservers() {
		for(Observer observer:observers) {
			observer.update(this.totalRevenue);
		}
	}
	/**
	 * Adds an amount to the total revenue
	 * @param payment represents the payment that is added to the total revenue
	 * @throws InvalidAmountException if the amount is negative
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidCharException if the operator isn't + or -
	 */
	public void setTotalRevenue(Amount payment) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		this.totalRevenue = new Amount(totalRevenue, payment,'+');
	}
	/**
	 * Sets the amount of the total revenue
	 * @param amount represents an amount
	 * @throws InvalidAmountException if the amount is negative
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidCharException if the operator isn't + or -
	 */
	public void setTotalRevenue(double amount) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		this.totalRevenue = new Amount(amount);
	}


}
