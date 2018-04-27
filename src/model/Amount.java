package model;

import exceptions.*;

/**
 * Represents an amount of money in a currency. A currency can be either SEK or
 * EUR. Instances are immutable
 * 
 * @author danielduner
 *
 */
public class Amount {
	private final int amount;
	private String currency;

	// creates a new instance of Amount
	public Amount(int amount, String currency) throws InvalidAmountException, InvalidStringException {
		if (amount < 0) {
			throw new InvalidAmountException("Negative values are not allowed");
		} else {
			this.amount = amount;
			if ((currency == "SEK") || (currency == "EUR")) {
				this.currency = currency;
			} else {
				throw new InvalidStringException("Only SEK or EUR are allowed currencies");
			}

		}

	}

	// adds or subtracts two amounts with the same currencies and creates a new
	// instance of Amount
	public Amount(Amount currentAmount, Amount amountToAdd, char operation)
			throws InvalidStringException, InvalidCharException, InvalidAmountException {
		if (currentAmount.getCurrency() != amountToAdd.getCurrency()) {
			throw new InvalidStringException("The currencies deosn't match, the amounts have to be of the same currency");
		} else if (operation == '-' || operation == '+') {
			int newAmount = 0;
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

	// returns amount
	public int getAmount() {
		return this.amount;
	}

	// returns currency
	public String getCurrency() {
		return this.currency;
	}

}
