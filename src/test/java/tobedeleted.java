import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tobedeleted {
	static ChromeDriver driver;
	
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		Pages.FirstPage firstpage =new Pages.FirstPage(driver);
		firstpage.clickonsignin();
		
		
		

	}
	

}
