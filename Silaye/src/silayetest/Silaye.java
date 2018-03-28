package silayetest;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.verifier.exc.Utility;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xpath.operations.Bool;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.modules.thread.thread;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Silaye
{
	
	public WebDriver obj;
	
	
	@Test()
	public void login() throws InterruptedException  
	
	{
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.get("http://demo.pluraltechinc.com:8080/silaye/login");
	
		
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("tarunbagade20@gmail.com");
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
	
	
	@Test(dependsOnMethods={"addnewstyle2"})
	public void subscription_1() throws InterruptedException 
	
	{
		System.out.println("subscription =2");
		obj.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
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
		        WebDriverWait wait = new WebDriverWait(obj,80);
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
					Thread.sleep(2000);
					 Thread.sleep(7000);
					obj.switchTo().window(parentWindow);
					System.out.println("switching back to parent window");
		   }
		   }
		
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(15000);
		this.addnewstyle2();
		Thread.sleep(15000);
	}
	
	@Test(dependsOnMethods={"addnewstyle3"})
	public void subscription_2() throws InterruptedException 
	
	{
		System.out.println("subscription =3");
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
		        Thread.sleep(4000);
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
					Thread.sleep(2000);
					 Thread.sleep(5000);
					obj.switchTo().window(parentWindow);
					System.out.println("switched back to parent window");
					
		   }
		   }
		
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(15000);
		this.addnewstyle3();
		Thread.sleep(15000);
	}
	
	
	@Test(dependsOnMethods={"profile"})
	public void  addnewstyle1() throws InterruptedException
	{
		
		 System.out.println("adding new style process upto 10 styles");
		 
  /* try{*/
	  WebElement element = (new WebDriverWait(obj,50)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
	  System.out.println("Element is present in web page");
			  
	     int val;
	     for(val=1;val<=10;val++) // for free subscription
	    
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
		     Thread.sleep(25000);
		     
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(15000);
	    	  
	     }

  
   /*catch (Exception e) 
   
   {
	// TODO: handle exception
	   this.subscription_1();
	   Thread.sleep(8000);
}*/
}
	
	@Test(dependsOnMethods={"techpacks"})
	public void addnewstyle2() throws InterruptedException  
	{
		 System.out.println("adding new style process upto 50 styles");
			
		 /*try {
			  WebElement element = (new WebDriverWait(obj,1)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
			  System.out.println("Element is present in web page");*/

		 obj.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	     int val;
	     for( val=11;val<=12;val++) // for basic subscription
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
	    	  
		     if(val==12)
		     {
		     System.out.println(" process break ");
		     break;
		     }
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
	
	@Test(dependsOnMethods={"techpacks_1"})
	public void addnewstyle3() throws InterruptedException
	{
		 System.out.println("adding new style process upto 250 styles");
			
		/* try {
			  WebElement element = (new WebDriverWait(obj,5)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"))));
			  System.out.println("Element is present in web page");*/

		 obj.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 //obj.manage().window().setSize(new Dimension(1024,768));
			  Boolean iselementpresent= obj.findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button")).size()!=0;
			  if(iselementpresent==true)
			  {
		
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
		/* catch (Exception e)
		 {
			// TODO: handle exception
			 System.out.println("executing else part");
			 this.subscription_2();
		}*/
			  else 
				 {
					 System.out.println("executing else part");
					 this.subscription_2();
					 Thread.sleep(2000);
				}
	}
	
	@Test(dependsOnMethods={"addnewstyle2"})
	public void team_members() throws InterruptedException, IOException
	{
		
		obj.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		
	    WebElement element=(new WebDriverWait(obj, 50)).until(ExpectedConditions.elementToBeClickable(obj.findElement(By.linkText("Team Members"))));
		element.click();
		Thread.sleep(3000);
		WebElement addbtn=obj.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/a/button"));
		addbtn.click();
		Thread.sleep(2000);
		
/*	
	
		ArrayList<String> email=readexcelData(0);
		 
	
		 for(int i=0;i<=email.size();i++)
		 {
			    obj.findElement(By.id("email")).sendKeys(email.get(i));
			    Thread.sleep(2000);
				obj.findElement(By.id("emailsubmit")).click();
				WebElement btn=obj.findElement(By.id("emailsubmit"));
				btn.click();
				System.out.println("email sent");
				String value=obj.findElement(By.xpath("//*[@id='emailform']/div/div[1]/span")).getText();
				if(obj.findElement(By.xpath("//*[@id='emailform']/div/div[1]/span")).getText() != null)
				{
					  
					  Boolean iselementpresent=obj.findElement(By.id("emailsubmit")).equals(value);
					    if(iselementpresent==true)
					   {
					    	for(int j=1;j<=5;j++)
					    	{
						    System.out.println("element already available");
						     obj.findElement(By.xpath("//div["+j+"]/div/div[2]/div/button")).click();
						     Thread.sleep(3000);
						     obj.findElement(By.xpath("//div[2]/button")).click();
						     Thread.sleep(8000);
							 obj.navigate().refresh();
							 Thread.sleep(9000);
					    	}
					    	
						 
					   }
					    else
					    {
					    	System.out.println("break");
					    	break;
					    }
				}
				
			Thread.sleep(5000);
		    obj.findElement(By.id("email")).clear();
				
				
				
				
		 }
		 
		 
		 
		 
	}


	public ArrayList<String> readexcelData(int colNo) throws IOException
	{
		   FileInputStream fi = new FileInputStream("C:\\Users\\admin\\Documents\\team_members.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook(fi);
		   XSSFSheet sheet =workbook.getSheetAt(0);
	
		

		    Iterator<Row> rowIterator = sheet.iterator();
		    
		   // rowIterator.next();
		     
		    ArrayList<String> list= new ArrayList<String>();
		    
		     while (rowIterator.hasNext()) 
		    	 
		     {
		    	 Row row = rowIterator.next(); 
		    	 Iterator<Cell> cellIterator = row.cellIterator();
		            while(cellIterator.hasNext()) 
		            {

		                Cell cell = cellIterator.next();
		                
		                System.out.print(cell.getStringCellValue() + ":\t"); //displaying details in console
		    	 
		    	list.add( rowIterator.next().getCell(colNo).getStringCellValue());
		    	 
		     }
		
		// TODO Auto-generated method stub
		            
		     }
		     
		    return list;
			   
	}
	

	public static  void main(String[] args) throws InterruptedException, IOException 
	{

		 Silaye data=new Silaye();
		 data.team_members();

	}*/
	
  for(int i=1;i<=3;i++)
	{
	obj.findElement(By.xpath("//div["+i+"]/div/div[2]/div/button")).click();
	Thread.sleep(8000);
	obj.findElement(By.xpath("//div[2]/button")).click();
	Thread.sleep(8000);
	obj.navigate().refresh();
	Thread.sleep(9000);
	}
	
	    obj.findElement(By.id("loaderfor"));
	    WebElement dashboard= obj.findElement(By.linkText("Dashboard"));
	    dashboard.click();
	    Thread.sleep(3000);
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
	
	
	@Test(dependsOnMethods={"team_members"})
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
		  
         
		 //performing techpacks
		 WebElement btn = obj.findElement(By.xpath("//div/button"));
		 JavascriptExecutor js1 =(JavascriptExecutor)obj;
	     js1.executeScript("arguments[0].click();", btn);
		 System.out.println(" btn clicked");
		 
		 Boolean iselementpresent =obj.findElements(By.xpath(".//*[@id='techsubmit']")).size()!=0;
			if(iselementpresent == true)
			{
				this.Buy_option();
				
			}
			else
			{
				System.out.println("not present");
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
				Thread.sleep(10000);
				
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
				    Thread.sleep(8000);
		         System.out.println("close works");
		         Thread.sleep(2000);
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
			
		
	@Test(dependsOnMethods={"techpacks_1"})
	public void Buy_option() throws InterruptedException, FindFailed, AWTException, CloneNotSupportedException, IOException
	{
		
		
		 obj.findElement(By.xpath(".//*[@id='techsubmit']")).click();
		 
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
					    JavascriptExecutor js11 =(JavascriptExecutor)obj;
						   js11.executeScript("arguments[0].click();", btn2);
						Thread.sleep(2000);
						System.out.println("payment confirm ");
						Thread.sleep(12000);
						Thread.sleep(2000);
						
						obj.switchTo().window(parentWindow);
						WebElement btn11 = obj.findElement(By.xpath("//div/button"));
						JavascriptExecutor js111 =(JavascriptExecutor)obj;
						js111.executeScript("arguments[0].click();", btn11);
						System.out.println(" btn clicked");
						
			   }
			}		
		
		
	}
	
		 
	/*@Test(priority=8)
	public void notification_request() throws InterruptedException, AWTException
	{
		this.login_sourcing_user();
		Thread.sleep(5000);
		obj.findElement(By.xpath("html/body/div[1]/div[2]/ul[1]/li[5]/a")).click();
		Thread.sleep(3000);
		obj.findElement(By.linkText("Yes")).click();
		this.logout();
		Thread.sleep(7000);
		this.login();
		Thread.sleep(7000);

	}
	
	
	
	@Test(priority=9)
	public void assignstyle() throws InterruptedException
	{
		Thread.sleep(7000);
		obj.findElement(By.xpath("//div[2]/div/div[2]/div[3]/a[2]/span")).click();
		Thread.sleep(3000);
		Select  DropElement= new Select(obj.findElement(By.xpath(".//*[@id='select-user1']")));
  	    DropElement.selectByVisibleText("Apurva Pangal");
  	    Thread.sleep(3000);
		obj.findElement(By.xpath(".//*[@id='sendrequest1']")).click();//sending invitation
		Thread.sleep(5000);
		
		obj.findElement(By.xpath("//div[@id='modal_confirm']/div[2]/div/div[3]/button")).click();
		Thread.sleep(4000);
	}
	
	
	@Test(priority=10)
	public void logout() throws AWTException, InterruptedException
	{
		obj.findElement(By.linkText("")).click();
		obj.findElement(By.id("mb-signout"));
	  
	    WebElement logout= obj.findElement(By.xpath("//li[2]/a/span"));
	    logout.click();
	    
        obj.findElement(By.linkText("Yes")).click();
		Thread.sleep(5000);
		System.out.println("logout1-->designer user");
		
	}   
	
	@Test(priority=11)
	public void login_sourcing_user() throws InterruptedException
	{
      
		obj.get("http://demo.pluraltechinc.com:8080/silaye/login");
		Thread.sleep(5000);
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("apurva.pangal@pluraltechnology.com");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("Nikita@20");
		Thread.sleep(2000);

		obj.findElement(By.id("submit")).click();;
		Thread.sleep(5000);
	    WebElement m2m= obj.findElement(By.id("submit"));
	    m2m.click();
	    System.out.println("login1 successfully-->Sourcing User");
		
	}
	
	@Test(priority=12)
	public void accepting_request() throws InterruptedException, AWTException
	
	{
		
		WebElement element=(new WebDriverWait(obj, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[23]/div/div[2]/div[3]/a[2]/span")));
		element.click();
		Thread.sleep(3000);
		
		obj.findElement(By.xpath(".//*[@id='tab1']/div[3]/div[3]/div[1]/button")).click(); //accepting the request//
		Thread.sleep(5000);
		
		obj.findElement(By.xpath("//div[@id='modal_confirm']/div[2]/div/div[3]/button")).click(); //closing the dialogue box
		Thread.sleep(4000);
		
	}
	
	@Test(priority=13)
	public void sourcing_logout() throws InterruptedException
	{
		Thread.sleep(4000);
		obj.findElement(By.linkText(""));
		obj.findElement(By.id("mb-signout"));
	    System.out.println("signout way");
	    WebElement logout= obj.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[3]/a/span"));
	    logout.click();
	    System.out.println("signout1 from -->sourcing user");
	    
        try {
			obj.findElement(By.linkText("Yes")).click();
		} catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(7000);
		
		
		
	}
	
	
	@Test(priority=14)
	public void pay() throws InterruptedException
	{
		this.login();
		System.out.println("login2--> designer user");
		Thread.sleep(7000);
	    //obj.findElement(By.id("loaderfor")).click();
	    System.out.println("jumped in 7th test");
	  
	        WebElement element=obj.findElement(By.xpath("//div[2]/div/div[2]/div[3]/a[2]/span"));
	        JavascriptExecutor js =(JavascriptExecutor)obj;
		    js.executeScript("arguments[0].click();", element);
			Thread.sleep(9000);

		Thread.sleep(5000);
		
	//	WebDriverWait wait=new WebDriverWait(obj,30);
		
		String parentHandle = obj.getWindowHandle(); // get the current window handle
		obj.findElement(By.xpath("//a[contains(text(),'Pay now')]")).click(); // click some link that opens a new window
        Thread.sleep(30000);
        Set<String> windowHandles = obj.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) 
			
		{
		   String handle = iterator.next();
		   
		   if (!handle.contains(parentHandle))
		   {
        
		
		    obj.switchTo().window(handle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		   
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
				Thread.sleep(15000);
				 obj.navigate().refresh();
				 Thread.sleep(2000);
			    
		  
		}
		}
	   obj.switchTo().window(parentHandle); 
	   obj.findElement(By.xpath("//div[@id='modal_confirm']/div[2]/div/div[3]/button")).click(); //closing the dialogue box
		Thread.sleep(4000);
		
	}
	
	@Test(priority=15)
	public void payment_status() throws AWTException, InterruptedException
	{
		Thread.sleep(5000);
		 obj.findElement(By.id("loaderfor"));
		 System.out.println("clicked1");
		obj.findElement(By.linkText(""));
		 System.out.println("clicked2");
		obj.findElement(By.id("mb-signout"));
		 System.out.println("clicked3");
	  
	    WebElement logout= obj.findElement(By.xpath("//li[2]/a/span"));
	    JavascriptExecutor js1 =(JavascriptExecutor)obj;
	    js1.executeScript("arguments[0].click();", logout);
	    System.out.println("clicked4");
	    Thread.sleep(4000);
	    
        obj.findElement(By.linkText("Yes")).click();
		Thread.sleep(5000);
		System.out.println("logout2_designer");
		Thread.sleep(5000);
		
		this.login_sourcing_user();
		Thread.sleep(5000);
		System.out.println("login2_sourcing user");
		
		    WebElement element=obj.findElement(By.xpath("//div[23]/div/div[2]/div[3]/a[2]/span"));
	        JavascriptExecutor js =(JavascriptExecutor)obj;
		     js.executeScript("arguments[0].click();", element);
			Thread.sleep(9000);
			
		obj.findElement(By.xpath("//*[@id='tab1']/div[3]/div[3]/div/button")).click();
		System.out.println("payment status----->yes");
		Thread.sleep(2000);
		
		
		obj.findElement(By.xpath("//*[@id='tab1']/div[3]/div[3]/div/button")).click();
		System.out.println("status------>completed");
		Thread.sleep(5000);
		
		 obj.findElement(By.xpath("//div[@id='modal_confirm']/div[2]/div/div[3]/button")).click(); //closing the dialogue box
		 Thread.sleep(4000);
		
		this.logout();
		 
	}
	*/
	
	@Test(enabled=false)
	public void registration() throws InterruptedException
	{
		obj.get("http://52.7.92.49:8080/silaye/register");
		
		obj.findElement(By.xpath(".//*[@id='first_name']")).sendKeys("piyu");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='last_name']")).sendKeys("trivedi");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='email']")).sendKeys("pgawande884@gmail.com");
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
	    
		System.out.println("Registeratiion Successfully");
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
 	             Thread.sleep(2000);
 	             obj.findElement(By.linkText("Click Here To Activate")).click();
 	             System.out.println("clicked on Link");
 	             Thread.sleep(7000);
 	            break;
 	        }
 	        else
 	        {
 	            System.out.println("No mail from " + MyMailer);
 	            Thread.sleep(8000);
 	        }
 	    }
	}
	
	}
	
	
	@Test(enabled=false)
	public void invalid() throws InterruptedException
	{
		
		obj.get("http://52.7.92.49:8080/silaye/login");
		
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("nikita.gawande@.com");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("Nikita@20");
		Thread.sleep(2000);

		obj.findElement(By.id("submit")).click();
		System.out.println("*********");
		Thread.sleep(7000);
		
		 WebElement m2m= obj.findElement(By.id("submit"));
		    m2m.click();
		
		
	}
	
	@Test(enabled=false)
	public void change_password() throws InterruptedException 
	{
		
		 WebElement changepwdbtn= obj.findElement(By.xpath("//div[2]/ul/li[3]/a"));// click on button
	     changepwdbtn.click();
		
	     obj.findElement(By.xpath("//input[@id='current_password']")).sendKeys("Nikita@20");
	     Thread.sleep(2000);
	     obj.findElement(By.xpath("//input[@id='new_password']")).sendKeys("Nikita@1994");
	     Thread.sleep(2000);
	     obj.findElement(By.xpath("//input[@id='confirm_password']")).sendKeys("Nikita@1994");
	     Thread.sleep(2000);
	     obj.findElement(By.id("submit_changepswd")).click();
	     
	     WebElement alertbox= obj.findElement(By.xpath("//div[2]/ul/li[3]/a"));//clicking on button again
	     alertbox.click();
	     Thread.sleep(2000);
	     obj.findElement(By.xpath("//div[7]/div/button")).click();
         Thread.sleep(9000);
	     	     
         
	}
	
	
	
	  @org.testng.annotations.BeforeClass //Pre condition
	  public void beforeTest() 
	  {
		 
		    String driverpath="C:\\Users\\admin\\Downloads\\geckodriver-v0.19.1-win32\\geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver", driverpath);
		    obj=new FirefoxDriver();
			obj.manage().window().maximize();
			
	  }
	  

	/*  @AfterClass
	  public void afterTest() 
	  {
		  obj.close();
	  }
	  */
}
