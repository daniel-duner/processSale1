package model;

import java.time.*;

public class SaleDate {
	private String startSaleTime;
	private String endOfSaleTime;
	private String date;

	public SaleDate() {
		startSaleTime = null;
		endOfSaleTime = null;
		date = null;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Date of sale: " + date + "\n");
		str.append("Sale started: " + startSaleTime + "\n");
		str.append("Sale ended: " + endOfSaleTime + "\n");
		return str.toString();
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
