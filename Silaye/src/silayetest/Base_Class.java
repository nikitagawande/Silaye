package silayetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base_Class 

{
	public WebDriver obj;
	
	// WebDriver obj = new FirefoxDriver(); 

	    @BeforeSuite 
	    public void setup() throws Exception
	    { 
	    	//obj.manage().window().maximize();
	    	//obj.get("http://52.7.92.49:8080/silaye/register");
	    	//obj.get("http://demo.pluraltechinc.com:8080/silaye/login");
	    	
	    } 

	/*   @AfterSuite 
	    public void tearDown() throws Exception { 
	            obj.close(); 
	        }*/ 
	
	
}
