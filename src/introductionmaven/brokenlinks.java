package introductionmaven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		//to obtain all the links in footer
		//since it generates no. of elements so it is stored as webelement  as links
	List<WebElement> links=	driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	for(WebElement link:links)//enhanced for loop
	{
		//to get the url of soapui
				//String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
				//to get the broken link
				String url=link.getAttribute("href");//here you will get url
				HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");//here by using conn object we are requesting the page url
				//opens communication link to the resource referenced by this url if such a connection has not already been established. 
				conn.connect();
				//Gets the status code from an HTTP response message.For example, in the case of the following status lines: 
					// HTTP/1.0 200 OK
					// HTTP/1.0 401 Unauthorized
				int respcode=conn.getResponseCode();
				System.out.println(respcode);
				if(respcode>400)//here it checks the condition if it is greater than 400
				{
					System.out.println("The link with text" + link.getText() + "is broken with code" + respcode );
					//Asserts that a condition is true. If it isn't, an AssertionError is thrown
					Assert.assertTrue(false);
					//the above concept of assertion is hard assertion it will stop your script immediately.
				}
	}
		
	}

}
