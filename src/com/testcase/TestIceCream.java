package com.testcase;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit.framework.TestCase;

import org.junit.Test;

import com.domain.Flavor;
import com.domain.FlavoredIceCream;
import com.domain.IceCream;

public class TestIceCream extends TestCase{

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	@Test
	public void test() {
		Flavor a = new Flavor("11", 1.2);
		IceCream test = new FlavoredIceCream(a);
		assertEquals("11Ice Cream", test.getDescription());
		assertEquals(1.2, round(test.cost(),1));
		//fail("Not yet implemented");
	}

}
