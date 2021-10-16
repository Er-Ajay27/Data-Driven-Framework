package com.ddf.test.LoginTest;

import org.testng.annotations.Test;

import com.ddf.base.BaseUI_v1;

public class loginTest_v1 extends BaseUI_v1 {

	@Test
	public void testOne() throws InterruptedException {
		
		invokeBrowser("chrome");
		openURL("https://www.rediff.com/");
		elementClick("//a[contains(text(),'Sign in')]");
		enterText("//input[@id='login1']","U S E R N A M E");
		Thread.sleep(2000);
		tearDown();
	}
	
	//Call a different browser - firefox
	@Test(dependsOnMethods="testOne")
	public void testTwo() {
		invokeBrowser("chrome");
		openURL("https://money.rediff.com/index.html");
		tearDown();
	}
	
	//Exercise - Call a different browser - Edge
	@Test(dependsOnMethods="testTwo")
	public void testThree() {
		invokeBrowser("chrome");
		openURL("https://shopping.rediff.com/");
		tearDown();
	}
}
