package se.kth.oop.daniel.duner.procesSale.model;

import java.time.*;
/**
 * The class is a container of the time and date information
 * @author danielduner
 *
 */
public class SaleDate {
	private String startSaleTime;
	private String endOfSaleTime;
	private String date;
/**
 * Instantiates a sale date setting all attributes to null
 */
	public SaleDate() {
		startSaleTime = null;
		endOfSaleTime = null;
		date = null;
	}
/**
 * Format of the object when presented as a string
 */
	public String toString() {
		return "Date of sale: " + date + "\n"+"Sale started: " + startSaleTime + "\n"+"Sale ended: " + endOfSaleTime + "\n";
	}

	public void setStartSaleTime() {
		startSaleTime = LocalTime.now().toString();
	}

	public void setEndOfSaleTime() {
		endOfSaleTime = LocalTime.now().toString();
	}

	public void setDate() {
		date = LocalDate.now().toString();
	}

	public String getStartSaleTime() {
		return startSaleTime;
	}

	public String getEndOfSaleTime() {
		return endOfSaleTime;
	}

	public String getDate() {
		return date;
	}

}
