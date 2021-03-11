package com.amazon.qa.tests;

import java.util.ArrayList;
import java.util.Set;

import org.apache.http.impl.io.SocketOutputBuffer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.CasualShirtPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class HomePageTest extends BaseClass{

	HomePage hpObj;
	LoginPage loginObj;
	CasualShirtPage casualObj;
	
	
	@BeforeMethod
	public void setUp()
	{
		hpObj = new HomePage();
	}
	
	@Test
	public void validatePageTitle()
	{
		Assert.assertEquals("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra", hpObj.getPageTitle());
	}
	
	@Test
	public void verifyNavigationToLoginPage()
	{
		loginObj = hpObj.clickOnLogin();
		
		Assert.assertEquals("Myntra", loginObj.getPageTitle());
		
	}
	
	@Test
	public void validateAvailabilityOfBagLink()
	{
		Assert.assertTrue(hpObj.bagAvailability(), "Element is not available on Home Page" );
	
	}
	
	@Test
	public void validateAvailabilityOfWishListLink()
	{
		Assert.assertTrue(hpObj.wishListAvailability(), "Element is not available on Home Page" );
		
	}
	
	@Test
	public void validateNavigationToCasualShirtCategory()
	{
		casualObj = topMenuObj.navigateToCasualShirts();
		Assert.assertEquals("Casual Shirts for Men - Buy Casual Shirts for Men Online in India | Myntra", casualObj.getPageTitle());
		
	}
	
	@Test
	public void validateNavigationToMenCategory()
	{
		extentLogger.info("Navigating to mens category");
		topMenuObj.goToMenCategory();
		extentLogger.info("Validating current url");
		Assert.assertEquals("https://www.myntra.com/shop/men", hpObj.getCurrentPageUrl());
	}
	
	@Test
	public void validateFooterLinksSizeFromHomePage()
	{
		ArrayList<WebElement> onlineLinks = (ArrayList<WebElement>) footerObj.getAllFooterLinksForOnlineShopping();
		Assert.assertEquals(7, onlineLinks.size()); //validating total url in footer	
	}
	
	@Test
	public void validateNavigationToAllOnlineShoppingLinksFromHomePage()
	{
	
		footerObj.navigateToAllOnlineShoppingLinks();
		
		
	}
}
