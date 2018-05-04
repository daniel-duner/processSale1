package se.kth.oop.daniel.duner.procesSale.model;

/**
 * a data cointainer of an instance if saleInformation, to be sent to the UI
 * @author danielduner
 *
 */

public class SaleInformationDTO {
		Amount runningTotal;
		Amount itemPrice;
		boolean itemValid;
		String itemName;
		int quantity;
		int noOnList;
		
		SaleInformationDTO(SaleInformation saleInformation){
			runningTotal = saleInformation.getRunningTotal();
			itemPrice = saleInformation.getItem().getPrice();
			itemValid = saleInformation.getItemValid();
			itemName = saleInformation.getItem().getName();
			quantity = saleInformation.getQuantity();
			noOnList = saleInformation.getNoOnList();
		}
		
		public Amount getItemPrice() {
			return itemPrice;
		}
		public Amount getRunningTotal() {
			return runningTotal;
		}
		public boolean getItemValid() {
			return itemValid;
		}
		public String getItemName() {
			return itemName;
		}
		public int getQuantity() {
			return quantity;
		}
		public int getNoOnList() {
			return noOnList;
		}
}
