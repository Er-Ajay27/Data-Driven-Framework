package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClasses.LandingPage;

import PageClasses.LoginPageRediffMail;
import PageClasses.MoneyPage;
import PageClasses.MyPorfolioPage;
import PageClasses.PortFolioLoginPage;
import PageClasses.RediffMailPage;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import utilities.TestDataProvider;

public class MailTests extends BaseTestClass{
	
	LandingPage landingPage;
	LoginPageRediffMail loginPage; 
	RediffMailPage rediffmailpage;
	
	@Test(dataProvider="getOpenPortfolioTestData", groups={"Regression", "LoginTest" })
	public void writeMailTest(Hashtable<String, String> testData) throws InterruptedException{
		logger = report.createTest(" Rediff Mail  : " + "sending Mail");
		
		invokeBrowser("chrome");
		PageBaseClass pageBase= new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenApplication();
		loginPage = landingPage.clickrediffmailLink();
		rediffmailpage = loginPage.doLogin(testData.get("UserName"), testData.get("Password"));
		Thread.sleep(2000);
		rediffmailpage.clickWriteEmail();
		
		Thread.sleep(2000);
		
		rediffmailpage.typeMail_Id(testData.get("MailId"));
		rediffmailpage.enterSubject_box(testData.get("Subject"));
		Thread.sleep(2000);
		
		pageBase.switchtoFrame(driver, "//iframe[@class='cke_wysiwyg_frame cke_reset']");
		rediffmailpage.clickMailbody(testData.get("body"));
		Thread.sleep(2000);
		pageBase.switchtomainContent(driver);
		rediffmailpage.clickSendBtn();
		Thread.sleep(3000);
		rediffmailpage.verifyMailsent(driver, "//span[contains(text(),'Welcome Mail')]");
		
		Thread.sleep(3000);
		
		
//		rediffmailPage.getTitle();
	}

		@DataProvider
		public Object[][] getOpenPortfolioTestData(){
			return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "RediffMail");
		}
}
