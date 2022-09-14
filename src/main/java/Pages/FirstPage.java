package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends PageBase {

	public FirstPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@class='nav-line-1-container']")
	WebElement signin;
	@FindBy(id="createAccountSubmit")
	WebElement createaccount;
	@FindBy(xpath="//*[@class='a-spacing-small']")
	WebElement titlereg;
	
	
	public  WebElement get_signin() {
		return signin;
	}
	public void clickonsignin() {
		signin.click();
	}
	public  WebElement get_createelement() {
		return createaccount;
	}
	public  WebElement get_titlerege() {
		return titlereg;
	}
	
}
