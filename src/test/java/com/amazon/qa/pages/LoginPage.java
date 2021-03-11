package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath = "//div[@class='welcome-header' and text()='Login ']")
	private WebElement loginLabel;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		extentLogger.info("Getting page title");
		return driver.getTitle();
	}
	
}
