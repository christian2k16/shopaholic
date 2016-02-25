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

import com.sqa.CM.util.helper.SelUtil;
import com.sqa.CM.util.helper.SelUtil.STRATEGY;

public class ShopaholicEbayTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@DataProvider
	public Object[][] AddCartTest() {
		return new Object[][] {
				// TODO Modify Data
				new Object[] { "NEW Electric EG1 Dark Knight Blue ski snowboard goggles +lens 2014 Msrp$100" } };
	}

	/**
	 * This test will navigate through the dropdown menu from the top of the
	 * Screen to a particular item (Sporting Goods). Select one of the images on
	 * the home page of those items. Add the first item on the list.
	 */
	@Test
	public void AddItem() {
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.id("userid")).clear();
		this.driver.findElement(By.id("userid")).sendKeys("mallaprechristian@gmail.com");
		this.driver.findElement(By.id("pass")).clear();
		this.driver.findElement(By.id("pass")).sendKeys("dummy777");
		SelUtil.superClick(this.driver,
				"csi:sgnBt:Sporting Goods:area[alt=\"End-of-Season Clearance | Up to 70% off Snowboards, skis, and more | Free Shipping | Shop now\"]:img[alt=\"NEW Electric EG1 Dark Knight Blue ski snowboard goggles +lens 2014 Msrp$100\"]:isCartBtn_btn"
						.split(":"),
				new SelUtil.STRATEGY[] { STRATEGY.ID, STRATEGY.ID, STRATEGY.TEXT, STRATEGY.CSS, STRATEGY.CSS,
						STRATEGY.ID });
	}

	@DataProvider
	public Object[][] AddWatchListTest() {
		return new Object[][] {
				// TODO Modify Data
				new Object[] { "a.vip.item-title" } };
	}

	@DataProvider
	public Object[][] AddWishListTest() {
		return new Object[][] {
				// TODO Modify Data
				new Object[] { "ttl_172102243053" } };
	}

	/**
	 * Validate that the item on AddItem() is added to your cart.
	 */
	@Test(priority = 1, dataProvider = "AddCartTest")
	public void f1(String s) {
		this.driver.findElement(By.id("gh-cart-i")).click();
		this.driver.findElement(By.linkText(s)).click();
	}

	/**
	 * Validate that the item is in the user's account as that item being
	 * watched
	 */
	@Test(priority = 2, dataProvider = "AddWatchListTest")
	public void f2(String s) {
		this.driver.findElement(By.id("gh-eb")).click();
		this.driver.findElement(By.linkText("My eBay")).click();
		this.driver.findElement(By.cssSelector("a.vip.item-title")).click();
	}

	/**
	 * Add the particular item to your watchlist and validate that the item was
	 * added
	 */
	@Test(priority = 3, dataProvider = "AddWishListTest")
	public void f3(String s) {
		this.driver.findElement(By.id("gh-eb")).click();
		this.driver.findElement(By.linkText("My eBay")).click();
		this.driver.findElement(By.linkText("Wish list")).click();
		this.driver.findElement(By.id("ttl_172102243053")).click();
		this.driver.findElement(By.cssSelector("html")).click();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://www.ebay.com/";
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
