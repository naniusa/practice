package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver ldriver) throws InterruptedException {
		this.driver=ldriver;
		Thread.sleep(3000);
	}
	
@FindBy(how=How.XPATH,using=".//*[contains(text(),'CRM')]")
WebElement CRM;

@FindBy(how=How.XPATH,using=".//*[contains(text(),'Add Contact')]")
WebElement AddContact;

public void ClickAddContact() {
	CRM.click();
	AddContact.click();
}
 public void VerifyPageLogin() {
	 CRM.isDisplayed();
	 
 }
}


