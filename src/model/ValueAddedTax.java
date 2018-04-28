package model;

import exceptions.InvalidAmountException;

public class ValueAddedTax {
	double valueAddedTax = 0.25;

	public ValueAddedTax() {
		valueAddedTax = 0.25;
	}

	public ValueAddedTax(double valueAddedTax) throws Exception {
		if (checkAllowedValueAddedTax(valueAddedTax)) {
			throw new InvalidAmountException("value-added tax can only be a double between 0 and 1");
		}
		this.valueAddedTax = valueAddedTax;
	}

	public void setValueAddedTax(double valueAddedTax) throws Exception {
		if (checkAllowedValueAddedTax(valueAddedTax)) {
			throw new InvalidAmountException("value-added tax can only be a double between 0 and 1");
		}
		this.valueAddedTax = valueAddedTax;
	}

	public double getValueAddedTax() {
		return this.valueAddedTax;
	}

	private boolean checkAllowedValueAddedTax(double valueAddedTax) {
		if (valueAddedTax < 0 || valueAddedTax > 1) {
			return true;
		}
		return false;
	}
}
