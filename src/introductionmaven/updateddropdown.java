package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//to select passengers tab in that page
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		//to select 2 adults from that tab
		//driver.findElement(By.id("hrefIncAdt")).click();//2 adults
		//for more selection option we have to use for or while loop
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());//to see the text available in browser in console before loop
		int i=1;//initially i value is 1
		while(i<5)//checking for condition up to 5
		{
			driver.findElement(By.id("hrefIncAdt")).click();//4 times
			i++;//incrementing i value
			
		}
		//FOR LOOP FOR SAME PROGRAM
		//for(int i=1;i<5;i++)
		//{
			//driver.findElement(By.id("hrefIncAdt")).click();
		//}
		driver.findElement(By.id("btnclosepaxoption")).click();//done button
		//here also we are using assertion to check the actual nd expected result
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());//to see the text available in browser in console after loop		
	}

}
