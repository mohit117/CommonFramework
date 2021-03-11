package com.amazon.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.CasualShirtPage;
import com.amazon.qa.pages.HomePage;

public class CasualShirtPageTest extends BaseClass{
	
	
	CasualShirtPage casualObj;
	
	@BeforeMethod
	public void setUp()
	{
		
		casualObj = new CasualShirtPage();
		
	}
	
	@Test
	public void validatePageUrl()
	{
		
		casualObj = topMenuObj.navigateToCasualShirts();
		Assert.assertEquals("https://www.myntra.com/men-casual-shirts", casualObj.getCurrentPageUrl());
		
	}
	
}
