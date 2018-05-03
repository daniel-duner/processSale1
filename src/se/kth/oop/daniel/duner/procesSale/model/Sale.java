package se.kth.oop.daniel.duner.procesSale.model;

import se.kth.oop.daniel.duner.procesSale.integration.*;
/**
 * The class is the general class that tells the other classes what to do, so that the whole sale process
 * works
 * @author danielduner
 *
 */
public class Sale {
	private int saleId;
	private SaleDate saleDate;
	private Goods goods;
	private TotalCost totalCost;
	private SaleInformation saleInformation;
	private Payment cashPayment;

	/**
	 * Instantiates the Sale object and creates the attributes and sets start time and the date of the sale
	 * @param saleId represents the ID number of the new sale
	 * @throws Exception
	 */
	public Sale(int saleId) throws Exception {
		this.saleId = saleId;
		this.saleDate = new SaleDate();
		this.goods = new Goods();
		this.totalCost = new TotalCost();
		this.saleInformation = new SaleInformation();
		this.setStartTime();
	}

	/**
	 * Adds an item to the sale in goods (Calls goods) and returns saleinformation
	 * to the caller
	 * @param item represents the item caller wants to add to sale
	 * @return returns sale information to the caller
	 * @throws Exception
	 */
	public SaleInformationDTO addItem(Item item) throws Exception {
		if (item.getItemValid()) {
			goods.addItem(item);
		}
		saleInformation.updateSaleInformation(goods, item);
		SaleInformationDTO saleInformationDTO = new SaleInformationDTO(saleInformation);
		return saleInformationDTO;
	}

	/**
	 * 
	 * Adds a quantity of items to the sale with the same item ID and returns
	 * sale information to the caller
	 * 
	 * @param item represents the type of items added
	 * @param quantity represents the quantity of items added
	 * @return returns sale information to the caller
	 * @throws Exception
	 */
	public SaleInformationDTO addMultipleItems(Item item, int quantity) throws Exception {
		if (item.getItemValid()) {
			for (int i = 0; i < quantity; i++) {
				goods.addItem(item);
			}	
		}
		saleInformation.updateSaleInformation(goods, item, quantity);
		SaleInformationDTO saleInformationDTO = new SaleInformationDTO(saleInformation);
		return saleInformationDTO;
	}

	/**
	 * 
	 * Ends the registration of items and returns the total cost of the sale
	 * including taxes
	 * 
	 * @return returns total cost of the sale including taxes
	 * @throws Exception
	 */
	public TotalCost endRegistration() throws Exception {
		totalCost.setTotalCost(goods.getPrice());
		return totalCost;
	}

	/**
	 * 
	 * Registers a payment and adds it to the balance in the cash register
	 * and calculates the change and returns it to the caller
	 * 
	 * @param payment represents the payment received
	 * @param cashRegister represents the cash register
	 * @return returns the calculated change
	 * @throws Exception
	 */
	public Amount registerPayment(Amount payment, CashRegister cashRegister) throws Exception {
		cashPayment = new Payment(payment, totalCost, cashRegister);
		return cashPayment.getChange();
	}
/**
 * Ends the current sale and sets the end time and send the information of the sale to external systems
 * @param externalSystemHandler represent the external system handling system
 */
	public void endSale(ExternalSystemHandler externalSystemHandler) {
		setEndingTime();
		SaleDTO saleDTO = new SaleDTO(this);
		externalSystemHandler.registerCompletedSale(saleDTO);
	}
/**
 * Sets the discount eligibility
 * @param membership represents the information about the customers membership status
 * @throws Exception
 */
	public void setDiscountEligibility(Membership membership) throws Exception {
		totalCost.setDiscountEligibility(membership, goods.getPrice());
	}

	public int getSaleId() {
		return saleId;
	}

	public SaleDate getSaleDate() {
		return saleDate;
	}

	public Goods getGoods() {
		return goods;
	}

	public TotalCost getTotalCost() {
		return totalCost;
	}

	public SaleInformation getSaleInformation() {
		return saleInformation;
	}

	public Payment getPayment() {
		return cashPayment;
	}

	private void setStartTime() {
		saleDate.setStartSaleTime();
		saleDate.setDate();
	}

	private void setEndingTime() {
		saleDate.setEndOfSaleTime();
	}

}
