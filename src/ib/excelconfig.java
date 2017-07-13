package ib;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelconfig 
{
	XSSFWorkbook wb1;
	XSSFSheet sheet1;
	public excelconfig(String excelpath)  throws Exception
	{
		// TODO Auto-generated method stub
		File p1=new File(excelpath);
        FileInputStream fl1=new FileInputStream(p1);
        
         wb1 =new XSSFWorkbook(fl1);
       
       

	}


	



public String getData(int i,int row, int column)
{
	
	 sheet1= wb1.getSheetAt(0);
	
	String data=sheet1.getRow(row).getCell(column).getStringCellValue();
	return data;

}
}
