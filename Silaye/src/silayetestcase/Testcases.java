/**
 * 
 */
package silayetestcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import silaye.Registeration;
import silaye.Silaye;

/**
 * @author admin
 *
 */
public class Testcases 
{
	 public static  WebDriver obj;
	 
	 
	@Test(enabled=false)
	public void verifylogin()
	{
		Silaye login = new Silaye(obj);
		
		login.typeusername();
		login.typepassword();
		login.loginbtn();
		
	}
	
	@Test()
	public void verifyregister()
	{
		
		Registeration register=new Registeration(obj);
		
		register.typefirstname();
		register.typelastname();
		register.email();
	    register.user();
		register.typepassword();
		register.confirmpassword();
		register.term1();
		register.term2();
		register.registerbtn();
		
		
	}
	
	
	
	
	 @BeforeTest
	  public void beforeTest () throws Exception 
	  {
		  
		    String driverpath="C:\\Program Files (x86)\\Safari\\SafariSetup.exe";
		    System.setProperty("webdriver.safari.driver", driverpath);
		    obj=new SafariDriver();
			obj.manage().window().maximize();
			//obj.get("http://52.7.92.49:8080/silaye/login");
			obj.get("http://52.7.92.49:8080/silaye/register");	   
			
	  }
	  
	
	
}
