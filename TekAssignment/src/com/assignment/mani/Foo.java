package com.assignment.mani;

import java.util.LinkedHashMap;
import java.util.Map;

import com.assignment.mani.Item;
import com.assignment.mani.Order;
import com.assignment.mani.OrderLine;
import static com.assignment.mani.Calculator.calculate;

public class Foo {

	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new LinkedHashMap<String, Order>();  /** I have used LinkedHashMap here to get the output as per insertion order */

		Order c = new Order();                                      /** I have created different objects for the Class ORDER to maintain orders in individual objects*/

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		//c.clear();                                                /** I have commented c.clear(), since it will erase all the data **/
		
		Order c1 = new Order();                                    /** I have created different objects for the Class ORDER*/

		c1.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c1.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c1);                                      /** I have created different objects for the Class ORDER*/

		// Reuse cart for an other order
		//c.clear();
		Order c2 = new Order();

		c2.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c2.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c2.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c2.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));   /** I have made spell correction here 'importd' to 'imorted'*/

		o.put("Order 3", c2);

		calculate(o); /** using static imports and calling calculate method directly **/

	}
}
