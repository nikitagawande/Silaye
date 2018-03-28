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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Trex 
{
public WebDriver obj;
	
	
	@Test()
	public void login() throws InterruptedException  
	
	{
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.get("http://demo.pluraltechinc.com:8080/silaye/login");
	
		
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("pgawande884@gmail.com");
		Thread.sleep(4000);
		obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("Nikita@20");
		Thread.sleep(4000);

		obj.findElement(By.id("submit")).click();
		Thread.sleep(5000);
	    WebElement m2m= obj.findElement(By.id("submit"));// finds the previously hidden element
	    m2m.click();
	    System.out.println("login successfully--> Designer User");
	    System.out.println(obj.getTitle());
	    Thread.sleep(5000);
	    
	}
	

	@Test(dependsOnMethods={"login"})
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
 	    Thread.sleep(9000);
 	    System.out.println("profile set");
 	   
 	    obj.findElement(By.id("loaderfor"));
	    WebElement dashboard= obj.findElement(By.linkText("Dashboard"));
	    dashboard.click();
	    Thread.sleep(3000);
	     
		}
		catch (Exception e) 
		{
			
			System.out.println("switched to addnewstyle1 ");
			this.addnewstyle1();
			Thread.sleep(7000);
		}
		
 	    
	}
	
	

	
	@Test(dependsOnMethods={"profile"})
	public void  addnewstyle1() throws InterruptedException
	{
		 obj.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		 System.out.println("adding new style process upto 10 styles");

			  
	     int val;
	     for(val=1;val<=4;val++) // for free subscription
	    
	     {
	    	 Boolean iselementpresent= obj.findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button")).size()!=0;
			  if(iselementpresent==true)
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

			  else 
				 {
					 System.out.println("executing else part");
					// this.subscription_1();
					 Thread.sleep(2000);
				}
			  break;
  
			  
}
	
	/*@Test(dependsOnMethods={"techpacks"})
	public void addnewstyle2() throws InterruptedException  
	{
		 System.out.println("adding new style process upto 50 styles");
			
		 try {
			  WebElement element = (new WebDriverWait(obj,1)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
			  System.out.println("Element is present in web page");

		 obj.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	     int val;
	     for( val=11;val<=50;val++) // for basic subscription
	     {
	    	 Boolean iselementpresent= obj.findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button")).size()!=0;
			  if(iselementpresent==true)
			  {
		
	    	 System.out.println("val = "+val);
	    	 WebElement addnewstyle = obj.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"));
			 JavascriptExecutor js =(JavascriptExecutor)obj;
		     js.executeScript("arguments[0].click();", addnewstyle);
		     
	    	 String value = String.valueOf(val);
	    	 System.out.println("value =" +value);
	    	 Thread.sleep(4000);
	    	 
		     obj.findElement(By.id("sly_style_name")).sendKeys("Sample-"+value);//for entering values
		     System.out.println("here");
		     
		     obj.findElement(By.id("stylesubmit")).click();//saving the values
		     System.out.println("click on save style");
		     Thread.sleep(20000);
		     
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(15000);
	    	  
		     if(val==50)
		     System.out.println(" process break ");
		     break;
		   
		    
	       }
			  
			  else 
				 {
					 System.out.println("executing else part");
					 this.subscription_1();
					 Thread.sleep(2000);
				}
			 
	}
}
	
	@Test(dependsOnMethods={"addnewstyle1"})
	public void techpacks() throws InterruptedException, AWTException, CloneNotSupportedException, IOException, FindFailed
	{
		    obj.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
			obj.findElement(By.id("loaderfor"));
			 
			for(int i=1;i<=3;i++)  //for free subscription
		
			{ 
				int x;
				   for(x=1;x<=3;x++) // loop applied for sikuli
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
		   
		//performing techpacks
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
		     Thread.sleep(9000);
		
			}
			
		}
	 }
	  break;
	}
			
 }
	*/
}
}
