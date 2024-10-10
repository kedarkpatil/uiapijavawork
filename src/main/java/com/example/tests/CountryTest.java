package com.example.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.CountryPage;
import com.example.pages.HomePage;


public class CountryTest extends BaseTest {
	private HomePage hmpg;
	private CountryPage cntrypg;
	
	@Test
    public void test() throws InterruptedException
    {
		  CountryPage cntrypg = new CountryPage(driver);
		  HomePage hmpg=new HomePage(driver);
		  hmpg.navigateToCntry();
		  
		  Assert.assertEquals("Moshi Moshi", cntrypg.getTitleText());
	      Assert.assertEquals("Japan", cntrypg.getCoverageText());
	      Assert.assertEquals("1 GB", cntrypg.getDataText() );
	      Assert.assertEquals("7 Days", cntrypg.getValidityText() );
	      Assert.assertEquals("4.50 €", cntrypg.getPriceText());
		  
    }
}	
