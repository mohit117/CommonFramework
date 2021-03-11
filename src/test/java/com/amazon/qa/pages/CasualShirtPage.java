package com.amazon.qa.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;

public class CasualShirtPage extends BaseClass{

	
	
	public CasualShirtPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle()
	{
		extentLogger.info("Getting page title");
		return driver.getTitle();
	}
	
	
	
}
