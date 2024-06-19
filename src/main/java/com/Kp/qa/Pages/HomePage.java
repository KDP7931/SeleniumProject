package com.Kp.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Kp.qa.Base.AutoConstant;

public class HomePage implements AutoConstant 
{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='uid']")
	public WebElement Userid;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	WebElement Pass;
	
	@FindBy(how=How.XPATH, using="//input[@name='btnLogin']")
	public WebElement Login;
	
	@FindBy(how=How.XPATH, using="//input[@name='btnReset']")
	WebElement Reset;
	
	@FindBy(how=How.XPATH, using="//td//marquee[contains(.,'Welcome')]")
	public WebElement homepage_heading;
	
	public WebElement UserId() {
		return Userid;
	}
	
	public WebElement Password()
	{
		return Pass;
	}
	
	public void validLogin(String UserName, String Password) throws InterruptedException {
		UserId().clear();
		Userid.sendKeys(UserName);
		Pass.clear();
		Pass.sendKeys(Password);
		Login.click();
	}
	
	public String homePageHeading() {
		String homepagename = homepage_heading.getText();
		System.out.println("The homepage text is " + homepagename);
		return homepagename;
	}
}
