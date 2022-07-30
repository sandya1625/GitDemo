package introductionmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class sslcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//here to remove the error caused when working with websites which are internal to our project
		//we are creating object for chromeoptions class
		ChromeOptions options=new ChromeOptions();
		//using that options object different methods
		options.setAcceptInsecureCerts(true);
		//in the same way we can use for firefox also
		//FirefoxOptions options1=new FirefoxOptions();
		//options1.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		//WebDriver driver1=new FirefoxDriver(options1);
		//give the URL
		driver.get("https://expired.badssl.com/");
		//for firefox
		//driver1.get("https://expired.badssl.com/");
		//to print the title of page
		System.out.println(driver.getTitle());
		//for firefox
		//System.out.println(driver1.getTitle());
	}
}

