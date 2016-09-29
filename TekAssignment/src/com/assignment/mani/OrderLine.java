package com.assignment.mani;
import com.assignment.mani.Item;

public class OrderLine {

	private int quantity;
	private Item item;

	/*
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	
	public OrderLine(Item item, int quantity) throws Exception {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new NullPointerException("Item is NULL");      /**Changed global exception to Specific class exception*/
		}
//		assert quantity > 0;                                    /** Commented 'assert quantity' since it is used only in testing purposes*/
		this.item = item;                                       /** Assigned 'this' keyword to 'item' so that the value will be assigned to global variable*/
	  //this.quantity = quantity;                               /** Assigned 'this' keyword to 'Quantity' so that the value will be assigned to global variable*/
		setQuantity(quantity);									/** checking quantity >0 before assigning to instance variables**/
	}

	public Item getItem() {
		return item;
	}
	
	public void setQuantity(int quantity){                     /**Not allowing -ve quantity values*/
		if(quantity > 0){
			this.quantity = quantity;
		}
	}

	public int getQuantity() {
		return quantity;
	}
}

