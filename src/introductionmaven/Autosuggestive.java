package introductionmaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//searching for keyword ind
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		//here it produces the  total options from the webelement searched so we select find elements here
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//enhanced for loop
		for(WebElement option:options)
		{
			//it checks for that condition
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				//once the condition satisfies then the loop breaks
				break;
			}
		}
	}

}
