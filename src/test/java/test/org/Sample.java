package test.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {

	public static void main(String[] args) throws IOException {
		
		
		File f=new File("C:\\Users\\Dell\\eclipse-workspace\\Maven\\excel\\Sample.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet("Sheet1");
		//Row row = sheet.getRow(1);
		//Cell cell = row.getCell(1);
		//System.out.println(cell);
		
		
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i <physicalNumberOfRows; i++) {
			
			Row row = sheet.getRow(i);
			
		
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();	
		for (int j = 0; j <physicalNumberOfCells; j++) {
			
			Cell cell = row.getCell(j);
			int cellType = cell.getCellType();
			if (cellType==1) {
				
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
			}
			else if (cellType==0) {
				double numericCellValue = cell.getNumericCellValue();
				long l= (long) numericCellValue;
				String valueOf = String.valueOf(l);
				System.err.println(valueOf);
			}	
			
			
			
			
		}
		

			
			
		}
		
		
		
		
		
		
		
		
	}
}
