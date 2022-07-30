package introductionmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativelocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");//url
		//to go to the name editbox
		WebElement nameeditbox=driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).//to grab the text having tagname label
				above(nameeditbox)).//to grab the text above nameeditbox we r using relative locator
				getText());//Get the visible (i.e. not hidden by CSS) text of this element, including sub-elements
		//to check the tag name below date of birth label
		WebElement dateofbirth=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofbirth)).click();//it clicks on submit button
		//actually below dateof birth we have date of birth field but it shows that it is flex in html page
		//the relative locators does not support flex items so it goes to next field i.e submit button so we click on that
	//to click of the left checkbox of the text Check me out if you Love IceCreams! we use toleftof() locator
		WebElement icecreamlabel=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamlabel)).click();
		//to get the text on right side of radio button 
		WebElement rdb=driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	
	}

}//by tagname only we can get the relative locators
//we have to write import static org.openqa.selenium.support.locators.RelativeLocator.*; before using relativelocator
