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

public class explicitwait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				//creating object for webdriverwait class i.e already predefined which is used for explicit wait 
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				//WebDriverWait w = new WebDriverWait(driver, 5);
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				
				//array list is used to declare which items to add to cart
				String[] itemsneeded= {"Cucumber","Brocolli","Beetroot"};
				//give the URL
				driver.get("https://rahulshettyacademy.com/seleniumPractise");
				Thread.sleep(3000);
				addItems(driver,itemsneeded);
				//what ever we want to call in main method we need to create object of that method
				//if you want to add object of any method we need to create object of that class nd after that we call the method
				//waitsinselenium b=new waitsinselenium();//object of class
				//b.addItems(driver, itemsneeded);
				//if that method is static then no need of creating object if we remove above two lines then there is no error
				//bcoz the method given here is static
				
				driver.findElement(By.cssSelector("img[alt='Cart']")).click();//selecting add to bag
				//explicit wait
				
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")));
				driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();//to proceed to checkout
				driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");//to add  coupon code
				
				driver.findElement(By.cssSelector("button.promoBtn")).click();//for selecting apply button
				//explicit wait
				
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
				System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());//to see the text after applying promocode
			
			}
			
			public static void addItems(WebDriver driver,String[] itemsneeded)
			{
				int j=0;
			//here we are identifying elements by using product name i.e h4.product-name so it produces 30 items
					//these 30 items are stored in a list called product
					List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
					//for loop is written based on size of products
					for (int i=0;i<products.size();i++)
					{
						//in the name string we are saving the text of products until i is checking and splitting 
						String[] name=products.get(i).getText().split("-");
						//the splitted string is stored in formatted name
						String formattedname=name[0].trim();
						
						//convert array into arraylist for easy search
						//check whether the name you extracted is present/not
						List itemsneededlist=Arrays.asList(itemsneeded);
						//if loop is writing for selecting the list of items
						if(itemsneededlist.contains(formattedname))
						{
							j++;
							//click on add to cart
							// xpath is used //button[text()='ADD TO CART'] i.e xpath based on text but it doesnot selects the correct item 
							//bcoz the text changes every time
							// this xpath is used to remove the above error //div[@class='product-action']/button i.e parent child relation
							
							driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
							//after clicking add to cart button then there is no need of loop so break is given
							if(j==3)//or we can write it as if(j==itemsneeded.length) for more no. of elements in array i.e to add more items in cart 
							{
								break;
							}
							
						}
					}

	}

}
