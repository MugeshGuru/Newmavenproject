package test.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample3 {

	public static void main(String[] args) throws Exception {
		
		File f=new File("C:\\Users\\Dell\\eclipse-workspace\\Maven\\excel\\Sample.xlsx");

		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(1);
		String name = cell.getStringCellValue();
		
		if (name.equals("Mark")) {
			cell.setCellValue("Arun");
			
		}
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
	}
}
