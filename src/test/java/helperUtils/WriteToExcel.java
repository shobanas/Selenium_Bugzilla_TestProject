package helperUtils;

import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void main(String[] args) throws IOException {
		File excel_file = new File("excel_file.xlsx");
		
		// create an output stream for the file to write contents
		FileOutputStream fout = new FileOutputStream(excel_file);
		
		XSSFWorkbook book = new XSSFWorkbook(); // create workbook
		XSSFSheet sheet = book.createSheet("Test Data Sheet"); // create the sheet
		
		for(int i = 0; i < 4; i++){
			XSSFRow row = sheet.createRow(i); //create the row
			for(int j = 0; j < 4; j++){
				XSSFCell cel = row.createCell(j); //create the column
				cel.setCellValue("Data" + j); //set the cell value
			}
		}
		// write the contents of the excel book onto output stream object
		book.write(fout);
		fout.close();
		System.out.println("File Created");

	}

}


