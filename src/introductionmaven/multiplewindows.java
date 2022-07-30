package introductionmaven;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class multiplewindows {
//two web pages has to be taken https://rahulshettyacademy.com/angularpractice/ and https://rahulshettyacademy.com
	//copy the course name in 2nd url and paste it in the name field of 1st url
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");//1st url
		//to switch to newtab/ to open a new window
		//Creates a new browser window and switches the focus for future commands of this driver to the new window. 
		driver.switchTo().newWindow(WindowType.WINDOW);//if we use TAB means it opens in new tab WINDOW means it opens new window
		//but the driver is now in the home window only .To switch to that tab we have to use windowhandles()
		//Return a set of window handles which can be used to iterate over all open windows of thisWebDriver instance
		//by passing them to switchTo().Options.window() 
		Set<String> handles=driver.getWindowHandles();
		//Returns an iterator over the elements in this set
		Iterator<String> it=handles.iterator();
		//Returns the next element in the iteration.here the starting element is parentwindow so it generates parent id
		String parentwindowId=it.next();
		//Returns the next element in the iteration.here the 2nd element is childwindow so it generates child id
		String childwindowId=it.next();
		//switchTo() Send future commands to a different frame or window
		//window(childwindowId) Switch the focus of future commands for this driver to the window with the given name/handle
		driver.switchTo().window(childwindowId);
		driver.get("https://rahulshettyacademy.com");//now we r in child window
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
							.get(1)//returns the element at 1st position here in 0th poaition there is no element so we used 1
							.getText();//to grab text of that 1st element
		//now the name is taken we have to go back to parent window
		driver.switchTo().window(parentwindowId);//it moves to parent window
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));//here 1st we find the element name using css 
		//in this parent window we have to go to name field nd paste the text grabbed
		name.sendKeys(courseName);//Use this method to simulate typing into an element, which may set its value
		//to get the screenshot of the name given in name field
		File file=name.getScreenshotAs(OutputType.FILE);//Capture the screenshot and store it in the specified location.
		FileUtils.copyFile(file,new File("logo.png"));
		//Quits this driver, closing every associated window.
		//driver.quit();
		//Get Height & Width

		System.out.println(name.getRect().getDimension().getHeight());

		System.out.println(name.getRect().getDimension().getWidth());
		
	}

}
