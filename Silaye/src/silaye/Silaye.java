/**
 * 
 */
package silaye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author admin
 *
 */
public class Silaye 
{

	WebDriver obj;
	
	By username=By.xpath(".//*[@id='smg_email']");
	By password=By.xpath(".//*[@id='smg_password']");
	By loginbtn=By.id("submit");
	
	
	
	public Silaye(WebDriver obj)
	{
		this.obj=obj;
	}
	
	public void typeusername()
	{
		obj.findElement(username).sendKeys("nikita.gawande@pluraltechnology.com");
	}
	
	public void typepassword()
	{
		obj.findElement(password).sendKeys("Nikita@1994");	
	}
	
	
	public void loginbtn()
	{
		obj.findElement(loginbtn).click();
	}
	
}
