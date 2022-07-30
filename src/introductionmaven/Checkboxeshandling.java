package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxeshandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//here rather than checking in console here we are checking using assertions i.e false
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//to check that no checkbox is selected
		//here it is false bcoz no checkbox is selected initially
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//to click the seniorcitizen checkbox
		//input[id*='SeniorCitizenDiscount']
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//here rather than checking in console here we are checking using assertions i.e true
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//to check whether the checkbox is selected or not 
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());//if selected then true
		//to check the total number of checkboxes in the page nd print in console
		//input[type='checkbox']
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
