package com.nitara.Helper;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;



public class Excel_Localisation {
	
static ArrayList<WebElement> getPage;
static ArrayList<String> toString;
String Name;
String Actual;
String Status;
String Trans;
String Page;

	public JSONObject ExcelCompare(JSONObject getPage,String Page ) throws IOException
	{
		/*this.getPage=getPage;
		this.toString=toString;
		this.Page=Page;*/
		String status = " ";
		JSONObject obj = new JSONObject();
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();
		String value=null;  
		Workbook wb=null;
		
		try  
		{   
		FileInputStream fis = new FileInputStream("C:\\Users\\SURABHIKUMAR\\Downloads\\trial.xlsx");  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory
		wb = new XSSFWorkbook(fis);  
		}  
		catch(FileNotFoundException e)  
		{  
		e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
		e1.printStackTrace();  
		}  
		
		XSSFSheet sheet=(XSSFSheet) wb.getSheetAt(0); 
		
		System.out.println(sheet.getPhysicalNumberOfRows());
			
		for(int j=0;j<sheet.getPhysicalNumberOfRows();j++) 
		{   
			Row row1 = sheet.getRow(j);
			list.add(row1.getCell(1).getStringCellValue()); 
			list1.add(row1.getCell(0).getStringCellValue());	
		}
		
		for (String key: getPage.keySet()){ 
			String Name = key.toLowerCase();
			System.out.println("Name:"+Name);
			String Actual = getPage.getString(key);
			System.out.println("Value"+getPage.get(key));
			int result = findRow(sheet,Name);
			if (result != -1) 
				{
					System.out.println("Result"+ result);
					Trans = list1.get(result);
					System.out.println(Trans);
					
					if(Trans.equals(Actual))
					{
					Status="True";
					}
					else
					{
					Status="False";
					}
				}
			else {
				Trans = "No Translation Found";
				Status="Not Found";
			}
			System.out.println(" " + Name + " " + Trans + " " + Actual + " " + Status);
			Writetoexcel statusWrite = new Writetoexcel();
			statusWrite.WriteTranslationStatus(Name,Trans,Actual,Status,Page);
			obj.put(key, Status);

			
		}
		System.out.println(obj);
		return obj;
	}
		static int binarySearch(ArrayList<String> arr, String x)
    {
        int l = 0, r = arr.size() - 1;
        while (l <= r) 
        {
            int m = l + (r - l) / 2;
 
            int res = x.compareTo(arr.get(m));
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
         }
		return r-1;
}
		
		
		public int findRow(XSSFSheet sheet, String cellContent) {
			for (Row row : sheet) {
				for (Cell cell : row) {
					if (cell.getCellType() == CellType.STRING) {
						if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
							System.out.println(row.getRowNum());
							return row.getRowNum();  
						}
					}
				}
			}               
			return -1;
		}
		
		
}


