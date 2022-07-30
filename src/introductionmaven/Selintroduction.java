package introductionmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selintroduction {

	public static void main(String[] args) {
		//Invoking Browser
		//Chrome-ChromeDriver->Methods
		//Firefox-FirefoxDriver->Methods
		//all the methods are same in different browsers
		//so the code is same but we have to change driver only
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://rahulshettyacademy.com");
		//driver.getTitle();//to know the title of url
		//System.out.println(driver.getTitle());//to check the title in console
		//System.out.println(driver.getCurrentUrl());//to check url
		//driver.close();//it closes the browser
		//driver.quit();//it closes all the assosiated windows
		//firefox driver
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hi\\Downloads\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		//driver.get("https://rahulshettyacademy.com");
		//driver.getTitle();
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//driver.close();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Hi\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.getTitle();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		
	}

}
