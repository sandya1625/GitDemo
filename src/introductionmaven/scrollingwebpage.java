package introductionmaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class scrollingwebpage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//give the URL
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				//to scroll down any web page we use java script executor concept
			JavascriptExecutor js=(JavascriptExecutor)driver; //this driver is has now javascript executor
				//here we are using the below javascript for window scrolling
				//window.scrollBy(0,500)
				js.executeScript("window.scrollBy(0,500)");//it will scroll the web page down
				//to scroll the data inside the table
				//document.querySelector(".tableFixHead").scrollTop=5000
				//here .tableFixHead is the css for classname
				//for vertical scroll we use scrolltop for horizontal we use scrollleft
				Thread.sleep(3000);
				js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");//table scrolling
				//here we are trying to identify locator which highlights all the values in 4th column
				//the xpath is //td[4] and css is td:nth-child(4) or we can use below xpath
				List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
				int sum=0;//this is assigned to sum all the amounts
				for (int i=0;i<values.size();i++)
				{
					//here get(i) moves into first element nd takes the text which is in string format
					//to convert string into integer we use integer parse int
					Integer.parseInt((values.get(i).getText()));
					//to print the amount in console window we use below statement
					System.out.println(Integer.parseInt((values.get(i).getText())));
					sum=sum+Integer.parseInt((values.get(i).getText()));
				}
				//to print the total sum in console
				System.out.println(sum);
				//to compare this with actual sum we inspect on it first
				driver.findElement(By.cssSelector(".totalAmount")).getText();//here we get the o/p as Total Amount Collected: 296
				//to get only amount we have to split it nd trim it 
				//now to convert it into integer we use integer.parseint and store it in variable total
				int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
				//to compare it with the sum value we use assertions
				//if they didnot match then error occurs
				Assert.assertEquals(sum, total);
	}

}
