package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pom.LoginPage;





public class BaseClass {
	
	public static WebDriver driver;
	PropertyfileUtility putil = new PropertyfileUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	

	
	@BeforeSuite
	public void beforeSuitConfig() {
		Reporter.log("---Data base connection establishes---");
	}
	
	@BeforeClass(groups = {"smoke","Regerassion"})
	public void beforeClassConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReaddataFromPropertyFile("browser");
		String URL = putil.toReaddataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		WebDriver driver = null;
		Reporter.log("Browser got launch", true);

		wutil.ToMaximize(driver); 
		wutil.WaitForElement(driver);
		driver.get(URL);
	Reporter.log("navigated to login page", true);

	}

	@BeforeMethod(groups = {"smoke","Regerassion"})
	public void beforeMethodConfig() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String USERNAME = putil.toReaddataFromPropertyFile("username");
		String PASSWORD = putil.toReaddataFromPropertyFile("password");

		lp.getUsertextfield().sendKeys(USERNAME);
		lp.getUsertextfield().sendKeys(PASSWORD);
		lp.getLoginbutton().click();
		Reporter.log("login sucessfullt", true);

	}

	@AfterMethod(groups = {"smoke","Regerassion"})
	public void afterMethodConfig() {
	//	HomePage hp = new HomePage(driver);
	//	wutil.ToMoveToElement(driver, hp.getLogoutlink());
	//	hp.getLogoutbutton().click();
		Reporter.log("logout sucsessfully",true);
	}

	@AfterClass(groups = {"smoke","Regerassion"})
	public void afterClass() {
		Reporter.log("Browser closed secssesfully", true);
		driver.quit();
		Reporter.log("browser close sucsessfully", true);

	}

	@AfterSuite(groups = {"smoke","Regerassion"})
	public void afterSuitConfig() {
		Reporter.log("---database connection disconnected--", true);
	}
}
	
	
	
	 


