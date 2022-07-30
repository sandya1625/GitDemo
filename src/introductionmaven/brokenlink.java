package introductionmaven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		//to get the url of soapui
		//String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		//to get the broken link
		String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");//here by using conn object we are requesting the page url
		//opens communication link to the resource referenced by this url if such a connection has not already been established. 
		conn.connect();
		//Gets the status code from an HTTP response message.For example, in the case of the following status lines: 
			// HTTP/1.0 200 OK
			// HTTP/1.0 401 Unauthorized
		int respcode=conn.getResponseCode();
		System.out.println(respcode);
	}

}
