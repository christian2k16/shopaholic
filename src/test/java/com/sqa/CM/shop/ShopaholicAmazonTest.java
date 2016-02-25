package com.sqa.CM.shop;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ShopaholicAmazonTest {
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
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.cssSelector("span.nav-action-inner")).click();
		this.driver.findElement(By.id("ap_email")).clear();
		this.driver.findElement(By.id("ap_email")).sendKeys("mallaprechristian@gmail.com");
		this.driver.findElement(By.id("ap_password")).clear();
		this.driver.findElement(By.id("ap_password")).sendKeys("dummy123");
		this.driver.findElement(By.id("signInSubmit")).click();
		this.driver.findElement(By.id("nav-cart")).click();
		String text = null;
		int cartQty = 0;
		int itemQty = 0;
		switch (s) {
		case 1:
			this.driver.findElement(By.id("a-autoid-6-announce")).click();
			this.driver.findElement(By.id("dropdown1_0")).click();
			this.driver.findElement(By.id("nav-cart")).click();
			text = this.driver.findElement(By.xpath(".//*[@id='a-autoid-6-announce']")).getText();
			Assert.assertEquals(s.toString(), text);
			System.out.println("Quantity selected :" + s);
			System.out.println("Quantity in Cart :" + text);
			break;
		case 2:
			this.driver.findElement(By.id("a-autoid-6-announce")).click();
			this.driver.findElement(By.id("dropdown1_1")).click();
			this.driver.findElement(By.id("nav-cart")).click();
			text = this.driver.findElement(By.xpath(".//*[@id='a-autoid-6-announce']")).getText();
			Assert.assertEquals(s.toString(), text);
			System.out.println("Quantity selected :" + s);
			System.out.println("Quantity in Cart :" + text);
			break;
		case 3:
			this.driver.findElement(By.id("a-autoid-6-announce")).click();
			this.driver.findElement(By.id("dropdown1_2")).click();
			this.driver.findElement(By.id("nav-cart")).click();
			text = this.driver.findElement(By.xpath(".//*[@id='a-autoid-6-announce']")).getText();
			Assert.assertEquals(s.toString(), text);
			System.out.println("Quantity selected :" + s);
			System.out.println("Quantity in Cart :" + text);
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}

	}

	/**
	 * if the value of the object data was changed, it requires to change the
	 * expected value on the Assert
	 */
	@Test(priority = 2, dataProvider = "checkAddCart")
	public void f1(Integer s) {

		String strAmount = null;
		strAmount = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[3]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		String strAmount2 = strAmount.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		double amount = Double.parseDouble(strAmount2);
		double total = amount * s;
		Assert.assertEquals(102.00, total, 2);
	}

	/**
	 * if the value of the object data was changed, it requires to change the
	 * expected value on the Assert
	 */
	@Test(priority = 3, dataProvider = "checkAddCart")
	public void f2(Integer s) {

		String strAmount = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[3]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		String strCleanAmount = strAmount.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		double amount = Double.parseDouble(strCleanAmount);
		double total = amount * s;
		String strAmount2 = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[2]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		strCleanAmount = strAmount2.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		double amount2 = Double.parseDouble(strCleanAmount);
		String strAmount3 = this.driver
				.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[1]/div[4]/div[2]/div[2]/p[1]/span"))
				.getText();
		strCleanAmount = strAmount3.replaceAll("(?<=\\d),(?=\\d)|\\$", "");
		double amount3 = Double.parseDouble(strCleanAmount);

		double gtotal = total + amount2 + amount3;
		Assert.assertEquals(360.18, gtotal, 2);
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
