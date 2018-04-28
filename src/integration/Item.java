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
private boolean itemExist;

public Item() throws Exception {
this.name = "undefined";
this.itemId = 00000000;
this.price = new Amount(0);
this.itemDescription = "undefined";
this.itemExist = true;
}
public Item(int itemId) throws Exception {
this.name = "undefined";
this.itemId = itemId;
this.price = new Amount(0);
this.itemDescription = "undefined";
this.itemExist = false;
}

public Item(int itemId, Amount price, String itemDescription,String name) {
	this.name = name;
	this.itemId = itemId;
	this.price = price;
	this.itemDescription = itemDescription;
}

public String toString() {
	System.out.println(name);
	System.out.println(itemId);
	System.out.println(price.getAmount());
	System.out.println(itemDescription);
	return null;
	
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
