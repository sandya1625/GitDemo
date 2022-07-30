package introductionmaven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class miscellaneous1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	        //to open the window in maximized mode
	        driver.manage().window().maximize();
	        //to delete all the cookies
	        driver.manage().deleteAllCookies();
	        //if we want to delete a particular cookie
	        //driver.manage().getCookieNamed("");//if we use session key in the name then if we click on any link it goes to login page
	        //if we want to add cookie
	        //driver.manage().addCookie("");
	        driver.get("https://www.google.com/");
	        //to take a screenshot first we have to convert a webdriver object to screenshot object
	        //to change that the driver is casting into screenshot (takesscreenshot)driver
	        //to take this screenshot getscreenshot() is used which is visible only when driver object is cast into screenshot
	       File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       //this source object has to bring the file into system
	        FileUtils.copyFile(src,new File("D://screenshot.png"));//here if we use c drive some systems doesnot support to save in c drive
	        

	}

}
