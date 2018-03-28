package silayetest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Premium_subscription  extends Base_Class

{

	public WebDriver obj;
	
	@Test()
	public void subscription() throws InterruptedException
	{
		
		obj.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		//obj.navigate().refresh();
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
		   }	
		   }
		
	}
	@Test()
	public void addnewstyle3() throws InterruptedException
	{
		 System.out.println("adding new style process upto 250 styles");
			
		 try {
			  WebElement element = (new WebDriverWait(obj,1)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
			  System.out.println("Element is present in web page");
		
	     int val;
	     for( val=51;val<=250;val++) // for basic subscription
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
		     Thread.sleep(20000);
		     
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
	
	
	
	
	@Test()
	public void techpacks_1() throws InterruptedException, AWTException, CloneNotSupportedException, IOException, FindFailed
	{
		    obj.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			obj.findElement(By.id("loaderfor"));
			
		    
			for(int i=1;i<=50;i++)  //for basic subscription
			
			{ 
				int x;
				   for(x=1;x<=50;x++) // loop applied for sikuli
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

		  Thread.sleep(3000);
		  
		  String buy_now = ".//*[@id='techsubmit']";
		  String xpath="//div/button";
		  
		//performing techpacks
		 WebElement btn = obj.findElement(By.xpath("//div/button"));
		 JavascriptExecutor js1 =(JavascriptExecutor)obj;
	     js1.executeScript("arguments[0].click();", btn);
		 System.out.println(" btn clicked");
		 
			
			if( obj.findElement(By.xpath(buy_now)).isDisplayed())
			               
			{        
				 obj.findElement(By.xpath(buy_now)).click();
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
								Thread.sleep(7000);
							    
							    WebElement btn2=obj.findElement(By.xpath("//input[@id='confirmButtonTop']"));
							    JavascriptExecutor js11 =(JavascriptExecutor)obj;
								   js11.executeScript("arguments[0].click();", btn2);
								Thread.sleep(2000);
								System.out.println("payment confirm ");
								Thread.sleep(12000);
								Thread.sleep(2000);
								
								obj.switchTo().window(parentwindow);
								 WebElement btn11 = obj.findElement(By.xpath("//div/button"));
								 JavascriptExecutor js111 =(JavascriptExecutor)obj;
							     js111.executeScript("arguments[0].click();", btn11);
								 System.out.println(" btn clicked");
								 break;
					   }
					}
			}
			
			else
			{
				System.out.println("buy option not found");
				break;
			}
	    Set<String> s1=obj.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		
		while(i1.hasNext())
		{
			String childwindow=i1.next();
			
			if(parentwindow.equalsIgnoreCase(childwindow))
			{
				obj.switchTo().window(childwindow);
				System.out.println("after switching win is-->" +obj.getTitle());
				Thread.sleep(20000);
                  Screen s=new Screen();
				  Pattern x2=new Pattern("F:\\silaye images\\ok_btn.PNG");				
				 Pattern x4=new Pattern("F:\\silaye images\\p1.PNG");
				 Pattern x5=new Pattern("F:\\silaye images\\save_btnPNG.PNG");
				  s.click(x2);
				Thread.sleep(2000);
				 s.setAutoWaitTimeout(50);
				 s.find(x4);
				 s.setAutoWaitTimeout(50);
				 s.type("a", KeyModifier.CTRL);
				 s.type(Key.BACKSPACE); 
				 s.type(x4,x+".xps");
				 s.setAutoWaitTimeout(50);
				 s.click(x4);
				 s.click(x5);
			     Thread.sleep(7000);
				 System.out.println("focused on popup win again");
				    Robot rb =new Robot();
				    //used for closing the popup window
				    rb.keyPress(KeyEvent.VK_ALT); 
				    rb.keyPress(KeyEvent.VK_F4);
				    rb.keyRelease(KeyEvent.VK_F4);
				    rb.keyRelease(KeyEvent.VK_ALT);
				    Thread.sleep(15000);
		         System.out.println("close works");
		         Thread.sleep(3000);
		        obj.switchTo().window(parentwindow);  // switch back to parent window
		       System.out.println("switchedback to parent window");
		       
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(5000);
			}
			}
		
	
				 
			}
			 
			  
	  break;
		    }
			
		 }
	
	
	
	 @BeforeTest //Pre condition
	  public void beforeTest() 
	  {
		 
		    String driverpath="C:\\Users\\admin\\Downloads\\geckodriver-v0.19.1-win32\\geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver", driverpath);
		    obj=new FirefoxDriver();
			obj.manage().window().maximize();
			
	  }
	
	
	
	
}
