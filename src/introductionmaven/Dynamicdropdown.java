package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicdropdown {

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
	}

}
