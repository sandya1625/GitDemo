package introductionmaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7 {

	public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				//give the URL
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				WebElement table=driver.findElement(By.id("product"));
				//here we are using table name . findelements so it goes into that table only\
				//here for each and  every row the tagname is tr
            	System.out.println(table.findElements(By.tagName("tr")).size());
            	//here in the header  th it contains  tr elements in 1st place 
            	System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
            	//to print the elements in 2nd row every item has tag name td
            	List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
            	System.out.println(secondrow.get(0).getText());
            	System.out.println(secondrow.get(1).getText());
            	System.out.println(secondrow.get(2).getText());
				
	}

}
