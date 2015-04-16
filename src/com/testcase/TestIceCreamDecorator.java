package com.testcase;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.domain.Decorator;
import com.domain.Decorators;
import com.domain.Flavor;
import com.domain.FlavoredIceCream;
import com.domain.IceCreamDecorators;

public class TestIceCreamDecorator extends TestCase{

	@Test
	public void test() {
		Flavor a = new Flavor("11", 1.2);
		FlavoredIceCream b = new FlavoredIceCream(a);
		Decorator c = new Decorator("22", 3.1);
		IceCreamDecorators test = new Decorators(b, c);
		assertEquals("11Ice Cream with 22", test.getDescription());
		//fail("Not yet implemented");
	}

}
