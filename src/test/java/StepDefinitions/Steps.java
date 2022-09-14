package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Scenario;

public class Steps {
	
	static ChromeDriver driver;
	static Pages.FirstPage firstpage;
	public static WebDriverWait wait ;
	
	@Before()
	public void startdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		firstpage =new Pages.FirstPage(driver);
		
		
	}
	
	

	@Then("the error msg appear {string}")
	public void the_error_msg_appear(String string) {

		Assert.assertEquals(driver.findElement(By.id("auth-email-missing-alert")).getText().trim(),string);

	}



	

	@Given("the user navigate to the registration page")
	public void the_user_navigate_to_the_registration_page() {
		
		firstpage.get_signin().click();
		wait.until(ExpectedConditions.visibilityOf(firstpage.get_createelement())).click();
		
		Assert.assertEquals(firstpage.get_titlerege().getText().trim(),"Konto erstellen");
		
		
		
		
	  
	}
	@When("the user type wrong email and click submit")
	public void the_user_type_wrong_email_and_click_submit() {
	driver.findElement(By.id("ap_customer_name")).sendKeys("asdasgdasgsadg");
	driver.findElement(By.id("continue")).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Then("the error msg appear")
	public void the_error_msg_appear() {
		
		Assert.assertEquals(driver.findElement(By.id("auth-email-missing-alert")).getText().trim(),"Geben Sie Ihre E-Mail-Adresse oder Mobiltelefonnummer ein");
		  
	}
	
	
	
	@Given("the user navigate to the registration page {int}")
	public void the_user_navigate_to_the_registration_page(Integer int1) {
	   System.out.println(int1);
	}
	@When("the user type wrong email and click submit {int}")
	public void the_user_type_wrong_email_and_click_submit(Integer int1) {
		System.out.println(int1);
	}
	@Then("the error msg appear {int}")
	public void the_error_msg_appear(Integer int1) {
		System.out.println(int1);
	}




	
@After()
	
	public void close(Scenario scenario) {
	
	if (scenario.isFailed()) {
		
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png","");
	}
	//try remove the wait to check the error of socet
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	
	driver.quit();


}


	






	
	
	

}
