package com.flipkart.custommethods;

public class YahooCustomMethodGoToPage extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		openApplication("https://in.search.yahoo.com/?guccounter=1");
		CustomMenuNavigation.yahooPageNavigation(3);
	}

}
