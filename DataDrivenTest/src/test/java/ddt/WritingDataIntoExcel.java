package ddt;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testData\\testData2.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet =workbook.createSheet("SampleData");
		
		XSSFRow row1 =  sheet.createRow(0);
			row1.createCell(0).setCellValue("Java");
			row1.createCell(1).setCellValue(19);
			row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2 =  sheet.createRow(1);
			row2.createCell(0).setCellValue("Python");
			row2.createCell(1).setCellValue(3);
			row2.createCell(2).setCellValue("Automation");
			
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File Created..");
	}
	

}
