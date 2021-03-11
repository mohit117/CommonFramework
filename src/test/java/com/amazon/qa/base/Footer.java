package com.amazon.qa.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

	WebDriver driver;
	
	public Footer(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getAllFooterLinksForOnlineShopping()
	{
		BaseClass.extentLogger.info("Getting all links from footer");
		List<WebElement> onlineShoppingLinkLists = driver.findElements(By.xpath("//div[@class='desktop-shopLinks']/a"));
		return onlineShoppingLinkLists;
	}
	
	public void navigateToAllOnlineShoppingLinks()
	{
		ArrayList<WebElement> onlineLinks = (ArrayList<WebElement>) getAllFooterLinksForOnlineShopping();
		
		for(WebElement e : onlineLinks)
		{
			System.out.println(e.getAttribute("href"));
			//e.sendKeys(Keys.CONTROL +"t");
			e.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		}
		
		Set<String> allWindows = driver.getWindowHandles();
	
		System.out.println("Total window opens are " + allWindows.size());
	}
	
	public void HandleMultipleWindows()
	{
		Set<String> allWindows = driver.getWindowHandles();
		
		
	}
	

}
