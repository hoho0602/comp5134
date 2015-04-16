package com.testcase;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit.framework.TestCase;

import org.junit.Test;

import com.domain.Decorator;
import com.domain.Decorators;
import com.domain.Flavor;
import com.domain.FlavoredIceCream;

public class TestDecorators extends TestCase{

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	@Test
	public void test() {
		Flavor a = new Flavor("11", 1.2);
		FlavoredIceCream b = new FlavoredIceCream(a);
		Decorator c = new Decorator("22", 3.1);
		Decorators test = new Decorators(b, c);
		assertEquals("11Ice Cream with 22", test.getDescription());
		double cost = test.cost();
		assertEquals(4.3, test.cost());
		Decorator d = new Decorator("33", 6.1);
		test = new Decorators(b, d);
		assertEquals("11Ice Cream with 22 with 33", test.getDescription());
		assertEquals(10.4, round(test.cost(),1));
		//fail("Not yet implemented");
		
		Decorators.addDecorator("aa", 1.3);
		assertNotEquals(0, Decorators.decoratorList.size());
		
		Flavor aa = new Flavor("aa", 1.3);
		FlavoredIceCream bb = new FlavoredIceCream(aa);
		test = new Decorators(bb);
		assertEquals("aaIce Cream with 22 with 33", test.getDescription());
		assertEquals(10.5, round(test.cost(),1));
		
		Flavor aaa = new Flavor("aaa", 1.2);
		FlavoredIceCream bbb = new FlavoredIceCream(aaa);
		test = new Decorators(bbb, true);
		assertEquals(0, Decorators.ordered.size());
		
	}

}
