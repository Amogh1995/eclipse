package selrcdemo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class poi1 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		File p1=new File("D:/Amog java/Bookpoi1.xlsx");
        FileInputStream fl1=new FileInputStream(p1);
        
        XSSFWorkbook wb1 =new XSSFWorkbook(fl1);
       
        XSSFSheet sheet1= wb1.getSheetAt(0);
        
        String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
        String data1=sheet1.getRow(0).getCell(1).getStringCellValue();
        System.out.println("value from excel  ="+data0);
        System.out.println("value from excel  ="+data1);
        wb1.close();
        		}

}
