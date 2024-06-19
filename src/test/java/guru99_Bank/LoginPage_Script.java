package guru99_Bank;


import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kp.qa.Base.BaseClass;
import com.Kp.qa.Pages.HomePage;
import com.Kp.qa.Util.Utilites;
import com.Kp.qa.config.PropertyFileData;
import com.aventstack.extentreports.Status;

public class LoginPage_Script extends BaseClass
{
	static PropertyFileData propertyFile; 
	HomePage homepages;
	WebDriverWait wait;
	String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    String EXPECT_ERROR = "User or Password is not valid";
	
	@Test(enabled=true)
	public void TC_001() throws Exception {
		test = reports.createTest("TC_001:Verify that the User is able to Login with Valid Credentials");
		homepages = new HomePage(driver);
		wait = new WebDriverWait(driver, ExplicitWaitTime);
		homepages.validLogin(UserName, Password);
		test.log(Status.PASS, "Enter the user name and password : " + UserName);
		wait.until(ExpectedConditions.visibilityOf(homepages.homepage_heading));
		String homepage = homepages.homePageHeading();
		assertEquals(homepage, "Welcome To Manager's Page of Guru99 Bank");
		test.log(Status.PASS, "Successfully validated home page :" + homepage);
		
	}
	
	@Test
	public void TC_002() throws Exception {
		test = reports.createTest("TC_002:Verify that the User is able to Login with all posible Data from Excel file");
		homepages = new HomePage(driver);
		Utilites util=new Utilites();
		wait = new WebDriverWait(driver, ExplicitWaitTime);
		
		  String excelFilePath = System.getProperty("user.dir") + File.separator + "Excel" + File.separator + "LoginData.xlsx";
	        String sheetName = "Data";
	        String[][] loginData = util.getDataFromExcel(excelFilePath, sheetName);

	        for (int i = 0; i < loginData.length; i++) {
	            String userName = loginData[i][0];
	            String password = loginData[i][1];
	            
	            // Perform login
	            homepages.validLogin(userName, password);
	            try { 
	                Alert alt = driver.switchTo().alert();
	                String actualBoxTitle = alt.getText(); // get content of the Alert Message
	                alt.accept();
	                Assert.assertTrue(actualBoxTitle.contains(EXPECT_ERROR), "Login failed for Invalid user: " + userName);
	            	test.log(Status.PASS, "Successfully validated Error Message for Invalid User[" + i + "] :" + actualBoxTitle);
	            } catch (NoAlertPresentException ex) { 
	                String actualTitle = driver.getTitle();
	                Assert.assertTrue(actualTitle.contains(EXPECT_TITLE), "Login successful for Valid user: " + userName);
	                test.log(Status.PASS, "Successfully validated Welcome Message :" + actualTitle);
	            }
		
		
	}
}
	
	
	@Test(dataProvider="provideLoginData", dataProviderClass = Utilites.class)
	  public void TC_003(String username, String password) throws Exception {
        test = reports.createTest("TC_003: Verify that the User is able to Login with DataProvider Annotation");
        homepages = new HomePage(driver);
        wait = new WebDriverWait(driver, ExplicitWaitTime);

        // Perform login
        homepages.validLogin(username, password);

        try {
            Alert alt = driver.switchTo().alert();
            String actualBoxTitle = alt.getText(); // get content of the Alert Message
            alt.accept();
            Assert.assertTrue(actualBoxTitle.contains(EXPECT_ERROR), "Login failed for Invalid user: " + username);
            test.log(Status.PASS, "Successfully validated Error Message for user: " + username + " : " + actualBoxTitle);
        } catch (NoAlertPresentException ex) {
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(EXPECT_TITLE), "Login successful for Valid user: " + username);
            test.log(Status.PASS, "Successfully validated Welcome Message for user: " + username + " : " + actualTitle);
        }
    }

}
