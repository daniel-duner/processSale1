package integration;
import model.Amount;

public class Item {
	
private int itemId;
private Amount price;
private String itemDescription;

public Item() {
this.itemId = 0;
this.price = null;
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
