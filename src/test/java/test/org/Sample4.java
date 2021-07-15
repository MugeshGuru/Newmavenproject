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

public class Sample4 {
	
	public static void main(String[] args) throws Exception {
		
		File f=new File("C:\\Users\\Dell\\eclipse-workspace\\Maven\\excel\\Sample.xlsx");

		FileInputStream fin=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fin);
		
		Sheet createSheet = w.createSheet("Sheet2");
		
		Row createRow = createSheet.createRow(0);
		
		Cell createCell = createRow.createCell(0);
		
		createCell.setCellValue("Name");
	
	FileOutputStream fout=new FileOutputStream(f);
	w.write(fout);
	
	}
}
