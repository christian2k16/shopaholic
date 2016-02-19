package com.sqa.CM.util.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *   File Name: InfoTest.java<br>
 *
 *   Mallapre, Christian<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Feb 10, 2016
 *
 */

/**
 * InfoTest //ADDD (description of class)
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
public class InfoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Runs Before the Class executes - @BeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Runs After the Class executes - @AfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("\tDo setup for Test Method - @Before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("\tDo Tear Down for Test Method - @After");
	}

	/**
	 * Test method for
	 * {@link src.main.java.com.sqa.CM.util.helper.Info#display2DInfo(java.lang.Object[][])}
	 * .
	 */
	@Test
	public void testDisplay2DInfo() {
		System.out.println("\t\tTest for Display2DInfo - @Test");
	}

	/**
	 * Test method for
	 * {@link src.main.java.com.sqa.CM.util.helper.Info#displayInfo(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDisplayInfoObject() {
		System.out.println("\t\tTest for DisplayInfoObject - @Test");
		Animal animal = new Animal();
		Info.displayInfo(animal);
	}

	/**
	 * Test method for
	 * {@link src.main.java.com.sqa.CM.util.helper.Info#displayInfo(java.lang.Object[])}
	 * .
	 */
	@Test
	public void testDisplayInfoObjectArray() {
		System.out.println("\t\tTest for DisplayInfoObjectArray - @Test");
	}

	/**
	 * Test method for
	 * {@link src.main.java.com.sqa.CM.util.helper.Info#displayInfo(java.lang.Object, java.lang.Object, java.lang.Object[])}
	 * .
	 */
	@Test
	public void testDisplayInfoObjectObjectObjectArray() {
		System.out.println("\t\tTest for DisplayInfoObjectObjectObjectArray - @Test");
	}

	/**
	 * Test method for
	 * {@link src.main.java.com.sqa.CM.util.helper.Info#get2DInfo(java.lang.Object[][])}
	 * .
	 */
	@Test
	public void testGet2DInfo() {
		System.out.println("\t\tTest for Get2DInfo - @Test");
	}

	/**
	 * Test method for
	 * {@link src.main.java.com.sqa.CM.util.helper.Info#getInfo(java.lang.Object)}
	 * .
	 */
	@Test
	public void testGetInfo() {
		System.out.println("\t\tTest for GetInfo - @Test");
	}

}

class Animal {

	/**
	 *
	 */
	private int age;

	/**
	 *
	 */
	private String gender;

	/**
	 *
	 */
	private String name;

	/**
	 *
	 */
	private double weight;

	/**
	 * Default constructor
	 */
	public Animal() {
	}

	/**
	 * @param name
	 * @param gender
	 * @param age
	 * @param weight
	 */
	public void Animal(String name, String gender, int age, double weight) {
		// TODO implement here
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @see java.lang.Object#toString()
	 */

	@Override
	@Test
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [age=");
		builder.append(this.age);
		builder.append(", gender=");
		builder.append(this.gender);
		builder.append(", name=");
		builder.append(this.name);
		builder.append(", weight=");
		builder.append(this.weight);
		builder.append("]");
		return builder.toString();
	}
}