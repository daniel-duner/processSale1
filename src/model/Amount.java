package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import exceptions.InvalidAmountException;
import exceptions.InvalidCharException;

/**
 * Represents an amount of money in a currency. A currency can be either SEK or
 * EUR. Instances are immutable
 * 
 * @author danielduner
 *
 */
public class Amount {
	private final double amount;
	private String currency;

	public Amount(){
		amount = 0;
		currency = "SEK";

	}
	// creates a new instance of Amount
	public Amount(double amount) throws Exception {
		if (amount < 0) {
			throw new InvalidAmountException("Negative values are not allowed");
		} else {
			this.amount = amount;
		}
		currency = "SEK";

	}

	// adds or subtracts two amounts with the same currencies and creates a new
	// instance of Amount
	public Amount(Amount currentAmount, Amount amountToAdd, char operation)
			throws Exception {
		if (operation == '-' || operation == '+') {
			double newAmount = 0;
			if (operation == '-') {
				if(currentAmount.getAmount() - amountToAdd.getAmount() < 0) {
					throw new InvalidAmountException("Can't have negative Amounts");
				} else {
					newAmount = currentAmount.getAmount() - amountToAdd.getAmount();
				}
			} else if (operation == '+') {
				newAmount = currentAmount.getAmount() + amountToAdd.getAmount();
			}
			this.amount = newAmount;
			this.currency = currentAmount.getCurrency();
		} else {
			throw new InvalidCharException("Only operation - or + are allowed");
		}

	}
	
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");     
		StringBuilder str = new StringBuilder();
		
		str.append(currency+" "+formatter.format(amount)+":-");
		
		return str.toString();
	}

	// returns amount
	public double getAmount() {
		return this.amount;
	}

	// returns currency
	public String getCurrency() {
		return this.currency;
	}

}
