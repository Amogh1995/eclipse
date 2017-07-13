package selrcdemo;


import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.asprise.util.ocr.OCR;

public class irctctest
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		File p1=new File("E:/Amogh NTT/Irctc auto.xlsx");		
        FileInputStream fl1=new FileInputStream(p1);
        
        XSSFWorkbook wb1 =new XSSFWorkbook(fl1);
       
        XSSFSheet sheet1= wb1.getSheetAt(0);
       
		
		System.setProperty("webdriver.chrome.driver","E:/Amog java/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		
		
		 String username=sheet1.getRow(1).getCell(0).getStringCellValue();        	     	
     	String password=sheet1.getRow(1).getCell(1).getStringCellValue();
     	String Fromstation=sheet1.getRow(1).getCell(2).getStringCellValue();  
     	String Tostation=sheet1.getRow(1).getCell(3).getStringCellValue();
     	String Date=sheet1.getRow(1).getCell(4).getStringCellValue();
     	String Class=sheet1.getRow(1).getCell(5).getStringCellValue();
     	String Trainno= sheet1.getRow(1).getCell(6).getStringCellValue();
     	String Quota= sheet1.getRow(1).getCell(7).getStringCellValue();
     	String passengername1= sheet1.getRow(1).getCell(8).getStringCellValue();
     	String passengername2= sheet1.getRow(2).getCell(8).getStringCellValue();
		
		 //Locate Image element to capture screenshot.
        WebElement element = driver.findElement(By.xpath(".//*[@id='cimage']"));
        //Call captureElementScreenshot function to capture screenshot of element.
       // captureElementScreenshot(Image);
        
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        int ImageWidth = element.getSize().getWidth();
        System.out.println(ImageWidth);
        //Retrieve height of element.
        int ImageHeight = element.getSize().getHeight();
        System.out.println(ImageHeight);
        
        //Used selenium Point class to get x y coordinates of Image element.
        //get location(x y coordinates) of the element.
        Point point = element.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        System.out.println(xcord);
        System.out.println(ycord);
        //Reading full image screenshot.
        BufferedImage img = ImageIO.read(screen);
        
        //cut Image using height, width and x y coordinates parameters.
        BufferedImage dest = img.getSubimage(xcord, ycord+5, ImageWidth, ImageHeight-5);
        ImageIO.write(dest, "png", screen);
        
        //Used FileUtils class of apache.commons.io.
        //save Image screenshot In D: drive.
        FileUtils.copyFile(screen, new File("E:\\Amog java\\Capture1.PNG"));
       
        BufferedImage image = ImageIO.read(new File("E:\\Amog java\\Capture1.PNG"));   
        String imageText = new OCR().recognizeCharacters((RenderedImage) image);  
        System.out.println("Text From Image : \n"+ imageText);  
        System.out.println("Length of total text : \n"+ imageText.length()); 
        
        
        driver.findElement(By.id("usernameId")).sendKeys(username);
        driver.findElement(By.className("loginPassword")).sendKeys(password);
        driver.findElement(By.className("loginCaptcha")).sendKeys(imageText);
      //  driver.findElement(By.id("loginbutton")).click();
        
        
        
        //page 2
       WebElement e1= driver.findElement(By.xpath(".//*[@id='jpform:fromStation']"));
       e1.sendKeys(Fromstation);
       e1.sendKeys(Keys.ENTER);
       
        
       WebElement e2=driver.findElement(By.xpath(".//*[@id='jpform:toStation']"));
        
        e2.sendKeys(Tostation);
        e2.sendKeys(Keys.ENTER);
        
        driver.findElement(By.xpath(".//*[@id='jpform:journeyDateInputDate']")).sendKeys(Date);
        driver.findElement(By.xpath(".//*[@id='jpform:jpsubmit']")).click();
        
        
        //page 3 form filling
       String t1=".//*[@id='cllink-"+Trainno+"-"+Class+"-"+"4']";
      driver.findElement(By.xpath(t1)).click();
      /*
        for(int i=0;i<=5;i++)
        {
        String s1=".//*[@id='avlAndFareForm:trainbtwnstns:"+i+":j_idt492']/a";
   
     String s=  driver.findElement(By.xpath(s1)).getText();
      System.out.println(s);
     */
    //div[contains(@class,'container-div')]//div[contains(@id,'j_idt383')]//table[contains(@class,'t1')]//tbody//a[contains(@id,'16022-SL-GN-0')]
      
      String t2="//div[contains(@class,'container-div')]//div[contains(@id,'j_idt383')]//table[contains(@class,'t1')]//tbody//a[contains(@id,'"+Trainno+"-"+Class+"-"+Quota+"-"+"0')]";
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.xpath(t2)).click();
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //CONTINUE TO BOOKING
     // driver.findElement(By.xpath(".//*[@id='altavlfrm:continue']")).click();
      Thread.sleep(5000);
      for (int i=0;i<5;i++)
      {
    	  String passenger="passenger"+i;
      String pass=".//*[@id='addPassengerForm:psdetail:"+i+":1071743278']";
      driver.findElement(By.xpath(pass)).sendKeys(passenger);
      }
}
        }
	
