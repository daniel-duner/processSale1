package database;

import model.SaleDTO;
import static java.lang.System.*;

public class PrintingSystem {
	
	public PrintingSystem() {

	}

	public void printReceipt(SaleDTO saleDTO) {
		StringBuilder receipt = new StringBuilder();
		receipt.append("saleID: " + saleDTO.getSaleId() + "\n");
		receipt.append("Date of Sale: " + saleDTO.getSaleDate() + "\n");
		receipt.append("Items: \n" + saleDTO.getGoods().toString() + "\n");
		receipt.append(saleDTO.getTotalCost().toString()+"\n");
		receipt.append("Payment: \n" + saleDTO.getPayment().toString());
		out.println(receipt.toString());
	}
}
