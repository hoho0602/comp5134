package com.testcase;

import junit.framework.Test;
import junit.framework.TestSuite;


public class SimpleTestSuite extends TestSuite{
	public static Test suite() {
		TestSuite suite = new TestSuite("Sample Tests");

		// Add one entry for each test class
		// or test suite.
		suite.addTestSuite(TestDecorators.class);
		suite.addTestSuite(TestFlavoredIceCream.class);
		suite.addTestSuite(TestIceCreamDecorator.class);
		suite.addTestSuite(TestIceCream.class);


		return suite;
		}
}
