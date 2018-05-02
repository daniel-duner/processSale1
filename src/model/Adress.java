package model;
/**
 * Represents a set of data making up an address
 * @author danielduner
 *
 */
public class Adress {
	private String street;
	private int streetNo;
	private String city;
	private int zipCode;
/**
 * Instantiates an address
 * @param street represents the chosen street name
 * @param streetNo represents the street number chosen
 * @param city represents the chosen city name
 * @param zipCode represents the chosen zip code
 */
	public Adress(String street, int streetNo, String city, int zipCode) {
		this.street = street;
		this.streetNo = streetNo;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public String getCity() {
		return city;
	}
	public int getZipCode() {
		return zipCode;
	}
}
