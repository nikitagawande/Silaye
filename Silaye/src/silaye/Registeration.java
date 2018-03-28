/**
 * 
 */
package silaye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author admin
 *
 */
public class Registeration
{
	WebDriver obj;
	
	By firstname=By.xpath(".//*[@id='first_name']");
	By lastname=By.xpath(".//*[@id='last_name']");
	By email=By.xpath(".//*[@id='email']");
	By typeofuser=By.xpath(".//*[@id='user_role']");
	By password=By.xpath(".//*[@id='password']");
	By confirmpassword=By.xpath(".//*[@id='confirm_password']");
	By term1=By.xpath(".//*[@id='register-validate']/div[4]/div[1]/div/div/span");
	By term2=By.xpath(".//*[@id='register-validate']/div[4]/div[2]/div/div/span");
	By registerbtn=By.xpath(".//*[@id='register']");
	
	public Registeration(WebDriver obj)
	{
		this.obj=obj;
	}
	
	public void typefirstname()
	{
		obj.findElement(firstname).sendKeys("ritik");
	}
	
	public void typelastname()
	{
		obj.findElement(lastname).sendKeys("gawande");
	}
	
	public void email()
	{
		obj.findElement(email).sendKeys("nikita.gawande@pluraltechnology.com");
		
	}
	
	public void user()
	{
		Select  DropElement= new Select(obj.findElement(typeofuser));
 	    DropElement.selectByVisibleText("Designer");
		
	}
	
	public void typepassword()
	{
		obj.findElement(password).sendKeys("Nikita@123");
	}
	
	public void confirmpassword()
	{
		obj.findElement(confirmpassword).sendKeys("Nikita@123");
	}
	
	public void term1()
	{
		  WebElement radiobtn = obj.findElement(term1);
	 	  radiobtn.click();
	 	    
	
	}
	
	public void term2()
	{
		 WebElement radiobtn1 = obj.findElement(term2);
	 	 radiobtn1.click();
	}
	
	public void registerbtn()
	{
		obj.findElement(registerbtn).click();
	}
	
	
	
}
