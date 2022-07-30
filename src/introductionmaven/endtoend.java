package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class endtoend {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//to select from tab
		// to select arrival as bangalore xpath is //a[@value='BLR']
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		//to select chennai as destination
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//for clicking the date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))//if this style attribute contains 1 then true else false
		{
			System.out.println("its enabled");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		//to select senior citizen
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//to select 5 adults 
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		int i=1;//initially i value is 1
		while(i<5)//checking for condition up to 5
		{
			driver.findElement(By.id("hrefIncAdt")).click();//4 times
			i++;//incrementing i value
			
	}
		driver.findElement(By.id("btnclosepaxoption")).click();//done button
		//here also we are using assertion to check the actual nd expected result
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		//for clicking the search button we can write in many ways
		//driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();//using id attribute in css
		//driver.findElement(By.cssSelector("input[type='submit'")).click();//css using type attribute
		//driver.findElement(By.xpath("//input[@type='submit'")).click();//xpath using type
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();//using name
	}

}
