package introductionmaven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//to check if we search for any item in search button to check whether the searched item is displaying/not

public class filtersforstreamsinselenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//if we search for rice in search button
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		//to find all the elements in the first page
		//xpath->in console window $x('//tr') gave all 6 rows $x('//tr/td[1]') will returns all items in first column
		//here we have not applied any filter so it produces 5 items
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredlist=veggies.stream()//veggies is converted into streams
				.filter(veggie->veggie.getText().contains("Rice"))//taking text and checking for the text rice nd filter it
				.collect(Collectors.toList());//converting obtained stream into list
		Assert.assertEquals(veggies.size(), filteredlist.size());
	}

}
