package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//to check that no checkbox is selected
		//here it is false bcoz no checkbox is selected initially
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		//to click the first checkbox
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		//to check whether the checkbox is selected or not 
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

		driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		//to check the total number of checkboxes in the page nd print in console
		//input[type='checkbox']
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}

}
