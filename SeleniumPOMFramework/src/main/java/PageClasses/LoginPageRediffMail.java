package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class LoginPageRediffMail extends PageBaseClass{

	
	

	public LoginPageRediffMail(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	
	}

	@FindBy(id = "login1")
	public WebElement usereName;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submitSign_button;

	public RediffMailPage doLogin(String userName, String pwd) {
		
		usereName.sendKeys(userName);
		logger.log(Status.PASS, "Entered the UserName : " + userName);
		//Commented below link, since its not required now
		//emailSubmit_button.click();
		//waitForPageLoad();
		//logger.log(Status.PASS, "Clicked the UserName Submit Buttton");
		password.sendKeys(pwd);
		logger.log(Status.PASS, "Entered the Password : " + pwd);
		System.out.println("Entered password");
		submitSign_button.click();
		waitForPageLoad();
		logger.log(Status.PASS, "Cliecked the Submit Login Button");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentPageTitle = driver.getTitle();
		if (currentPageTitle.equals("Indian stock markets: Login to Portfolio")){
			reportFail("Login is failed on Portfolio Login Page");
			Assert.fail("Login Failed");
		}
		RediffMailPage rediffMailPage = new RediffMailPage(driver, logger);
		PageFactory.initElements(driver, rediffMailPage);
		return rediffMailPage;
	}
	
	public void enterUser(String userName){
		usereName.sendKeys(userName);
		logger.log(Status.PASS, "Entered the UserName : " + userName);
	}
	

	public void enterPassword(String pwd){
		password.sendKeys(pwd);
		logger.log(Status.PASS, "Entered the Password : " + pwd);
	}
	
	public RediffMailPage submitLogin(){
		submitSign_button.click();
		logger.log(Status.PASS, "Cliecked the Submit Login Button");
		RediffMailPage rediffMailPage = new RediffMailPage(driver, logger);
		PageFactory.initElements(driver, rediffMailPage);
		return rediffMailPage;
	}
	
	

}
