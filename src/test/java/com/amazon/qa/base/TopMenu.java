package com.amazon.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.amazon.qa.pages.CasualShirtPage;

public class TopMenu {

	WebDriver driver;
	
	public TopMenu(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void goToMenCategory() {
		
	driver.findElement(By.xpath("//a[@href='/shop/men' and @data-type='navElements']")).click();
	

	}

	public void goToWomenCategory() {

		driver.findElement(By.xpath("//a[@href='/shop/women' and @data-type='navElements']")).click();
		
	}

	public void goToKidsCategory() {

	}

	public void goToOffersCategory() {

	}

	public void goToHomeAndLivingCategory() {

	}

	public void goToProfile() {

	}

	public void goToWishList() {

	}

	public void goToBag() {

	}

	public void goToHomePage() {

	}
	
	public CasualShirtPage navigateToCasualShirts()
	{
		Actions action = new Actions(driver);
		BaseClass.extentLogger.info("Navigating to Mens category");
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Men' and @data-type='navElements']"))).build().perform();
		BaseClass.extentLogger.info("Clicking on casual shirt link");
		driver.findElement(By.xpath("//a[text()='Casual Shirts']")).click();
		
		return new CasualShirtPage();

	}

	

}
