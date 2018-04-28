package model;

public class Adress {
	private String street;
	private int streetNo;
	private String city;
	private int zipCode;

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
