package com.testcase;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit.framework.TestCase;

import org.junit.Test;

import com.domain.Flavor;
import com.domain.FlavoredIceCream;
import com.domain.IceCream;
import com.util.Utilities;

public class TestIceCream extends TestCase{

	private Utilities util = Utilities.getInstance();
	@Test
	public void test() {
		Flavor a = new Flavor("11", 1.2);
		IceCream test = new FlavoredIceCream(a);
		assertEquals("11Ice Cream", test.getDescription());
		assertEquals(1.2, util.round(test.cost(),1));
		//fail("Not yet implemented");
	}

}
