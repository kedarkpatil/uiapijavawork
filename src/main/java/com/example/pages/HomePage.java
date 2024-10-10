package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
	
	private  By searchBox = By.xpath("//input[@data-testid='search-input']");
	private  By japanSel =  By.xpath("//ul[@class='countries-list position-absolute']//li[2]");
	private  By acceptBtn =  By.xpath("//button[text()='ACCEPT']");
	private  By dontallowBtn =  By.xpath("//button[contains(text(),'DON')]");
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void navigateToCntry() throws InterruptedException
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(acceptBtn));
		driver.findElement(acceptBtn).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(dontallowBtn));
		driver.findElement(dontallowBtn).click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		driver.findElement(searchBox).click();
		driver.findElement(searchBox).sendKeys("Japan");
		Thread.sleep(3000);
		driver.findElement(japanSel).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
		
	}
	

}
