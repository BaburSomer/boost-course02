package com.bilgeadam.lesson019.model.product;

public interface Sellable {
	int price = 0;  // public final int demek oluyor
	
	double calcEndprice (double discountRate);
	void sell(int sellingAmount);
	
	default void notifySell () {
		System.out.println("Ürün satıldı");
	}
}
