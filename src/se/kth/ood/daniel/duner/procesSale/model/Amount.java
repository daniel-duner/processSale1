package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 * Represents an amount of money in a currency. A currency can be either SEK or
 * EUR. Instances are immutable
 * 
 * @author danielduner
 *
 */
public class Amount {
	private final double amount;
	private Currency currency;

	public Amount(){
		amount = 0;
		currency = Currency.SEK;	

	}
/**
 * creates a new instance of Amount
 * @param amount represents the chosen amount
 * @throws Exception
 */
	public Amount(double amount) throws InvalidAmountException {
		if (amount < 0) {
			throw new InvalidAmountException("Negative values are not allowed");
		} else {
			this.amount = amount;
		}
		currency = Currency.SEK;

	}

	/**
	 * adds or subtracts two amounts with the same currencies and creates a new instance of Amount
	 * with the new value
	 * @param currentAmount represents the amount which we want to subtract from or add to
	 * @param additionalAmount represents the amount we want to subtract or add to the currentAmount
	 * @param operation represents the the operation either notation for add or for subtract
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 * @throws InvalidCharException 
	 * @throws Exception
	 */
	public Amount(Amount currentAmount, Amount additionalAmount, char operation)
			throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		if (operation == '-' || operation == '+') {
			double newAmount = 0;
			if (operation == '-') {
				if(currentAmount.getAmount() - additionalAmount.getAmount() < 0) {
					throw new InvalidAmountException("Can't have negative Amounts");
				} else {
					newAmount = currentAmount.getAmount() - additionalAmount.getAmount();
				}
			} else if (operation == '+') {
				newAmount = currentAmount.getAmount() + additionalAmount.getAmount();
			}
			this.amount = newAmount;
			this.currency = currentAmount.getCurrency();
		} else {
			throw new InvalidCharException("Only operation - or + are allowed");
		}

	}
	/** 
	 * Contains the format of the Amount when it is turned into a String 
	 * @return	Returns the amount as string representation
	 */
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");     
		StringBuilder str = new StringBuilder();
		
		str.append(currency.toString()+" "+formatter.format(amount)+":-");
		
		return str.toString();
	}

	public double getAmount() {
		return this.amount;
	}

	public Currency getCurrency() {
		return this.currency;
	}

}
