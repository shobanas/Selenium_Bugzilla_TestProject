package helperUtils;

import java.io.File;
import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateExcelFile {

	public static void main(String[] args) throws IOException {
		File excel_file = new File("C:\\Users\\Shobana\\workspace\\Udemy-Rathore-Selenium\\frameworks\\excel_file.xlsx");
		FileInputStream fin = new FileInputStream(excel_file);
		
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet("Test Data Sheet");
		
		// modify row 0, col 0 cell value
		XSSFRow row = sheet.getRow(0);
		XSSFCell cel = row.getCell(0);
		cel.setCellValue("Modified Value");
		System.out.println("cell - value" + cel.getStringCellValue());
		;
		// create a new row and column 
		XSSFRow row2 = sheet.createRow(4);
		XSSFCell cel2 = row2.createCell(0);
		cel2.setCellValue("Newly added cel");
		
		fin.close();
		
		FileOutputStream fout = new FileOutputStream(excel_file);
		book.write(fout);
		fout.close();
		System.out.println("Updated File");

	}

}

