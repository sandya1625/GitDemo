package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//to select from tab
		// to select arrival as bangalore xpath is //a[@value='BLR']
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		//then no need of giving next tab it automatically moves
		//to  select departure as coimbatore xpath is //a[@value='CJB'].but it opens two elements one in arrival nd other in departure
		//so it doesnot selects anyone it produces error to remove error we have to give index (//a[@value='CJB'])[2] 2 is index
		//driver.findElement(By.xpath("(//a[@value='CJB'])[2]")).click();
		//USING PARENT CHILD RELATIONSHIP
		////div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		////div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CJB']
		//THE BELOW CODE IS FOR DESTINATION WITHOUT INDEX 
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CJB']")).click();
		//selecting departure date
		// css is .ui-state-default.ui-state-highlight
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//to check whether the return date is  disabled before  the selection of roundtrip button but here it returns true which is wrong
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		//to select roundtrip radio button
        //to print the value in style attribute before selecting round trip radio button bcoz style attribute is changing in html
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//to print the value in style attribute after selecting round trip radio button bcoz style attribute is changing in html
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//now to check whether the return date is  enabled/disabled before nd after the selection of roundtrip button
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))//if this style attribute contains 1 then true else false
		{
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
	}


