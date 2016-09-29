package com.assginment.mani.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.assignment.mani.Item;

public class ItemTest {

	Item i1 ;


	@Before
	public void setUp() throws Exception {
		i1 = new Item("testItem",-12);
	}

	@After
	public void tearDown() throws Exception {
		i1 = null;
	}

	/**
	 * Testing if method is accepting negative values
	 */
	@Test
	public void testGetPrice() {
		float actual= i1.getPrice();
		float expected = 0.0f;
		assertEquals("Two Values are Equal",expected, actual,0.0f);
	}

}

