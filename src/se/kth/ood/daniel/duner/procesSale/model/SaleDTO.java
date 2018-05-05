package se.kth.ood.daniel.duner.procesSale.model;

public class SaleDTO {
	private int saleId;
	private SaleDate saleDate;
	private Goods goods;
	private TotalCost totalCost;
	private SaleInformation saleInformation;
	private Payment cashPayment;
	
	public SaleDTO(Sale sale) {
		saleId = sale.getSaleId();
		saleDate = sale.getSaleDate();
		goods = sale.getGoods();
		totalCost = sale.getTotalCost();
		saleInformation = sale.getSaleInformation();
		cashPayment = sale.getPayment();
		
	}
	public int getSaleId(){
		return saleId;
	}
	public SaleDate getSaleDate(){
		return saleDate;
	}
	public Goods getGoods(){
		return goods;
	}
	public TotalCost getTotalCost(){
		return totalCost;
	}
	public SaleInformation getSaleInformation(){
		return saleInformation;
	}
	public Payment getPayment() {
		return cashPayment;
	}
}
