package com.testcase;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.util.Utilities;

public class TestUtil extends TestCase{

	@Test
	public void test() {
		 Utilities util = Utilities.getInstance(); 
		 assertEquals(13.4, util.round(13.36, 1));
		 assertEquals(13.85, util.round(13.8522, 2));
		 assertEquals(1.4, util.round(1.44, 1));
		//fail("Not yet implemented");
	}

}
