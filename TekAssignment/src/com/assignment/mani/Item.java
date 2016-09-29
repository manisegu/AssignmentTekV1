package com.assignment.mani;

public class Item {

	private String description;
	private float price;

	public Item(String description, float price) {
		super();
		this.description = description;
//		this.price = price;
		setPrice(price);									/** checking price>0 before assigning to instance variables**/
	}

	public String getDescription() {
		return description;
	}
	
	public void setPrice(float price){                         /** Not allowing negative prices**/
		if(price > 0){
			this.price = price;
		}
	}

	public float getPrice() {
		return price;
	}
}