package com.sqa.CM.auto.demo;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EbaySampleTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://signin.ebay.com/";
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

	@Test
	public void testEbaySample() throws Exception {
		this.driver.get(this.baseUrl
				+ "/ws/eBayISAPI.dll?SignOutConfirm&ru=&i=.287900097000970008300037000870003900108000530012300030");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.id("sgnBt")).click();
		this.driver.findElement(By.id("gh-ac")).click();
		this.driver.findElement(By.id("gh-ac")).clear();
		this.driver.findElement(By.id("gh-ac")).sendKeys("nb2 2k16");
		this.driver.findElement(By.id("gh-btn")).click();
		this.driver.findElement(By.cssSelector("#item41a4e74603 > h3.lvtitle > a.vip")).click();
		this.driver.findElement(By.cssSelector("span.vi-atw-txt")).click();
		this.driver.findElement(By.id("gh-shop-a")).click();
		this.driver.findElement(By.linkText("Shoes")).click();
		this.driver
				.findElement(By
						.xpath("//img[@alt='Alpine Swiss Mens Ankle Boots Dressy Casual Leather Lined Dress Shoes Lace up NW']"))
				.click();
		this.driver.findElement(By.cssSelector("span.vi-atw-txt")).click();
		this.driver.findElement(By.cssSelector("span.vi-atw-txt")).click();
		this.driver.findElement(By.cssSelector("span.vi-atw-txt")).click();
		new Select(this.driver.findElement(By.id("msku-sel-1"))).selectByVisibleText("Size 9");
		this.driver.findElement(By.xpath("//div[@id='vi_main_img_fs']/ul/li[11]")).click();
		new Select(this.driver.findElement(By.id("msku-sel-2"))).selectByVisibleText("Black");
		this.driver.findElement(By.xpath("//div[@id='vi_main_img_fs']/ul/li[11]")).click();
		this.driver.findElement(By.cssSelector("span.vi-atw-txt")).click();
		new Select(this.driver.findElement(By.id("gh-cat"))).selectByVisibleText("Baby");
		this.driver.findElement(By.id("gh-btn")).click();
		this.driver.findElement(By.linkText("Toys for Babies")).click();
		this.driver.findElement(By.cssSelector("div.title")).click();
		this.driver.findElement(By.cssSelector("span.clwn-main-txt")).click();
		this.driver.findElement(By.name("title")).clear();
		this.driver.findElement(By.name("title")).sendKeys("mycollections");
		this.driver.findElement(By.xpath("//button[@type='button']")).click();
		this.driver.findElement(By.id("collectItem")).click();
		this.driver.findElement(By.xpath("//button[@type='button']")).click();
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
