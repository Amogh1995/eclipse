package selrcdemo;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class poi2 {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		File p1=new File("E:/Amog java/Bookpoi1.xlsx");
        FileInputStream fl1=new FileInputStream(p1);
        
        XSSFWorkbook wb1 =new XSSFWorkbook(fl1);
       
        XSSFSheet sheet1= wb1.getSheetAt(0);
        int rowcount= sheet1.getLastRowNum();
        System.out.println("Username               passwords");
        
        System.setProperty("webdriver.chrome.driver", "E:/Amog java/chromedriver.exe");
          
      
        
        
        for(int i=0;i<rowcount;i++)
        {
        	String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
        	
        	
        	String data1=sheet1.getRow(i).getCell(1).getStringCellValue();
        	System.out.println(data0+"              "+data1);
        	 WebDriver driver = new ChromeDriver();
        	  driver.get("http://facebook.com");
        	
        	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(data0);

        	driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(data1);

        	driver.findElement(By.xpath(".//*[@value='Log In']")).click();
        	
        	if(driver.getPageSource().contains("Home"))
        	{
        		System.out.println("Login successful");
        		}else
        		{
        		System.out.println("Login Unsuccessful");
        		}
       
       driver.close();
       
        	  
        }
        
        wb1.close();
	}
	

}
