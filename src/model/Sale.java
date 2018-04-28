package model;

import integration.*;

public class Sale {
	private int saleId;
	private SaleDate saleDate;
	private Goods goods;
	private TotalCost totalCost;
	private SaleInformation saleInformation;
	private Payment cashPayment;

	public Sale(int saleId) throws Exception {
		this.saleId = saleId;
		this.saleDate = new SaleDate();
		this.goods = new Goods();
		this.totalCost = new TotalCost();
		this.saleInformation = new SaleInformation();
		
	}

	public void setStarTime() {
		saleDate.setStartSaleTime();
		saleDate.setDate();
	}

	public void setEndingTime() {
		saleDate.setEndOfSaleTime();
	}

	public SaleInformationDTO addItem(Item item) throws Exception {
		if (item.getItemValid())
		{
			goods.addItem(item);
		}
		saleInformation.updateSaleInformation(goods, item);
		SaleInformationDTO saleInformationDTO = new SaleInformationDTO(saleInformation);
		return saleInformationDTO;
	}

	public TotalCost endRegistration() throws Exception {
		totalCost.setTotalCost(goods.getPrice());
		return totalCost;
	}
	
	public Amount registerPayment(Amount payment,CashRegister cashRegister) throws Exception {
		cashPayment = new Payment(payment, totalCost, cashRegister);
		return cashPayment.getChange();
	}
	
	public void endSale(ExternalSystemHandler externalSystemHandler) {
		setEndingTime();
		SaleDTO saleDTO = new SaleDTO(this);
		externalSystemHandler.registerCompletedSale(saleDTO);
	}
	
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

}
