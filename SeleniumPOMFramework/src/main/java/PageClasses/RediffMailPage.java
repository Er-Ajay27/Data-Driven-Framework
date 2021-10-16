package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class RediffMailPage extends PageBaseClass{
	
	
	public RediffMailPage(WebDriver driver, ExtentTest logger){
		super(driver, logger);
	}
	
	@FindBy(xpath ="//li[@class='rd_write']")
	WebElement writeMaillink;
	
	@FindBy(xpath="//input[@id='TO_IDcmp2']")
	WebElement mailIdtext_box;
	@FindBy(xpath="//input[@class='rd_inp_sub rd_subject_datacmp2']")
	WebElement subject_box;
	
	@FindBy(xpath="//a[@class='send_ng_compo rd_btn_cmp_send']")
	WebElement sendBtn;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement mailbody;
	//WebElements of RediffMail Page
	//Operation of Rediffmail Page
	
	public void clickWriteEmail(){
		writeMaillink.click();
		logger.log(Status.PASS, "Cliecked the WriteEmail Button");
	}
	
	public void typeMail_Id(String mailId){
		mailIdtext_box.sendKeys(mailId);
		logger.log(Status.PASS, "MailId Entered Succesfully");
	}

	public void enterSubject_box(String sub) {
		subject_box.sendKeys(sub);
		logger.log(Status.PASS, "Subject Entered Succesfully");
	}
	
	public void clickSendBtn() {
		sendBtn.click();
		logger.log(Status.PASS, "Cliecked the Send Button");
	}
	
	public void clickMailbody(String body) {
		mailbody.sendKeys(body);
		logger.log(Status.PASS, "Mail Body Entered Succesfully");
	}
	
	public void verifyMailsent(WebDriver driver, String xpath) {
		//span[contains(text(),'Welcome Mail')]
		WebElement sub = driver.findElement(By.xpath(xpath));
		
		if(sub.isDisplayed()) {
			System.out.println("Mail Sent Successfully");
			logger.log(Status.PASS, "Mail Sent Succesfully");
		}
		else {
			System.out.println("Mail did not sent Successfully");
			logger.log(Status.FAIL, "Mail Sent Unsuccesfully");
		}
		
		
	}
	public void getTitle(){
		
	}
}
