package selrcdemo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class nttauto2
{
	public static void main(String[] args) throws Exception
	{
		File p1=new File("E:/Amog java/Bookpoi1.xlsx");
        FileInputStream fl1=new FileInputStream(p1);
        
        XSSFWorkbook wb1 =new XSSFWorkbook(fl1);
       
        XSSFSheet sheet1= wb1.getSheetAt(0);
        int rowcount= sheet1.getLastRowNum();
    
        
 
        
		String s;
		String expectedtitle="NTT DATA Americas";
        System.setProperty("webdriver.chrome.driver", "E:/Amog java/chromedriver.exe");
        
        
       //for loop for number of users from excel file 
        for(int i=0;i<rowcount;i++)
        {
        	//getting value of each row i from excel;
        	String username=sheet1.getRow(i).getCell(0).getStringCellValue();        	     	
        	String password=sheet1.getRow(i).getCell(1).getStringCellValue();
        	String recipients=sheet1.getRow(i).getCell(2).getStringCellValue();
        	String Subject=sheet1.getRow(i).getCell(3).getStringCellValue();
        	//launching browser
        	 WebDriver driver = new ChromeDriver();
        	
        	
        	
    	driver.get("http://portal.nttdatainc.com");
    	driver.findElement(By.xpath(".//*[@id='cred_userid_inputtext']")).sendKeys(username);

    
    	driver.findElement(By.xpath(".//*[@id='cred_sign_in_button']")).click();;
    	Thread.sleep(5000);
    	
    	
    	driver.findElement(By.id("passwordInput")).sendKeys(password);
    	driver.findElement(By.id("submitButton")).click();
    	
    	
    	s=driver.getTitle();
    	if(expectedtitle.equals(s))
    	{
    		System.out.println("Login successful");
    	}
    	else
    	{
    		System.out.println("Login not successful");
    	}
    	Thread.sleep(5000);
    	
    	driver.findElement(By.className("smartBlu")).click();
    	driver.findElement(By.linkText("Office 365 Users")).click();
     	Thread.sleep(5000);
    	driver.findElement(By.xpath("//div/button[contains(@title,'Write a new message (N)')]/span[2]")).click();
       	Thread.sleep(10000);
    	driver.findElement(By.xpath(".//*[@id='primaryContainer']/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/div/span/div[1]/form/input']")).sendKeys(recipients);
    	driver.findElement(By.xpath(".//*[@id='primaryContainer']/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[6]/div[2]/input")).sendKeys(Subject);
    	driver.findElement(By.xpath(".//*[@id='primaryContainer']/div[5]/div/div[1]/div/div[5]/div[3]/div/div[5]/div[1]/div/div[3]/div[5]/div/div[1]/div[2]/div[3]/div[2]/div[1]/button[1]")).click();
    	
	}

}}