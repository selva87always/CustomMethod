package com.flipkart.custommethods;

public class AmazonCustomMethodMain extends BaseClass{

	public static void main(String[] args) {
		
		getDriver();
		openApplication("https://www.amazon.in/");
		CustomMenuNavigation.amazonMenuSubMenuClick("Mobiles, Computers", "Power Banks");
	}

}
