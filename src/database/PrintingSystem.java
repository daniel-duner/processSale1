package database;

import model.SaleDTO;
import static java.lang.System.*;

/**
 * Represents a database that stores all sales (HARDCODED)
 * @author danielduner
 *
 */

public class PrintingSystem {
	
	/**
	 * Instantiates the printing system
	 */
	public PrintingSystem() {
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
