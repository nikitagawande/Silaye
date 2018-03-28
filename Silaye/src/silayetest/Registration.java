package silayetest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration 
{
	public WebDriver obj;
	
	
	@Test()
	public void registration() throws InterruptedException
	{
		
		obj.get("http://52.7.92.49:8080/silaye/register");
		
		obj.findElement(By.xpath(".//*[@id='first_name']")).sendKeys("niks");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='last_name']")).sendKeys("gawande");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='email']")).sendKeys("tarunbagade20@gmail.com");
		Thread.sleep(2000);
		Select  DropElement= new Select(obj.findElement(By.xpath(".//*[@id='user_role']")));
 	    DropElement.selectByVisibleText("Designer");
 	    Thread.sleep(3000);
 	    
 	    obj.findElement(By.xpath(".//*[@id='password']")).sendKeys("Nikita@20");
 	    obj.findElement(By.xpath(".//*[@id='confirm_password']")).sendKeys("Nikita@20");
 	    
 	    WebElement radiobtn = obj.findElement(By.xpath(".//*[@id='register-validate']/div[4]/div[1]/div/div/span"));
 	    radiobtn.click();
 	    
 	    WebElement radiobtn1 = obj.findElement(By.xpath(".//*[@id='register-validate']/div[4]/div[2]/div/div/span"));
	    radiobtn1.click();
	    
	   // obj.findElement(By.xpath(".//*[@id='register']")).click();
	    
	    WebElement register= obj.findElement(By.xpath(".//*[@id='register']")); //double clicking the element 
	    register.click();
	    Thread.sleep(4000);
	    
		System.out.println("Registration Successfully");
	}
	
	@Test(dependsOnMethods={"registration"})
	public void gmail_validation() throws InterruptedException
	{
		obj.get("https://accounts.google.com");
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
		obj.manage().window().maximize();
 	
 	   obj.findElement(By.id("identifierId")).sendKeys("tarunbagade20@gmail.com");
 	   obj.findElement(By.className("CwaK9")).click();
 	   Thread.sleep(2000);
 	   
 	    obj.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Nikita@20");
	    obj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        obj.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
        obj.findElement(By.xpath(".//*[@id='gbwa']/div/a")).click();
 	    Thread.sleep(2000);
 	    obj.findElement(By.xpath("//*[@id='gb23']/span[1]")).click();
 	   Thread.sleep(5000);
 		
 	   java.util.List<WebElement> unreademail = obj.findElements(By.xpath("//*[@class='zF']"));
 	   System.out.println("checking msgs");

 	// Mailer name for which i want to check do i have an email in my inbox 
 	String MyMailer = "Registration Notification";

 	// real logic starts here
 	for(int i=0;i<unreademail.size();i++)
 	{
 	    if(unreademail.get(i).isDisplayed()==true)
 	    {
 	        // now verify if you have got mail form a specific mailer (Note Un-read mails)
 	        // for read mails xpath locator will change but logic will remain same
 	        if(unreademail.get(i).getText().equals(MyMailer))
 	        {
 	            System.out.println("Yes we have got mail from " + MyMailer);
 	            // also you can perform more actions here 
 	            // like if you want to open email form the mailer
 	             unreademail.get(i).click();
 	             System.out.println("msg clicked");
 	             Thread.sleep(2000);
 	             obj.findElement(By.linkText("Click Here To Activate")).click();
 	             System.out.println("clicked on Link");
 	             Thread.sleep(7000);
 	             
 	            String parent = obj.getWindowHandle();

 	           Set<String> pops=obj.getWindowHandles();
 	           {
 	           Iterator<String> it =pops.iterator();
 	           while (it.hasNext())
 	           {

 	               String popupHandle=it.next().toString();
 	               if(!popupHandle.contains(parent))
 	            	   
 	               {
 	               obj.switchTo().window(popupHandle);
 	               System.out.println("Popu Up Title: "+ obj.switchTo().window(popupHandle).getTitle());
 	               Thread.sleep(4000);
 	               obj.close();
 	              obj.switchTo().window(parent);
 	               break;
 	              
 	               }
 	           }
 	        }
 	        }
 	        else
 	        {
 	            System.out.println("No mail from " + MyMailer);
 	            Thread.sleep(8000);
 	        }
 	    }
	}
	
	}
	
	 @BeforeClass //Pre condition
	  public void beforeTest() 
	  {
		 
		    String driverpath="C:\\Users\\admin\\Downloads\\geckodriver-v0.19.1-win32\\geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver", driverpath);
		    obj=new FirefoxDriver();
			obj.manage().window().maximize();
			
	  }
	
      @AfterClass
	  public void afterTest() throws InterruptedException 
	  {
		  Thread.sleep(7000);
		  obj.close();
	  }
	  
	
}
