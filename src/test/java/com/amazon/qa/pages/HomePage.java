package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//span[@class='desktop-userTitle' and text()='Profile']")
	private WebElement profileLink;
	
	@FindBy(xpath="//a[text()='login / Signup']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[@class='desktop-userTitle' and text()='Wishlist']")
	private WebElement wishListLink;
	
	@FindBy(xpath="//span[@class='desktop-userTitle' and text()='Bag']")
	private WebElement bagLink;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage clickOnLogin()
	{
		Actions action = new Actions(driver);
		action.moveToElement(profileLink).build().perform();
		extentLogger.info("Clicking on login button");
		loginButton.click();
		
		return new LoginPage();
	}
	
	
	public String getPageTitle()
	{
		extentLogger.info("Getting page title");
		return driver.getTitle();
	}
	
	public boolean wishListAvailability()
	{
		extentLogger.info("Validating availability of Wishlist link");
		return wishListLink.isDisplayed();
	}
	
	public boolean bagAvailability()
	{
		extentLogger.info("Validating availability of Bag link");
		return bagLink.isDisplayed();
	}
	
	
}
