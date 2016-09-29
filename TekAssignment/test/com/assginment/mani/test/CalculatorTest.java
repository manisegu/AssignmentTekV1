package com.assginment.mani.test;

import static com.assignment.mani.Calculator.calculate;
import static com.assignment.mani.Calculator.rounding;
import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import com.assignment.mani.Item;
import com.assignment.mani.Order;
import com.assignment.mani.OrderLine;

public class CalculatorTest {

	@Before
	public void setUp() throws Exception {
	}
	
	
	/**
	 * Testing whether value is rounding to two decimal point or not
	 */
	@Test
	public void testRounding() {
		double value = 97.82465;
		double actual = 97.82;
		double expected;
		
		expected = rounding(value);
		System.out.println(expected);
		
		 assertEquals("Two Values are Equal",expected, actual,0.0f);
	}
	
	/**
	 * Testing Not Null  Assert Not null for calculate() .
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void testCalculateNull() throws Exception{
		Map<String, Order>	o = new LinkedHashMap<String, Order>();
		Order c=null;
		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		
		o.put("Order 1", c);
	    calculate(o);
	}
	
	/**
	 * Testing Whether the values are same or not
	 */
	@Test
	public void testCalculateSame() throws Exception {
		
		Map<String, Order> o = new LinkedHashMap<String, Order>();  /** I have used LinkedHashMap here to get the output as per insertion order */
		double expected;
		double actual = 153.82;
		
		Order c = new Order();                                      /** I have created different objects for the Class ORDER to maintain orders individually*/

		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		//c.clear();                                                /** */
		
		Order c1 = new Order();                                     /** I have created different objects for the Class ORDER*/

		c1.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c1.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c1);

		// Reuse cart for an other order
		//c.clear();
		Order c2 = new Order();

		c2.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c2.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c2.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c2.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c2);

		expected = calculate(o);
		 assertEquals("Two Values are Equal",expected, actual,0.0f);
	}
	
	/**
	 * Testing with different values
	 */
	@Test
	public void testCalNotSame() throws Exception {
		Double actual = 153.82;
		Double unexpected;
		Map<String, Order> o = new LinkedHashMap<String, Order>();

		Order c = new Order();
		c.add(new OrderLine(new Item("book", (float) 11.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 13.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		//c.clear();
		
		Order c1 = new Order();

		c1.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c1.add(new OrderLine(new Item("imported bottle of perfume", (float) 46.50), 1));

		o.put("Order 2", c1);

		// Reuse cart for an other order
		//c.clear();
		Order c2 = new Order();

		c2.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c2.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c2.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c2.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c2);

		 unexpected=calculate(o);
	
		 assertNotSame(unexpected, actual);
		 
		
		
	}
}
	
	


