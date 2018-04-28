package model;

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
		
		SaleInformationDTO(SaleInformation saleInformation){
			runningTotal = saleInformation.getRunningTotal();
			itemPrice = saleInformation.getItem().getPrice();
			itemValid = saleInformation.getItemValid();
			itemName = saleInformation.getItem().getName();
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
}
