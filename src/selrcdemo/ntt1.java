package selrcdemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ntt1
{
	public static void main(String[] args) throws Exception
	{
		String s;
		String expectedtitle="NTT DATA Americas";
        System.setProperty("webdriver.chrome.driver", "E:/Amog java/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
    	driver.get("http://portal.nttdatainc.com");
    	driver.findElement(By.xpath(".//*[@id='cred_userid_inputtext']")).sendKeys("109100@nttdata.com");

    
    	driver.findElement(By.xpath(".//*[@id='cred_sign_in_button']")).click();;
    	Thread.sleep(5000);
    	
    	
    	driver.findElement(By.id("passwordInput")).sendKeys("QAZWSXplmokn1");
    	driver.findElement(By.id("submitButton")).click();
    	/*
    	
    	s=driver.getTitle();
    	if(expectedtitle.equals(s))
    	{
    		System.out.println("Login successful");
    	}
    	else
    	{
    		System.out.println("Login not successful");
    	}
    	*/
    	Thread.sleep(5000);
    	
    	driver.findElement(By.className("smartBlu")).click();
    	driver.findElement(By.linkText("Office 365 Users")).click();
     	Thread.sleep(5000);
    	driver.findElement(By.xpath("//div/button[contains(@title,'Write a new message (N)')]/span[2]")).click();
       	Thread.sleep(15000);
    	driver.findElement(By.xpath(".//*[@id='primaryContainer']/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/div/span/div[1]/form/input']")).sendKeys("109126@nttdata.com");
    	driver.findElement(By.xpath(".//*[@id='primaryContainer']/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[6]/div[2]/input")).sendKeys("I have Automated");
    	driver.findElement(By.xpath(".//*[@id='primaryContainer']/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[5]/div/div[1]/div[2]/div[3]/div[2]/div[1]/button[1]")).click();
    	
	}

}