package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
	public static void main(String[] args) throws IOException {

		//Opened file in a reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testData\\testData.xlsx");
		
		//from file extracted workbook 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//from workbook extracted sheet
		XSSFSheet sheet =  workbook.getSheet("Sheet1");
		//from sheet total rows and cells	
		int totalRows  = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of Rows : "+totalRows); //5
		System.out.println("Number of Cells : "+totalCells); //4
		
		for(int r=0;r<=totalRows;r++) {
			XSSFRow currentRow =  sheet.getRow(r);
			for(int c=0;c<totalCells;c++) {
				XSSFCell cellData =  currentRow.getCell(c);
				System.out.print(cellData.toString()+"\t"); 
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
