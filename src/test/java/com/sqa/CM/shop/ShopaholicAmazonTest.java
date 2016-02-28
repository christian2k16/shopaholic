package com.sqa.CM.shop;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.CM.util.helper.SelUtil;
import com.sqa.CM.util.helper.SelUtil.STRATEGY;

public class ShopaholicAmazonTest {

	double totalPrice = 0;
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Changing the value of the object data requires to change the expected
	 * value on the Assert
	 */
	@DataProvider
	public Object[][] checkAddCart() {
		return new Object[][] {
				// TODO Modify Data
				new Object[] { 1 } };
	}

	@Test(priority = 1, dataProvider = "checkAddCart")
	public void f(Integer s) {
		// Declare variable to hold the input value from the object
		String text = null;
		// Sign in to Amazon.com
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]")).click();
		this.driver.findElement(By.id("ap_email")).clear();
		this.driver.findElement(By.id("ap_email")).sendKeys("mallaprechristian@gmail.com");
		this.driver.findElement(By.id("ap_password")).clear();
		this.driver.findElement(By.id("ap_password")).sendKeys("dummy123");
		SelUtil.superClick(this.driver, "signInSubmit:nav-cart:a-autoid-6-announce".split(":"),
				new SelUtil.STRATEGY[] { STRATEGY.ID, STRATEGY.ID, STRATEGY.ID });

		// Concatenation
		int num = s - 1;
		String hit = "dropdown" + s.toString() + "_" + String.valueOf(num);
		this.driver.findElement(By.id(hit)).click();
		this.driver.findElement(By.id("nav-cart")).click();
		text = this.driver.findElement(By.id("a-autoid-6-announce")).getText();
		Assert.assertEquals(s.toString(), text);
	}

	/**
	 * if the value of the object data was changed, it requires to change the
	 * expected value on the Assert
	 */
	@Test(priority = 2, dataProvider = "checkAddCart")
	public void f1(Integer s) {
		// Declare variable
		String strAmount = null;
		// Get the item price
		strAmount = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[3]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		// Remove the dollar sign
		String strAmount2 = strAmount.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		// Parse the string value to double
		double amount = Double.parseDouble(strAmount2);
		// Compute the total amount by multiplying the amount of item to the
		// quantity
		double total = amount * s;
		this.totalPrice = total;
		// Validate if the total is equal to the expected value
		Assert.assertEquals(98.00, total, 2);
	}

	/**
	 * if the value of the object data was changed, it requires to change the
	 * expected value on the Assert
	 */
	@Test(priority = 3, dataProvider = "checkAddCart")
	public void f2(Integer s) {

		// Get the item price
		String strAmount = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[2]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		// Remove the dollar sign
		String strCleanAmount = strAmount.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		// Parse the String value to Double
		double amount2 = Double.parseDouble(strCleanAmount);
		// Get the item price
		String strAmount2 = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[1]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		// Remove the dollar sign
		strCleanAmount = strAmount2.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		// Parse the String value to Double
		double amount3 = Double.parseDouble(strCleanAmount);
		// Compute the total amount
		double gtotal = this.totalPrice + amount2 + amount3;
		// Validate if the total is correct
		Assert.assertEquals(341.92, gtotal, 2);

	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://www.amazon.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
