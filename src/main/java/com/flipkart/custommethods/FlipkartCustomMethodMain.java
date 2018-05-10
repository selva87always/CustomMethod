package com.flipkart.custommethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class FlipkartCustomMethodMain extends BaseClass{

	public static void main(String[] args) {
		getDriver();
		openApplication("https://www.flipkart.com/");
		Actions action = new Actions(driver);
	    action.sendKeys(Keys.ESCAPE).build().perform();
		CustomMenuNavigation.flipkartMenuSubMenuClick("Electronics", "OPPO");
	}

}
