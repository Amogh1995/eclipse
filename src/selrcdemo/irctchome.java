package selrcdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class irctchome {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Amog java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();   
        driver.get("http://irctc.co.in");
        
       //login into irctc 
        driver.findElement(By.xpath(".//*[@id='usernameId']")).sendKeys("psgmurthy");
        driver.findElement(By.xpath(".//*[@id='usernameId']")).sendKeys("guru1234");
        driver.findElement(By.xpath(".//*[@id='usernameId']")).sendKeys("psgmurthy");

	}

}
