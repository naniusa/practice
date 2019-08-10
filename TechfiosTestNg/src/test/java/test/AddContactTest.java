package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;
import util.XlsReader;

public class AddContactTest {
	XlsReader reader=new XlsReader("C://Users//ashf2//new//testng//TechfiosTestNg//Data//testngexcel.xlsx");
	String email=reader.getCellData("Sheet1", "Email", 1);
	String password=reader.getCellData("Sheet1", "Password", 2);
	String name =reader.getCellData("Sheet1", "FullName", 3);
	String company =reader.getCellData("Sheet1", "company", 4);
	String Email =reader.getCellData("Sheet1", "EmailAddress", 5);
	String phone =reader.getCellData("Sheet1", "Phone", 6);
	String address =reader.getCellData("Sheet1", "EmailAddress", 7);
	String city=reader.getCellData("Sheet1", "City", 8);
	String state =reader.getCellData("Sheet1", "State", 9);
	String zip =reader.getCellData("Sheet1", "Zip", 10);
	String country =reader.getCellData("Sheet1", "country", 11);
	
	@Test
	public void AddContact() throws InterruptedException {
		WebDriver driver=BrowserFactory.startBrowser("chrome","http://techfios.com/test/billing/?ng=login/");
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.LoginTechfios(email, password);
		HomePage home=PageFactory.initElements(driver,HomePage.class);
		home.VerifyPageLogin();
		home.ClickAddContact();
		AddContactPage contact=PageFactory.initElements(driver,AddContactPage.class);
	    contact.FillingUpTheAddressForm(email,company,Email,phone,address,city,state,zip,country);
		Thread.sleep(3000);
	driver.close();
	driver.quit();
	
	
	
	}

	

}
