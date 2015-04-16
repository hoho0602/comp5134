package com.testcase;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit.framework.TestCase;

import org.junit.Test;

import com.domain.Flavor;
import com.domain.FlavoredIceCream;

public class TestFlavoredIceCream extends TestCase{

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	@Test
	public void test() {
		Flavor a = new Flavor("11", 1.2);
		FlavoredIceCream test = new FlavoredIceCream(a);
		assertEquals("11Ice Cream", test.getDescription());
		//assertEquals(1.2, test.cost());
		assertEquals(1.2, round(test.cost(),1));
		//fail("Not yet implemented");
		FlavoredIceCream.addFlavor("aa", 1.3);
		assertNotEquals(0, FlavoredIceCream.flavorList.size());	
	}

}
