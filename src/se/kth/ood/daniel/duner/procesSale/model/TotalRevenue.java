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
	 * @return the only instance of TotalRevenue
	 */
	public static TotalRevenue getInstance() {
		return instance;
	}
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer observer:observers) {
			observer.update(this.totalRevenue);
		}
	}
	
	public void setTotalRevenue(Amount payment) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		this.totalRevenue = new Amount(totalRevenue, payment,'+');
	}
	public void setTotalRevenue(double amount) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		this.totalRevenue = new Amount(amount);
	}


}
