package silayetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Config 

{
	public static WebDriver obj;
	public Silaye silaye; 
	
	@BeforeSuite
	public void setUp()
	{
	    obj = new FirefoxDriver();
	}

	@AfterSuite
	public void tearDown(){

	    if (obj != null) {
	        obj.quit();
	    }
	}
	
}
