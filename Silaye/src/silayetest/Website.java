package silayetest;


import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.thoughtworks.selenium.Selenium;

public class Website<IWebElement> 
{

	 public static  WebDriver obj;
	 
	 
	@Test(priority=1) 
	 public void login() throws InterruptedException 
	 
	 {
		 
		obj.get("http://52.7.92.49:8080/silaye/login");
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("pgawande884@gmail.com");
		obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("Nikita@20");
		Thread.sleep(2000);
		
		obj.findElement(By.id("submit")).click();
	    WebElement loader= obj.findElement(By.id("submit"));// finds the previously hidden element
	    loader.click();
		Thread.sleep(15000);
	
	 }
	
	@Test(enabled=false)
	public void profile() throws InterruptedException, IOException
	
	{
	
    try{
			
	    System.out.println("Element present");
		System.out.println("current url is"+obj.getCurrentUrl());
	
		Thread.sleep(4000);
		WebElement m2m= obj.findElement(By.xpath("//input[@id='contactNumber']"));// finds the previously hidden element
	    m2m.sendKeys("8482884782");
	    
		Select  DropElement= new Select(obj.findElement(By.xpath(".//*[@id='timezonesel']")));
 	    DropElement.selectByVisibleText("(GMT-07:00) Arizona");
 	    Thread.sleep(3000);
 	    
	    WebElement addpicturebtn= obj.findElement(By.xpath(".//*[@id='files']"));
	    Thread.sleep(2000);
	   
	    JavascriptExecutor js =(JavascriptExecutor)obj;
	    js.executeScript("arguments[0].click();", addpicturebtn);
	   
	    Runtime.getRuntime().exec("H:\\AutoIT\\addpicturebtn.exe"); //AutoIT script
	    Thread.sleep(5000);	    	      
	    System.out.println("popup");
	    Thread.sleep(2000);
 	 
 	   obj.findElement(By.name("smg_registration_number")).sendKeys("123");
 	   obj.findElement(By.name("smg_website")).sendKeys("xyz.com");
 	   
 	   WebElement addbusinesslogo= obj.findElement(By.id("filename1"));
	   Thread.sleep(2000);
	   JavascriptExecutor js1 =(JavascriptExecutor)obj;
	   js1.executeScript("arguments[0].click();", addbusinesslogo);
	   Runtime.getRuntime().exec("H:\\AutoIT\\businesslogo.exe");
	   Thread.sleep(7000);	
	   
	   obj.findElement(By.name("smg_yearsinbusiness")).sendKeys("2016");
	   WebElement nextbtn=obj.findElement(By.linkText("Next"));
	   nextbtn.click();
	   Thread.sleep(2000);
	   obj.findElement(By.id("address")).sendKeys("Baner");
	   obj.findElement(By.id("city")).sendKeys("pune");
	   obj.findElement(By.id("state")).sendKeys("maharashtra");
	   obj.findElement(By.id("zipcode")).sendKeys("411038");
	   Select  DropElement1= new Select(obj.findElement(By.id("country")));
	    DropElement1.selectByVisibleText("India");
	    Thread.sleep(2000);
	    
	    Select  DropElement2= new Select(obj.findElement(By.id("product")));
	    DropElement2.selectByVisibleText("Online");
	    Thread.sleep(2000);
	    
	    WebElement radiobtn = obj.findElement(By.id("smg_status"));
 	    radiobtn.click();
 	    
 	    Thread.sleep(9000);
 	    
		
 	   
 	   
 	 /*
 	  // signatureWebElement.click();
 	   
 	 
 	 
	    
       
 	 //Create an action sequence
       
       Actions builder = new Actions(obj);
       WebElement signatureWebElement =obj.findElement(By.id("signatur"));
       JavascriptExecutor js11 =(JavascriptExecutor)obj;
	    js11.executeScript("arguments[0].click();", signatureWebElement);
	    Thread.sleep(2000);
       System.out.println("signature");
	   org.openqa.selenium.interactions.Action drawAction = builder.moveToElement(signatureWebElement,20,20)  
       //signatureWebElement is the element that holds the signature element you have in the DOM
                 .clickAndHold()
                 .moveByOffset(480,280)
                // .click()
                 .moveByOffset(550,300)
                 .release()
                 .build();
             drawAction.perform();
             System.out.println("signature drawn");
             */
             
             
 	  WebElement finish=obj.findElement(By.linkText("Finish"));
 	    finish.click();
 	    Thread.sleep(2000);
 	    
 	    obj.findElement(By.id("loaderfor"));
	    WebElement dashboard= obj.findElement(By.linkText("Dashboard"));
	    dashboard.click();
	    Thread.sleep(3000);
	     
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("switched to add new style ");
			this.subscription();
		}
		
 	    
	}
	
	@Test(enabled=false)
	public void  addnewstyle() throws InterruptedException
	{
		
		 System.out.println("adding new style process");
		 
 try {
	  WebElement element = (new WebDriverWait(obj,1)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
	  System.out.println("Element is present in web page");
			  
	     int val;
	     for(val=1;val<=10;val++) // for free subscription
	     //for( val=11;val<=50;val++) // for basic subscription
	     {
	    	 System.out.println("val = "+val);
	    	 WebElement addnewstyle = obj.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"));
		     JavascriptExecutor js =(JavascriptExecutor)obj;
		     js.executeScript("arguments[0].click();", addnewstyle);
		     
		    
	    	 String value = String.valueOf(val);
	    	 System.out.println("value =" +value);
	    	 Thread.sleep(2000);
	    	 
		     obj.findElement(By.id("sly_style_name")).sendKeys("Sample-"+value);
		     System.out.println("here");
		     Thread.sleep(3000);
		     
		     obj.findElement(By.id("stylesubmit")).click();
		     System.out.println("click on save style");
		     Thread.sleep(15000);
		     
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(15000);
	    	  
	     }
	    
 }
 
 catch (Exception e) 
 {
	 System.out.println("executing else part");
	 this.subscription();
 }
	    
}
	
	@Test(enabled=false)
	public void subscription() throws InterruptedException 
	
	{
		obj.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		WebElement element=(new WebDriverWait(obj, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe")));
		JavascriptExecutor js =(JavascriptExecutor)obj;
	     js.executeScript("arguments[0].click();", element);
	
		obj.findElement(By.xpath(".//*[@id='submit']")).click(); //upgrade now btn
		//Thread.sleep(25000);
		String parentWindow = obj.getWindowHandle();
		Set<String> windowHandles = obj.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) 
			
		{
		   String handle = iterator.next();
		   
		   if (!handle.contains(parentWindow))
		   {
		        // Switch to popup and close it
		        obj.switchTo().window(handle);
		        // Perform required action in popup
		        WebDriverWait wait = new WebDriverWait(obj,50);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("injectedUl")));
				
				               
		        System.out.println("switch to frame");
				
				obj.findElement(By.id("email")).sendKeys("ushadevi.kadali@pluraltechnology.com");
				Thread.sleep(2000);
				obj.findElement(By.id("password")).sendKeys("cheppanu11");
				Thread.sleep(2000);
			
				obj.findElement(By.id("btnLogin")).click(); // click some link that opens a new window
				System.out.println("login btn");
				Thread.sleep(10000);
				
				    obj.switchTo().window(handle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
					System.out.println("switch to window");
					Thread.sleep(5000);
				    
				    WebElement btn2=obj.findElement(By.xpath("//input[@id='confirmButtonTop']"));
				    JavascriptExecutor js1 =(JavascriptExecutor)obj;
					   js1.executeScript("arguments[0].click();", btn2);
					Thread.sleep(2000);
					System.out.println("payment confirm ");
					Thread.sleep(12000);
					/* obj.navigate().refresh();
					 Thread.sleep(2000);*/
					Thread.sleep(2000);
					//this.addnewstyle();
				
		   }
		    	    
		    	   // obj.switchTo().window(subWindowHandler); 
			
		 	
	}
	
		 
		

	}
	
	
	
	
	
	
	@Test(enabled=false)
	public void add_new_style() throws InterruptedException
	{
		 System.out.println("adding new style process");
			
		 try {
			  WebElement element = (new WebDriverWait(obj,1)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
			  System.out.println("Element is present in web page");
		
	    int val;
	     for( val=11;val<=50;val++) // for basic subscription
	     {
	    	 System.out.println("val = "+val);
	    	 WebElement addnewstyle = obj.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"));
			 JavascriptExecutor js =(JavascriptExecutor)obj;
		     js.executeScript("arguments[0].click();", addnewstyle);
		     
	    	 String value = String.valueOf(val);
	    	 System.out.println("value =" +value);
	    	 Thread.sleep(2000);
	    	 
		     obj.findElement(By.id("sly_style_name")).sendKeys("Sample-"+value);//for entering values
		     System.out.println("here");
		     
		     obj.findElement(By.id("stylesubmit")).click();//saving the values
		     System.out.println("click on save style");
		     Thread.sleep(15000);
		     
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(9000);
	    	  
	     }
		 }
		 catch (Exception e)
		 {
			// TODO: handle exception
			 System.out.println("executing else part");
			 this.subscription();
		}
	   
	}
		
	
	@Test(priority=2)
	public void techpacks() throws InterruptedException, AWTException, CloneNotSupportedException, IOException, FindFailed
	{
		
		    obj.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			obj.findElement(By.id("loaderfor"));
			
		    
			for(int i=1;i<=10;i++)  //for free subscription
		
			{ 	
				for(int x=1;x<=5;x++)
				{
					
				//hover over the editstyle btn
				Actions action = new Actions(obj);
				
				
				//WebElement btn1 = obj.findElement(By.xpath("//div["+i+"]/div/div[2]/div[3]/a/span"));
				WebElement btn1 = obj.findElement(By.xpath("//div[3]/a"));
				action.moveToElement(btn1).build().perform();
				String value=String.valueOf(i);
				
				obj.findElement(By.xpath("//div[3]/a")).sendKeys(value);
				System.out.println("value is-->"+value);
				
			
				
			// WebElement element=obj.findElement(By.xpath("//div["+i+"]/div/div[2]/div[3]/a/span"));
			 WebElement element = obj.findElement(By.xpath("//div[3]/a"));
			 System.out.println("value of i -->"+i);
			 JavascriptExecutor js =(JavascriptExecutor)obj;
		     js.executeScript("arguments[0].click();", element);
		  
		    System.out.println("clicked");
		    Thread.sleep(7000);
		    
		   
		   String parentwindow=obj.getWindowHandle();
			  System.out.println("before switching win is-->"+obj.getTitle());
			  
			  WebElement btn = obj.findElement(By.xpath("//div/button"));
				 JavascriptExecutor js1 =(JavascriptExecutor)obj;
			     js1.executeScript("arguments[0].click();", btn);
				 System.out.println(" btn clicked");
				
					Set<String> s1=obj.getWindowHandles();
					Iterator<String> i1=s1.iterator();
					
					while(i1.hasNext())
					{
						
						String childwindow=i1.next();
						
						if(parentwindow.equalsIgnoreCase(childwindow))
						{
							obj.switchTo().window(childwindow);
							System.out.println("after switching win is-->" +obj.getTitle());
		    	
				    	Thread.sleep(10000);
				    	Screen s=new Screen();
						// Pattern x1=new Pattern("F:\\silaye images\\Capture.PNG");
						// Pattern x2=new Pattern("F:\\silaye images\\ok_btn.PNG");
						// Pattern x3=new Pattern("F:\\silaye images\\x1.PNG");
						 Pattern x4=new Pattern("F:\\silaye images\\p1.PNG");
						 Pattern x5=new Pattern("F:\\silaye images\\save_btnPNG.PNG");
						 
						 //s.find(x1);
						// s.click(x2);
						// s.find(x3);
						 s.find(x4);
						 s.type(x4,x+".xps");
						 s.setAutoWaitTimeout(50);
						 s.click(x4);
						 s.click(x5);
					
							   Thread.sleep(3000);
							   
							 //  obj.switchTo().window(childwindow);
							   System.out.println("focused on popup win again");
							   
							   Robot rb1 =new Robot();
						           //used for closing the popup window
						    rb1.keyPress(KeyEvent.VK_ALT); 
						    rb1.keyPress(KeyEvent.VK_SPACE);
						    rb1.keyPress(KeyEvent.VK_F4);
						    rb1.keyRelease(KeyEvent.VK_F4);
						    rb1.keyRelease(KeyEvent.VK_SPACE);
						    rb1.keyRelease(KeyEvent.VK_ALT);
						    
						
				     	  //  obj.switchTo().window(parentwindow);
						    
						     Thread.sleep(5000);
						     obj.findElement(By.id("loaderfor"));
						     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
						     dashboard.click();
						     Thread.sleep(5000);
						
						
						}
					
					}
				 
			
		   break;
			}
				}		
      }
					
	
				  
			
	 
			
		
     
	
	
	
	
	
	
	@Test(enabled=false)
	public void logout()
	{
		WebDriverWait wait1=new WebDriverWait(obj, 20);
		obj.findElement(By.linkText("Log Out")).click();
		
	}
	
	@Test(enabled=false)
	public void invalid() throws InterruptedException
	{
		obj.get("http://52.7.92.49:8080/silaye/login");
		obj.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("");
		Thread.sleep(2000);
	
		//obj.findElement(By.xpath("//form[@id='login-validate']/div[3]/div[2]/button")).click();
		obj.findElement(By.id("submit")).click();
		System.out.println("*********");
		Thread.sleep(7000);
		
		 WebElement m2m= obj.findElement(By.id("submit"));// finds the previouslly hidden element
		    m2m.click();
		
	
	}
	
	
	@Test(enabled=false)
	public void registration() throws InterruptedException
	{
		obj.get("http://52.7.92.49:8080/silaye/register");
		//obj.findElement(By.linkText("Create an account")).click();
		obj.findElement(By.xpath(".//*[@id='first_name']")).sendKeys("priyanka");
		obj.findElement(By.xpath(".//*[@id='last_name']")).sendKeys("gawande");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='email']")).sendKeys("pgawande884@gmail.com");
		
		Select  DropElement= new Select(obj.findElement(By.xpath(".//*[@id='user_role']")));
 	    DropElement.selectByVisibleText("Designer");
 	    Thread.sleep(3000);
 	    
 	    obj.findElement(By.xpath(".//*[@id='password']")).sendKeys("Nikita@20");
 	    obj.findElement(By.xpath(".//*[@id='confirm_password']")).sendKeys("Nikita@20");
 	    
 	    WebElement radiobtn = obj.findElement(By.xpath(".//*[@id='register-validate']/div[4]/div[1]/div/div/span"));
 	    radiobtn.click();
 	    
 	    WebElement radiobtn1 = obj.findElement(By.xpath(".//*[@id='register-validate']/div[4]/div[2]/div/div/span"));
	    radiobtn1.click();
	    
	    WebElement register= obj.findElement(By.xpath(".//*[@id='register']")); //double clicking the element 
	    register.click();
	    Thread.sleep(4000);
	    
	}
	
	 
	
	@Test(enabled=false)
	public void gmail_validation() throws InterruptedException
	{
		obj.get("https://accounts.google.com");
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
		obj.manage().window().maximize();
 	
 	   obj.findElement(By.id("identifierId")).sendKeys("pgawande884@gmail.com");
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
 	             obj.findElement(By.linkText("Click Here To Activate")).click();
 	             System.out.println("clicked on Link");
 	             
 	            break;
 	        }
 	        else
 	        {
 	            System.out.println("No mail from " + MyMailer);
 	        }
 	    }
	}
	
	}
	
	
	@Test(enabled=false)
	public void style() throws InterruptedException
	{
		Thread.sleep(5000);
		 Thread.sleep(5000);
		        
		 //finding element is present or not
		 
		for(int i=32;i<=35;i++)
		{
		    for(int j=2;j<=5;j++)
		    {
		     System.out.println("value of i--->"+i);
		    String xpath="//a[@href='http://52.7.92.49:8080/silaye/style/editstylepage/"+i+"/SLY00"+i+"']";
		    Boolean iselementpresent=obj.findElements(By.xpath(xpath)).size()!=0;
		    if(iselementpresent==true)
		   {
			  System.out.println("element present");
			  obj.findElement(By.xpath(xpath)).click();
			
		   }
		   else 
		   {
			   System.out.println("value of j--->"+j);
			    String linktext="(//a[@href='http://52.7.92.49:8080/silaye/designer?page="+j+"'])[2]";
			    
			   obj.findElement(By.xpath(linktext)).click();
			   System.out.println("next page");
			   Thread.sleep(7000);
		   }
			 
		continue;
		  
		    }
		   break;
		}
		    
		    Thread.sleep(4000);
		    obj.findElement(By.xpath("//button[2]")).click(); //click on techpack btn
		    
	}
	
	
  @BeforeTest
  public void beforeTest () throws Exception 
  {
	  
	    String driverpath="F:\\Selenium Data\\New folder\\chromedriver_win32\\chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", driverpath);
	    obj=new ChromeDriver();
		obj.manage().window().maximize();
		
		
  }
  
  /*
  @AfterTest
  public void afterTest() 
  {
	//  obj.close();
  }*/
	
}
