import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ggl1 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:/Amog java/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		    driver.get("http://www.google.com");
		    WebElement element = driver.findElement(By.name("q"));
		    element.sendKeys("cricket!\n"); // send also a "\n"
		    element.submit();

		    // wait until the google page shows the result
		   WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		            .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

		//   List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
		    List<WebElement> findElements = driver.findElements(By.tagName("a"));
int count=findElements.size();
System.out.println(count);
		    // this are all the links you like to visit
		    for (WebElement webElement : findElements)
		    {
		    	System.out.println(webElement.getAttribute("href"));
		    	if((webElement.getText()).equals("ICC Champions Trophy 2017, Sri Lanka vs Pakistan, Live cricket score ..."))
		    	{
		    		webElement.click();
		     //  System.out.println  (webElement.getAttribute("href"));
		       break;
		    }
		    
		}
	

	}
	}


