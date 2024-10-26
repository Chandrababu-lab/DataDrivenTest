package ddt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInSpecificCell {

	public static void main(String[] args) throws IOException {
		
		//FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\testRondom.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");
		XSSFRow row =  sheet.createRow(2);
		XSSFCell cell= row.createCell(3);
		cell.setCellValue("Welcome to Java Automation");
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\testRandom.xlsx");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File created..");
	}
}
