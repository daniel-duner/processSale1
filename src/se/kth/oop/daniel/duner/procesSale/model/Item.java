package se.kth.oop.daniel.duner.procesSale.model;

/**
 * Represents an item
 * itemDescription: A short text describing the item
 * price: The price of the item
 * itemId: Each item have a unique code
 * @author danielduner
 *
 */
public class Item {
	
private String name;
private int itemId;
private Amount price;
private String itemDescription;
private boolean itemExist;

/**
 * Instantiates an Item without arguments
 * @throws Exception
 */
public Item() throws Exception {	
this.name = "undefined";
this.itemId = 00000000;
this.price = new Amount(0);
this.itemDescription = "undefined";
this.itemExist = true;
}

/**
 * Instantiates an Item with a set Item ID
 * @param itemId
 * @throws Exception
 */
public Item(int itemId) throws Exception {
this.name = "undefined";
this.itemId = itemId;
this.price = new Amount(0);
this.itemDescription = "undefined";
this.itemExist = false;
}

/**
 * Instantiates and item setting all attributes to chosen values with the arguments
 * @param itemId represents the chosen item Id
 * @param price represents the chosen the chosen price
 * @param itemDescription represents the chosen description of the item
 * @param name represents the chosen name of the item
 */
public Item(int itemId, Amount price, String itemDescription,String name) {
	this.name = name;
	this.itemId = itemId;
	this.price = price;
	this.itemDescription = itemDescription;
}
	
/** 
 * 
 * Contains the format of the Item when it is turned into a String 
 * @return	Returns the item as a string representation
 */
public String toString() {
	return name+"\n" +itemId +"\n"+price +"\n"+itemDescription +"\n";
}

public void setName(String name) {
	this.name = name;
}

public void setItemId(int itemId) {
	this.itemId = itemId;
}

public void setPrice(Amount price) {
	this.price = price;
	
}
public void setitemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
	
}
public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
}

public void setItemExistTrue(){
	this.itemExist = true;
}
public void setItemExistFalse(){
	this.itemExist = false;
}

public String getName() {
	return this.name;
}
public int getItemId() {
	return this.itemId;
}
public Amount getPrice() {
	return this.price;
}
public String getItemDescription() {
	return this.itemDescription;
}
public boolean getItemValid() {
	return itemExist;
}


}