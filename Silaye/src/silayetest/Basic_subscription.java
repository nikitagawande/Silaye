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

public class Basic_subscription 
{
	public WebDriver obj;
	
	@Test()
	public void login() throws InterruptedException  
	
	{
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//obj.get("http://demo.pluraltechinc.com:8080/silaye/login");
	
		
		obj.findElement(By.xpath(".//*[@id='smg_email']")).sendKeys("luvableniki14337@gmail.com");
		Thread.sleep(2000);
		obj.findElement(By.xpath(".//*[@id='smg_password']")).sendKeys("Nikita@20");
		Thread.sleep(2000);

		obj.findElement(By.id("submit")).click();
		Thread.sleep(5000);
	    WebElement m2m= obj.findElement(By.id("submit"));// finds the previously hidden element
	    m2m.click();
	    System.out.println("login successfully--> Designer User");
	    Thread.sleep(5000);
	    
	}
	


	@Test()
	public void process1() throws InterruptedException
	{
		
		//obj.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
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
					Thread.sleep(2000);
					obj.switchTo().window(parentWindow);
		   }	
		   }
		
		     obj.findElement(By.id("loaderfor"));
		     WebElement dashboard= obj.findElement(By.linkText("Dashboard")); //clicking on dashboard link
		     dashboard.click();
		     Thread.sleep(9000);
	}
	
	
	@Test()
	public void subscription_1() throws InterruptedException 
	
	{
		            this.process1();
		            Thread.sleep(5000);
					this.addnewstyle2();
		
	}
	
	@Test()
	public void addnewstyle2() throws InterruptedException
	{
		 System.out.println("adding new style process upto 50 styles");
			
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
			 this.subscription_1();
		}
	   
	}
	


@Test()
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
		
	
@Test(dependsOnMethods={"techpacks_1"}, alwaysRun=true)
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
					
					//obj.switchTo().window(parentwindow);
					WebElement btn11 = obj.findElement(By.xpath("//div/button"));
					JavascriptExecutor js111 =(JavascriptExecutor)obj;
					js111.executeScript("arguments[0].click();", btn11);
					System.out.println(" btn clicked");
					
		   }
		}		
	
	
}

	 
@Test()
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



@Test()
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


@Test()
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

@Test()
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

@Test()
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

@Test()
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


@Test()
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
			/* obj.navigate().refresh();
			 Thread.sleep(2000);*/
		    
	  
	}
	}
   obj.switchTo().window(parentHandle); 
   obj.findElement(By.xpath("//div[@id='modal_confirm']/div[2]/div/div[3]/button")).click(); //closing the dialogue box
	Thread.sleep(4000);
	
}

@Test()
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




}
