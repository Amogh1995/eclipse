
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class Hdfc {

	public static void main(String[] args) throws InterruptedException, SikuliException
	{
		System.setProperty("webdriver.chrome.driver","E:/Amog java/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Screen sc=new Screen();
	     Pattern pt2=new Pattern("E:\\Amog java\\hdfccontinue.PNG");
	      Pattern pt1=new Pattern("E:\\Amog java\\hdfcid.PNG");
	      Pattern pt3=new Pattern("E:\\Amog java\\hdfcipin.PNG");
	      Pattern pt4=new Pattern("E:\\Amog java\\hdfcbox.PNG");
	      
	      
		driver.get("https://www.hdfcbank.com");
		driver.findElement(By.xpath(".//*[@id='element2']/div[1]/div/div[5]/div[1]/div[2]/div[1]/div/div[1]")).click();
        driver.findElement(By.xpath(".//*[@id='netbanking']")).click();
        driver.findElement(By.id("loginsubmit")).click();
        Set<String> Allwindowshandles= driver.getWindowHandles();
        String w1= (String) Allwindowshandles.toArray()[0];
        		String w2=(String) Allwindowshandles.toArray()[1];
        		driver.switchTo().window(w2);
        		
        		
        		
        		driver.findElement(By.xpath("//div[contains(@class,'pdtb25 text-center')][1]/a")).click();
        		Thread.sleep(3000);
        		
        		sc.type(pt1,"69854390");
        		sc.click(pt2);
        		sc.type(pt3,"qazwsxplmokN1");
        		sc.click(pt4);

        
    	Thread.sleep(3000);
       
	   
	
	}

}
