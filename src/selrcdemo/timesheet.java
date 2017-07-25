package selrcdemo;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class timesheet 
{

	public static void main(String[] args) throws Exception
	{
		File p1=new File("E:/Amogh NTT/time.xlsx");		
        FileInputStream fl1=new FileInputStream(p1);
        
        XSSFWorkbook wb1 =new XSSFWorkbook(fl1);
       
        XSSFSheet sheet1= wb1.getSheetAt(0);
        XSSFSheet sheet2= wb1.getSheetAt(1);
    
      Screen sc=new Screen();
    //  Pattern pt1=new Pattern("E:\\Amog java\\p1.PNG");
      Pattern pt2=new Pattern("E:\\Amog java\\p2.PNG");
      Pattern pt3=new Pattern("E:\\Amog java\\p3.PNG");
      Pattern pt4=new Pattern("E:\\Amog java\\p4.PNG");
      Pattern pt5=new Pattern("E:\\Amog java\\p5.PNG");
      Pattern pt6=new Pattern("E:\\Amog java\\p6.PNG");
      Pattern pt7=new Pattern("E:\\Amog java\\p7.PNG");
      Pattern pt8=new Pattern("E:\\Amog java\\p8.PNG");
      Pattern pt9=new Pattern("E:\\Amog java\\p9.PNG");
      Pattern pt10=new Pattern("E:\\Amog java\\deviate1.PNG");
      Pattern pt11=new Pattern("E:\\Amog java\\savetime.PNG");
     // Pattern pt12=new Pattern("E:\\Amog java\\releasetime.PNG");
      
      
		String s;
		String expectedtitle="NTT DATA Americas";
		System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
		  System.setProperty("webdriver.chrome.driver", "E:/Amog java/chromedriver.exe");
		
		 for(int i=1;i<2;i++)
	        {
	        	//getting value of each row i from excel;
	        String username=sheet1.getRow(i).getCell(0).getStringCellValue();        	     	
	        	String password=sheet1.getRow(i).getCell(1).getStringCellValue();
	        	String link=sheet2.getRow(i).getCell(0).getStringCellValue();  
	        	String Att=sheet1.getRow(i).getCell(2).getStringCellValue();
	        	String Billable=sheet1.getRow(i).getCell(3).getStringCellValue();
	        	String NB=  sheet1.getRow(i).getCell(4).getStringCellValue();
	        	double Mon1= sheet1.getRow(i).getCell(5).getNumericCellValue();
	        	double Tue1= sheet1.getRow(i).getCell(6).getNumericCellValue();
	        	double Wed1=sheet1.getRow(i).getCell(7).getNumericCellValue();
	        	double Thu1= sheet1.getRow(i).getCell(8).getNumericCellValue();
	        	double Fri1= sheet1.getRow(i).getCell(9).getNumericCellValue();
	        
	        	
	        	
	        	//String NB = String.valueOf(NB1);
	        	String Mon = String.valueOf(Mon1);
	        	String Tue = String.valueOf(Tue1);
	        	String Wed = String.valueOf(Wed1);
	        	String Thu = String.valueOf(Thu1);
	        	String Fri = String.valueOf(Fri1);
	        	
	        	System.out.println(username);
	        	System.out.println(password);
	        	System.out.println(link);
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("http://portal.nttdatainc.com");
    	driver.findElement(By.xpath(".//*[@id='cred_userid_inputtext']")).sendKeys(username);

    	Thread.sleep(5000);
    	driver.findElement(By.xpath(".//*[@id='cred_sign_in_button']")).click();;
    	Thread.sleep(8000);
    	
    	
    	driver.findElement(By.id("passwordInput")).sendKeys(password);
    	driver.findElement(By.id("submitButton")).click();
    	
    	//verification
       
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
    	driver.findElement(By.xpath(".//*[@id='button-container']/a[4]/p")).click();
    	
    	Thread.sleep(5000);
    	
   
    	//String winHandleBefore = driver.getWindowHandle(); 	
       	
    	
    
  
    
    	//Click your link
    	//driver.findElement(By.xpath(".//*[@id='slwp_ctl00_m_g_d2a1bd59_0d84_4b2e_a08e_2d7a790c6f6e']/div/div/ul/li[1]/div/div/a")).click();
    	//Get all the window handles in a set
    	
    	
    	  String oldTab = driver.getWindowHandle();
    	    driver.findElement(By.xpath(".//*[@id='slwp_ctl00_m_g_d2a1bd59_0d84_4b2e_a08e_2d7a790c6f6e']/div/div/ul/li[1]/div/div/a")).click();
    	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    	    newTab.remove(oldTab);
    	    
    	    
    	//change to new tab
    	    driver.switchTo().window(newTab.get(0));
    	    Thread.sleep(5000);
    	    //back to old tab
    	  //  driver.switchTo().window(oldTab);
    	
    
    	Thread.sleep(40000);
              
    	driver.findElement(By.linkText("Employee Self-Service")).click();
    	
    //	Thread.sleep(50000);
    	    	
    	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
    	driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);

    	driver.get(link);
    	
    	//.
    	Thread.sleep(10000);
    	//sc.click(pt1);
    	sc.type(pt2,Att);
    	
    	Thread.sleep(5000);
    	sc.type(pt3,Billable);
    	sc.click(pt10);
    	Thread.sleep(5000);
    	sc.type(pt4,NB);
    	
    	Thread.sleep(5000);
    	sc.type(pt5,Mon);
   
    	sc.type(pt6,Tue);
    	sc.type(pt7,Wed);
    	sc.type(pt8,Thu);
    	sc.type(pt9,Fri);
    	sc.click(pt11);
    //	sc.click(pt12);
     
	        }
    	
    	wb1.close();
    	System.out.println("You have done your task");
    	
	}

}

