package selrcdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class auto1 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome http://beust.com/eclipse.driver", "E:\\Amog java\\chromedriver_win32(1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();     

driver.get("http://Facebook.com");


//log in
driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("amogh.missile@gmail.com");

driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("qazwsxplmokn");

driver.findElement(By.xpath(".//*[@value='Log In']")).click();

//operations
driver.findElement(By.xpath(".//*[@id='navItem_100000926792217']/a/div")).click();

//Log out
WebElement lstitem =driver.findElement(By.xpath(".//*[@id='userNavigationLabel']"));
lstitem.click();

driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

driver.findElement(By.partialLinkText("Log Out")).click();

System.out.println("Log out");

}
}
