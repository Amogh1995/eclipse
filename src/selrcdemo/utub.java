package selrcdemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class utub {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:/Amog java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();   
        driver.get("http://youtube.com");
        
        driver.findElement(By.xpath(".//*[@id='appbar-nav']/ul/li[2]/a/span")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
      //  WebElement element = driver.findElement(By.xpath("//*[@id='item-section-478150']/li/div/div[1]/div[2]/ul/li[4]/div/div/div/div[2]/h3/a"));
        
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
     //   element.click();
     /// /  driver.findElement(By.xpath(".//*[@id='item-section-042688']/li/div/div[1]/div[2]/ul/li[1]/div/div/div/div[1]/a/div/span/img")).click();

      List<WebElement> findElements = (List<WebElement>) driver.findElement(By.xpath("//*[@id='item-section-478150']/li/div/div[1]/div[2]/ul/li[4]/div/div/div/div[2]/h3/a"));

      // this are all the links you like to visit
      for (WebElement webElement : findElements)
      {
          System.out.println(webElement.getAttribute("href"));
      }
	    }
	}


