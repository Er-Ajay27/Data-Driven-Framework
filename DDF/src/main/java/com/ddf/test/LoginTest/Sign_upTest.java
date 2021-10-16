package com.ddf.test.LoginTest;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.ddf.base.BaseUISign_up;
import com.ddf.utils.ExtentReportManager;
import com.ddf.utils.TestDataProvider;

public class Sign_upTest extends BaseUISign_up {


ExtentReports report=ExtentReportManager.getReportInstance();
	
	
	@Test(dataProvider="getTestOneData")
	public void testOne(Hashtable<String, String> dataTable) throws InterruptedException, IOException {
		 logger = report.createTest("Test one");
		invokeBrowser("chrome");
		openURL("websiteURLforMoney");
		elementClick("signupBtn_Xpath");
		System.out.println("Full name: ");
		System.out.println(dataTable.get("Full_name"));
		enterText("fullName_Id",dataTable.get("Full_name"));
		enterText("email_Id", dataTable.get("email_id"));
		enterText("password_Id", dataTable.get("Password"));
		enterText("reTypePassword_Id", dataTable.get("RetypePass"));
		System.out.println("Day"+dataTable.get("day"));
		dropDownElement("day_Id",dataTable.get("day"));
		dropDownElement("date_Id", dataTable.get("date").toUpperCase());
		dropDownElement("year_Id", dataTable.get("year"));
		//dropDownElement("genderF_Xpath", dataTable.get("Gender"));
		elementClick("genderF_Xpath");
		dropDownElement("country_Id", dataTable.get("country"));
		dropDownElement("city_Id", dataTable.get("city"));
		//System.out.println("Username: dT.get(Col 1)"+"Ajay B Ingle");
		
		logger.log(Status.PASS,"Test case passed successfully");
		
		//Simulating failure below - its not actual failure 
		//also, image is dummy - we need to implement capturescreenshot function 
		//logger.log(Status.FAIL,"Test case failed");
		//logger.addScreenCaptureFromPath("D:\\worksoft\\screenshot_selenium.png");
		//takeScreenShotOnFailure();

		Thread.sleep(2000);
		
	}
	
	/*
	 * @Test public void testcreatePortfolio() {
	 * 
	 * elementClick("createBtn_Xpath"); clearText("createInputText_Xpath");
	 * enterText("createInputText_Xpath","MyportFolio");
	 * elementClick("createPortfolioBtn_Xpath"); tearDown(); }
	 */
	/*
	@Test
	public void testOne() throws InterruptedException, IOException {
		 logger = report.createTest("Test one");
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("signinBtn_Xpath");
		enterText("usernameTextbox_Xpath","U S E R N A M E");
		enterText("passwordTextbox_Id","l o n g - p a s s w o r d");
		logger.log(Status.PASS,"Test case passed successfully");
		
		//Simulating failure below - its not actual failure 
		//also, image is dummy - we need to implement capturescreenshot function 
		//logger.log(Status.FAIL,"Test case failed");
		//logger.addScreenCaptureFromPath("D:\\worksoft\\screenshot_selenium.png");
		//takeScreenShotOnFailure();

		Thread.sleep(2000);
		tearDown();
	}
	*/
	@AfterTest
	public void endReport() {
		report.flush();
	}
	
	//@Test(dependsOnMethods="testOne")
	public void testTwo() {
		invokeBrowser("chrome");
		openURL("websiteURL");
		
		//openURL("https://money.rediff.com/index.html");
		//test code to show next function usage - above code not changed to use properties file 
		tearDown();
	}
	
	//@Test(dependsOnMethods="testTwo")
	
	public void testThree() {
		invokeBrowser("chrome");
		//openURL("https://shopping.rediff.com/");
		//test code to show next function usage - above code not changed to use properties file
		tearDown();
	}
	
	//Below function not working at signin - need to check
	//@Test(dataProvider="getTestOneData")
		public void testOne_tryDP(Hashtable<String, String> dataTable) throws InterruptedException {
		//System.out.println(dataTable.get("Col1"));
		  //  logger = report.createTest("Enter UserName And Password in Rediff : " + dataTable.get("Col1"));
			invokeBrowser("chrome");
			openURL("websiteURL");
			elementClick("signinBtn_Xpath");
			//elementClick("signinBtn_Xpath");
			
			enterText("usernameTextbox_Xpath", dataTable.get("Col1"));
			Thread.sleep(2000);
			enterText("passwordTextbox_Id", dataTable.get("Col3"));		
			Thread.sleep(2000);
			tearDown();
		}

	
	
	@DataProvider
	public Object[][] getTestOneData(){
		return TestDataProvider.getTestData("Book2.xlsx", "Sheet1", "Test One");
	}
}
