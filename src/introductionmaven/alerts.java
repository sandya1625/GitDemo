package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="Sandya";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//to give the string text into the name field
		driver.findElement(By.id("name")).sendKeys(text);
		//to click the alert button
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		//to check the text obtained in alert in the console window
		System.out.println(driver.switchTo().alert().getText());
		//to switch the context from browser to alerts and to accept the alerts
		driver.switchTo().alert().accept();
		//to select the confirm button
		driver.findElement(By.id("confirmbtn")).click();
		//to grab text on the alert button nd to print it in console window
		System.out.println(driver.switchTo().alert().getText());
		//to switch the context from browser to alerts and to accept the alerts
		driver.switchTo().alert().dismiss();
		
		
	}

}
