package silayetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Web1 
{

	 public static  WebDriver obj;
	 
		@Test
		public void login() throws InterruptedException
		{
			//obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			obj.get("http://52.7.92.49:8080/silaye/login");
			
			obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("nikita.gawande@pluraltechnology.com");
			Thread.sleep(2000);
			obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("Nikita@1994");
			Thread.sleep(2000);

			
			//obj.findElement(By.id("submit")).click();;
			//Thread.sleep(5000);
		    WebElement m2m= obj.findElement(By.id("submit"));// finds the previously hidden element
		    m2m.click();
		    System.out.println("login successfully");
			
			
		}
		

	 
	 
		 @BeforeTest
		  public void beforeTest () throws Exception 
		  {
			  
			    String driverpath="C:\\Program Files (x86)\\Safari\\SafariSetup.exe";
			    System.setProperty("webdriver.safari.driver", driverpath);
			    obj=new SafariDriver();
				obj.manage().window().maximize();
				//obj.get("www.google.com");
				
			   
				
		  }
		  
		
		 
		 
	}

