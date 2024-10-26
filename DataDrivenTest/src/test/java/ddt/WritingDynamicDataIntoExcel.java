package ddt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\testData\\testData2_Dynamic.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("DynamicData");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter How many Rows ?");
		int numRows = sc.nextInt();

		System.out.println("Enter How many Cells ?");
		int numCells = sc.nextInt();

		for (int r = 0; r <= numRows; r++) {
			
			XSSFRow currentRow = sheet.createRow(r);
			
			for (int c = 0; c < numCells; c++) {
				
				XSSFCell cell = currentRow.createCell(c);
				cell.setCellValue(sc.next());
			}
		}

		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("File Created..");
	}

}
