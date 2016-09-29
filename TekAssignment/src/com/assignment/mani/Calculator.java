package com.assignment.mani;

import java.util.Map;


import com.assignment.mani.Order;

public class Calculator {                                     /**Class name should start with Uppercase as per industry standards,so first letter of class name was made to Uppercase */

	public static double rounding(double value) {
		return  Math.round(value * 100) / 100.00;             /** Used Math.round for rounding the value and 100 is made as 100.00 for rounding the value upto two decimal*/
	}

	
	/**
	 * Receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 * @param Map
	 */
	public static double calculate(Map<String, Order> o) {         /** Made Calculate() as 'static' as its behaviour doesnt change over objects*/

		double grandTotal = 0;                                     /**As per naming conventions of java, second word  of variable name should start with Upper case,so first letter of second word is made to Uppercase*/

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			//grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;                                 /**All the declarations are done on top*/
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {                /**Here i have changed i<= r.size() to i<r.size() to avoid error arrayoutofboundsindex*/

				// Calculate the taxes
				double tax = 0;
				double totalPrice = 0;                          /**As per naming conventions of java second word  of variable name should start with Upper case,so first letter of second word is made to Uppercase*/
				int qty = 0;
			    qty = r.get(i).getQuantity();                  /**Here i have added to getQuantity() method to get quantity value*/

				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {      /**Here i have added toLowerCase() method to avoid case sensitivity issues*/
					tax = (r.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = (r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				 totalPrice = r.get(i).getItem().getPrice() + (tax);
				//System.out.println("totalPrice:::"+totalprice);
				// Print out the item's total price
				totalPrice = rounding(qty*totalPrice);                               /**I have multiplied with quantity to total price,if quantity increases totalprice changes according to that*/
			 
				System.out.println(qty+" "+r.get(i).getItem().getDescription() + ": " + totalPrice); /**Add qty to sysout to print the quantity**/

				// Keep a running total
				totalTax += tax*qty;                                              /**I have multiplied with quantity to total Tax,if quantity increases totalTax changes according to that*/
				total += totalPrice;
			}

			// Print out the total taxes
			totalTax = rounding(totalTax);                             /**Rounding method is used instead of math.floor()*/
			System.out.println("Sales Tax: " + totalTax);
			total = total - totalTax;                                  /**Here expression is changed from total+totaltax to total-totaltax as per output*/

			// Print out the total amount
			total = rounding(total);                                   /**Rounding method is used instead of math.floor()*/
			System.out.println("Total: " + total);
			grandTotal += total;
		}

		System.out.println("Sum of orders: " + Math.floor(grandTotal * 100) / 100.00);
		return (Math.floor(grandTotal * 100) / 100.00);
	}
}