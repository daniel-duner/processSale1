package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Contains information of value added tax
 * @author danielduner
 *
 */
public class ValueAddedTax {
	private double valueAddedTax = 0.25;
	private double fullTaxRate = 1;
	private double zeroTax = 0;
	
/**
 * Instantiates the value added tax with standard tax rate of 25%
 */
	public ValueAddedTax() {
		valueAddedTax = 0.25;
	}	
/**
 * Instantiates the value added tax with a chosen tax rate
 * @param valueAddedTax chosen tax rate
 * @throws Exception
 */
	public ValueAddedTax(double valueAddedTax) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		if (checkAllowedValueAddedTax(valueAddedTax) == false) {
			throw new InvalidAmountException("value-added tax can only be a double between 0 and 1");
		}
		this.valueAddedTax = valueAddedTax;
	}
/**
 * Sets the tax rate with chosen tax rate
 * @param valueAddedTax represents the chosen tax rate
 * @throws Exception
 */
	public void setValueAddedTax(double valueAddedTax) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		if (checkAllowedValueAddedTax(valueAddedTax) == false) {
			throw new InvalidAmountException("value-added tax can only be a double between 0 and 1");
		}
		this.valueAddedTax = valueAddedTax;
	}
	
	private boolean checkAllowedValueAddedTax(double valueAddedTax) {
		if (valueAddedTax <= fullTaxRate && valueAddedTax >= zeroTax) {
			return true;
		}
		return false;
	}	
	
	
	
	
	
	public double getValueAddedTax() {
		return this.valueAddedTax;
	}
}
