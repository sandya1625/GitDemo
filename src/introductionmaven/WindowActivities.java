package introductionmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//to run the screen in maximized mode
		driver.manage().window().maximize();
		driver.get("http://google.com");
		//to navigate to another page from google
		driver.navigate().to("https://rahulshettyacademy.com");
		//to navigate from rahulshetty to google again
		driver.navigate().back();
		//to again forward
		driver.navigate().forward();

	}

}
