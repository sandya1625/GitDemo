package introductionmaven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class softassertion {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		//to obtain all the links in footer
		//since it generates no. of elements so it is stored as webelement  as links
	List<WebElement> links=	driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	SoftAssert a=new SoftAssert();
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
				//here the if condition is avoided but this is hard assertion where the execution stops when the broken link is obtained
				Assert.assertTrue(respcode<400,"The link with text" + link.getText() + "is broken with code" + respcode);
				//here it is soft assertion which executes all the scripts
				//here the expectation is true but found false
				a.assertTrue(respcode<400,"The link with text" + link.getText() + "is broken with code" + respcode);
				
	}
	//if we didnot write this at end the above steps executes but it doesnot produces failures
	a.assertAll();
	
		
	}

}
