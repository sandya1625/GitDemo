package introductionmaven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name="rahul";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);//name is string which is already assigned if we did not assign means "rahul" should be given here
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		//driver.findElement(By.tagName("p")).getText();
		Thread.sleep(2000);//here we gave this bcoz here we use tagname if that name is present in same page then it takes that so we use delay
		System.out.println(driver.findElement(By.tagName("p")).getText());//to print o/p in console window
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello rahul,");or below code is same
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();//* can also be replaced with tagname i.e button here
		driver.close();

	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);//here we give time bcoz to load next page we have to give time for 1 second
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String PasswordText=driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		//the above string is splitted in to two based on single quotation
		//index0 has Please use temporary password 
		//index1 has rahulshettyacademy' to Login.
		String[] passwordArray=PasswordText.split("'");
		//the splitted string is stored in passwordarray in above code
		//the password array index 1 is again splitted in to two based on single quotation
		//index 0 has rahulshettyacademy
		//index 1 has  to Login.
		String[] passwordArray1=passwordArray[1].split("'");
		//it is stored in passwordarray1 in above code
		String password=passwordArray1[0];
		//the above code has password string which has o index of passwordarray1
		//the below line is same as above two line of code
		//String password=passwordArray[1].split("'")[0];
		return password;
		
	}
	}


