package dataproviderdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.RowFilter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders {
	@DataProvider(name = "Invalid Data")
	public Object[][] invalidLoginData() throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Academic_21_22_sem_I\\Java\\JARS\\file for practice\\Login_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Invalid_cred");
		XSSFRow row = sheet.getRow(1);
		System.out.println(sheet.getLastRowNum());
		// XSSFCell cell=row.getCell(1);
		Object [][]x=new Object[sheet.getLastRowNum()][row.getLastCellNum()-1];
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			row=sheet.getRow(i);
			for(int j=1;j<row.getLastCellNum();j++) {
				XSSFCell cell=row.getCell(j);		
				x[i-1][j-1]=cell.getStringCellValue();
				System.out.print(x[i-1][j-1]+"  ");
			}
			System.out.println();
		}
		 return x;
	}
}
