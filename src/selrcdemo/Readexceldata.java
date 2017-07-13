package selrcdemo;

import ib.excelconfig;

public class Readexceldata {

	public static void main(String[] args) throws Exception
	{
		excelconfig excel=new excelconfig("D:/Amog java/Bookpoi1.xlsx");
		
System.out.println(excel.getData(1, 1, 1));
	}

}
