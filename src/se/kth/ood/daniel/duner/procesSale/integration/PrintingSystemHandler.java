package se.kth.ood.daniel.duner.procesSale.integration;

import static java.lang.System.*;

import se.kth.ood.daniel.duner.procesSale.model.SaleDTO;

/**
 * Represents the system that handles the printer system that prints out receipts
 * @author danielduner
 *
 */

public class PrintingSystemHandler {
	
	/**
	 * Instantiates the printing system
	 */
	public PrintingSystemHandler() {
	}	

	public void printReceipt(SaleDTO saleDTO) {
		StringBuilder receipt = new StringBuilder();
		receipt.append("--------------------------------------------\n");
		receipt.append("RECEIPT\n");
		receipt.append("saleID: " + saleDTO.getSaleId() + "\n");
		receipt.append(saleDTO.getSaleDate().toString() + "\n");
		receipt.append("ITEM LIST: \n" + saleDTO.getGoods().toString() + "\n\n");
		receipt.append(saleDTO.getTotalCost().toString()+"\n");
		receipt.append("PAYMENT: \n" + saleDTO.getPayment().getPayment()+"\n\n");
		receipt.append("CHANGE: \n" + saleDTO.getPayment().getChange()+"\n");
		receipt.append("--------------------------------------------\n");
		out.println(receipt.toString());
	}
}
