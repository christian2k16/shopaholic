/**
 *   File Name: numbersTest.java<br>
 *
 *   Mallapre, Christian<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Feb 11, 2016
 *
 */

package com.sqa.CM.util.helper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * numbersTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mallapre, Christian
 * @version 1.0.0
 * @since 1.0
 *
 */
@RunWith(Parameterized.class)
public class NumbersTest {
	@Parameters
	public static Object[][] getData() {
		Object[][] data = { { "Test 1", 1, 2, 3 }, { "Test 2", 4, 5, 9 }, { "Test 3", 7, 8, 15 },
				{ "Test 4", 11, 12, 23 }, { "Test 5", 14, 15, 29 }, { "Test 6", 17, 18, 35 } };
		return data;
	}

	String label;
	int num1;
	int num2;
	int expected;

	public NumbersTest(String label, int num1, int num2, int expected) {
		this.label = label;
		this.num1 = num1;
		this.num2 = num2;
		this.expected = expected;
	}

	@Test
	public void addNumbersTest() {
		System.out.println(this.label);
		int total = this.num1 + this.num2;
		Assert.assertEquals(this.expected, total);
		System.out.println("Passed " + total);
		Info.display2DInfo(getData());
	}

}
