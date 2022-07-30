package introductionmaven;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class paginationusingstreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//give the URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//1.click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//2.capture all webelements into list
		List<WebElement> elementslist=driver.findElements(By.xpath("//tr/td[1]"));
		//3.capture text of all webelements into new(original) list
		List<String> originallist=elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
		//4.sort on the original list of step3 i.e sortedlist
		List<String> sortedlist=originallist.stream().sorted().collect(Collectors.toList());
		//5.compare original list versus sorted list
		Assert.assertTrue(originallist.equals(sortedlist));
		 //scan the name column with gettext->rice->print the price of rice
		//here the rice is not in first page
		//so we have to use pagination concept
		List<String> price;
		do
		{
			//capture all webelements into list
			List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
			 price=rows//this price is already listed as string
				           .stream()
				           //filter Returns a stream consisting of the elements of this stream that match the given predicate
				           //contains Returns true if and only if this string contains the specified sequence of char values.
				           .filter(s->s.getText().contains("Rice"))
				           //Returns a stream consisting of the results of applying the givenfunction to the elements of this stream
				           .map(s->getpriceveggie(s))
				           //converts stream into list 
				           .collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
	}while(price.size()<1);//while loop executes until the loop becomes true
	}

	private static String getpriceveggie(WebElement s) {
		// TODO Auto-generated method stub
		//here already we write xpath for s i.e //tr/td[1]
		//now to  go to price again it is also td so here we use sibling relation
		//  total xpath is //tr//td[1]/following-sibling::td[1]
		//here we are using s.findelement bcoz in stream we used variable as s
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
	}


