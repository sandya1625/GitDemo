package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class miscellaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("http://facebook.com");
		System.out.println("facebook is opened");
		driver.findElement(By.xpath("id('email')")).sendKeys("fsfd");
		driver.manage().window().maximize();
		System.out.println("window is maximized");
		driver.manage().deleteAllCookies();
		 driver.get("http://google.com");
		System.out.println("google is opened");
	

	}
	
	
	}


