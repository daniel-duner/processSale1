package integration;
import model.Amount;

/**
 * Represents an item
 * itemDescription: A short text describing the item
 * price: The price of the item
 * itemId: Each item have a unique code
 * @author danielduner
 *
 */
public class Item {
	
private int itemId;
private Amount price;
private String itemDescription;

public Item() throws Exception {
this.itemId = 0;
this.price = new Amount(0,"SEK");
this.itemDescription = "undefined";
}

public Item(int itemId, Amount price, String itemDescription) {
	this.itemId = itemId;
	this.price = price;
	this.itemDescription = itemDescription;
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

public int getItemId() {
	return this.itemId;
}
public Amount getPrice() {
	return this.price;
}

public String getItemDescription() {
	return this.itemDescription;
}


}
