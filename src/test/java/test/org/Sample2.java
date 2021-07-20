package test.org;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample2 {
	
	public static void main(String[] args) throws Exception {
		
		File f=new File("C:\\Users\\Dell\\eclipse-workspace\\Maven\\excel\\Sample.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet("Sheet1");
	
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			
			Row row=sheet.getRow(i);
			
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();	
		for (int j = 0; j < physicalNumberOfCells; j++) {
			
		Cell cell = row.getCell(j);
		int cellType = cell.getCellType();
		
		if (cellType==1) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			}
		else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("MM/dd/yyyy");
				String format = sim.format(dateCellValue);
				System.out.println(format);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l=(long) numericCellValue;
				String valueOf = String.valueOf(l);
				System.out.println(valueOf);
				
			}
			
			int physicalNumberOfRows1 = sheet.getPhysicalNumberOfRows();
			for (int k = 0; k <physicalNumberOfRows1; k++) {
				
				Row row1 = sheet.getRow(k);
				
			
		}
		
			
		}
			
		}
	}

}
