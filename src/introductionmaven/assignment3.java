package introductionmaven;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		WebDriverWait explWait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] requiredPhone = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		driver.findElement(By.name("password")).sendKeys("learning");

		driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();
		Thread.sleep(1200);

		System.out.println("Confirmation Text: " + driver.findElement(By.xpath("//div[@class='modal-body']/child::p")).getText());

		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		driver.findElement(By.tagName("select")).click();
		List <WebElement> dropDownOptions = driver.findElements(By.xpath("//select[@class='form-control']/child::*"));

		System.out.println("Total " + dropDownOptions.size() + " options are available & those are: ");

		int i = 1;

		while (i <= dropDownOptions.size()) {

		for (WebElement dropDownOption : dropDownOptions) {

		System.out.println(i + ". " + dropDownOption.getText());

		i++;

		}

		}

		driver.findElement(By.xpath("//option[@value='consult']")).click();

		driver.findElement(By.name("terms")).click();

		driver.findElement(By.name("signin")).click();

		explWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add')]")));

		addItemForCheckout(driver, requiredPhone);

		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

		System.out.println("Total Shopping is worth: " +

		driver.findElement(By.xpath("//td[@class='text-right']/descendant::strong")).getText());

		driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();

		driver.quit();

		}

		public static void addItemForCheckout(WebDriver driver, String[] requiredPhone) {

		List <WebElement> phoneOptions = driver.findElements(By.xpath("//h4[@class='card-title']/child::*"));

		int breakLoop = 0;

		for (int i = 0; i < phoneOptions.size(); i++) {

		String phoneOption = phoneOptions.get(i).getText();

		List requiredPhoneList = Arrays.asList(requiredPhone);

		if (requiredPhoneList.contains(phoneOption)) {

		breakLoop++;

		driver.findElements(By.xpath("//button[contains(text(),'Add')]")).get(i).click();

		if (breakLoop == requiredPhone.length) {

		// breakLoop == requiredItemList.size() -> If Array; use 'length'. If ArrayList;

		// use 'size()'

		break;

		}

		}

		}

	}
	

}
