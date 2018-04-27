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
	
private String name;
private int itemId;
private Amount price;
private String itemDescription;

public Item(String currency) throws Exception {
this.itemId = 0;
this.price = new Amount(0,currency);
this.itemDescription = "undefined";
}

public Item(int itemId, Amount price, String itemDescription) {
	this.itemId = itemId;
	this.price = price;
	this.itemDescription = itemDescription;
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


}
