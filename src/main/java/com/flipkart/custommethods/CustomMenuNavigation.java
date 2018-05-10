package com.flipkart.custommethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomMenuNavigation extends BaseClass{
	
	static Actions action = new Actions(driver);
	static int pageEndIndex;
	static int pageStartIndex;
	static String pageNumberSet;
	public static void flipkartMenuSubMenuClick(String mainmenu,String strinsubmenu) {
		
		String menu="//span[text()='$']";
		String actualMenu=menu.replace("$", mainmenu);
		driver.findElement(By.xpath(actualMenu)).click();
		String actualSubMenu=menu.replace("$", strinsubmenu);
		WebElement submenu=driver.findElement(By.xpath(actualSubMenu));
		
		action.moveToElement(submenu).click();
		action.build().perform();
	}
	public static void amazonMenuSubMenuClick(String mainmenu,String strinsubmenu) {
		
		
		WebElement shopCategory=driver.findElement(By.id("nav-link-shopall"));
		action.moveToElement(shopCategory);
		action.build().perform();
		
		String menuText="//span[text()='$']";
		String actualMenuText=menuText.replace("$", mainmenu);
		WebElement actualMenu=driver.findElement(By.xpath(actualMenuText));
		action.moveToElement(actualMenu);
		action.build().perform();
		
		String actualSubMenu=menuText.replace("$", strinsubmenu);
		WebElement submenu=driver.findElement(By.xpath(actualSubMenu));
		action.moveToElement(submenu).click();
		action.build().perform();
	}
	public static void yahooPageNavigation(int pageNumber) throws InterruptedException {
		
		WebElement txtBoxYahooSearch=driver.findElement(By.id("yschsp"));
		txtBoxYahooSearch.clear();
		txtBoxYahooSearch.sendKeys("Selenium",Keys.ENTER);
		
		pageEndIndex = pageNumber * 10;
		pageStartIndex = pageEndIndex - 9;
		pageNumberSet = pageStartIndex + "-" + pageEndIndex;
		//System.out.println(pageNumberSet);
		String pageElement = "//a[@title='Results $']";
		String pageNumberLocator = pageElement.replace("$", pageNumberSet);

		Thread.sleep(2000);
		List<WebElement> listElements;
		listElements = driver.findElements(By.xpath(pageNumberLocator));

		if (pageNumber > 5) {

			do {

				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[text()='Next']")).click();
				System.out.println(driver.findElement(By.xpath("//strong")).getText());
				listElements = driver.findElements(By.xpath(pageNumberLocator));

			} while (listElements.isEmpty());
		}
		driver.findElement(By.xpath(pageNumberLocator)).click();

	}
}

