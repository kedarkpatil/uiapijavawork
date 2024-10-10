package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CountryPage extends BasePage{
	
	By title= By.cssSelector("div.store-countries-and-regions-list > div > div > div > div:nth-child(1) > a > div > div.sim-item-header  > div  > p");
	By coverage= By.cssSelector("div.store-countries-and-regions-list > div > div > div > div:nth-child(1) > a > div > div.sim-item-info > ul > li:nth-child(1) > div > p.value");
	By data=By.cssSelector("div.store-countries-and-regions-list > div > div > div > div:nth-child(1) > a > div > div.sim-item-info > ul > li:nth-child(2) > div > p.value");
	By validity= By.cssSelector("div.store-countries-and-regions-list > div > div > div > div:nth-child(1) > a > div > div.sim-item-info > ul > li:nth-child(3) > div > p.value");
	By price=By.cssSelector("div.store-countries-and-regions-list > div > div > div > div:nth-child(1) > a > div > div.sim-item-info > ul > li:nth-child(4) > div > p.value");
	
	
	
	public CountryPage(WebDriver driver)
	{
		super(driver);
	}
	public String getTitleText()
	{
		return getText(title);
	}
	public String getCoverageText()
	{
		return getText(coverage);
	}
	public String getDataText()
	{
		return getText(data);
	}
	public String getValidityText()
	{
		return getText(validity);
	}
	public String getPriceText()
	{
		return getText(price);
	}
	public String getText(By locator) 
	{
	      WebElement element = driver.findElement(locator);
	      return element.getText();
	}
}
