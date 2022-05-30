package com.nitara.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.nitara.utils.ExcelUtils;




public class Writetoexcel {

	static int counter=1;
	
	
	// Write localisation status check to the excel file
	public void WriteTranslationStatus(String Name,String Expected,String Actual,String Status,String Page) throws IOException {


		FileInputStream f2 = new FileInputStream("C:\\Users\\SURABHIKUMAR\\Downloads\\LocalizationExcel.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(f2);   
		XSSFSheet sheet = wb.getSheetAt(0); 

		Row row = sheet.getRow(counter);
		if(row == null)
			row = sheet.createRow(counter);
		Cell cell = row.getCell(0);
		if(cell == null)
			cell = row.createCell(0);
		cell.setCellValue(Name);

		Cell cell1 = row.getCell(1);
		if(cell1 == null)
			cell1 = row.createCell(1);
		System.out.println(Expected);
		cell1.setCellValue(Expected);

		Cell cell2 = row.getCell(2);
		if(cell2 == null)
			cell2 = row.createCell(2);
		cell2.setCellValue(Actual);


		Cell cell3= row.getCell(3);
		if(cell3 == null)
			cell3 = row.createCell(3);
		cell3.setCellValue(Status);

		Cell cell4= row.getCell(4);
		if(cell4 == null)
			cell4 = row.createCell(4);
		cell4.setCellValue(Page);

		counter++;

		FileOutputStream f1 = new FileOutputStream("C:\\Users\\SURABHIKUMAR\\Downloads\\LocalizationExcel.xlsx");
		wb.write(f1);
		f1.close();
	}
	
	
	
	// Write data to excel File - API
	public void updateField(String sheet, String filePath, String field) throws Exception {


		String absPath = new File(filePath).getAbsolutePath();
		FileInputStream input = new FileInputStream(absPath);
		XSSFWorkbook workbook = new XSSFWorkbook(input);

		XSSFSheet ws=workbook.getSheet(sheet);

		//find row of the required field
		int rownumber = ExcelUtils.findRow(ws, field);
		System.out.println(rownumber);
		long i = Long.parseLong(ws.getRow(rownumber).getCell(1).getStringCellValue());
		String value = String.valueOf(i+1);
		ws.getRow(rownumber).getCell(1).setCellValue(value);

		input.close();

		FileOutputStream outputStream = new FileOutputStream(absPath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
	
	
	


}