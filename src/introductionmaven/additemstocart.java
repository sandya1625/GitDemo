package introductionmaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class additemstocart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		//here we are identifying elements by using product name i.e h4.product-name so it produces 30 items
		//these 30 items are stored in a list called product
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		//for loop is written based on size of products
		for (int i=0;i<products.size();i++)
		{
			//in the name string we are saving the text of products until i is checking
			String name=products.get(i).getText();
			//if loop is writing for selecting cucumber 
			if(name.contains("Cucumber"))
			{
				//click on add to cart
				// xpath is used //button[text()='ADD TO CART']
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				//after clicking add to cart button then there is no need of loop so break is given
				break;
			}
		}

	}

}
