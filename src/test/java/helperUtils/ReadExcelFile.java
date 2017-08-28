package helperUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	 public static Object[][] getExcelData(String fileName,String sheetName) throws IOException {
		
	/****
	    public static void main(String[] args) throws IOException{
		 XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile.class.getClassLoader().getResourceAsStream("resource/Login.xlsx"));
			XSSFSheet sheet = book.getSheet("LoginDetails"); 
	****/
	
			 
		// specify the location of the excel file using class loader
		XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile.class.getClassLoader().getResourceAsStream("resource/" + fileName));
		XSSFSheet sheet = book.getSheet(sheetName);
		
		
		XSSFRow row = null;
		XSSFCell cel = null;
		
		/*********
		
		for(int r = sheet.getFirstRowNum(); r <= sheet.getLastRowNum(); r++ ) {
		
			XSSFRow rw = sheet.getRow(r);
			
			System.err.println(rw.toString());
			
			for(int col = rw.getFirstCellNum(); col <= rw.getLastCellNum(); col++ ) {
				
				XSSFCell c = rw.getCell(col);
				
				System.out.println("cell value " + c.getStringCellValue());
		    }
		}
		
		
		************/
		
		
		
		Map<String, Object> map = null;
	
		// get the cell contents through a map data structure with key being the column title
		// get the title (first row) contents into an array and this will serve as the key to the map
		row = sheet.getRow(0);
		String[] header = new String[row.getLastCellNum()];
		
		for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++){
			cel = row.getCell(j);
			header[j] = cel.getStringCellValue();
		}
		
		// obtain the values for the keys and construct map structure
		Object[][] data = new Object[sheet.getLastRowNum()][1];
		
		for(int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++){
			row = sheet.getRow(i);
			map = new LinkedHashMap<String, Object>();
			for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++){
				cel = row.getCell(j);
				
				switch (cel.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					map.put(header[j], cel.getStringCellValue());
					break;

				case XSSFCell.CELL_TYPE_NUMERIC:
					map.put(header[j], cel.getNumericCellValue());
					break;
				}
			}
			data[i-1][0] = map;

		}
	
		
		return data;
		
	
	}
	
	public static void UpdateToExcel(int colIndex,String srcFile,String destFile,String sheetName,ArrayList<String> status) throws IOException {
		
		// get the path to resource folder
		String path = ReadExcelFile.class.getClassLoader().getResource("resource/").getPath();
		// since class loader picks classpath from bin folder, change it to src
		
		System.out.println("path is " + path);
		
		// path = path.replaceAll("bin", "src");
		
		
		// get the srcfile with test data and add the status column
		XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile.class.getClassLoader().getResourceAsStream("resource/" + srcFile));
		XSSFSheet sheet = book.getSheet(sheetName);
		
		for(int i = 1; i <= sheet.getLastRowNum(); i++){
			XSSFRow row = sheet.getRow(i);
			XSSFCell cel = row.createCell(colIndex);
			// array list contains status value from zero index
			cel.setCellValue(status.get(i - 1));
			System.out.println("status value " + cel.getStringCellValue());
			
		}
		
		// write the sheet contents onto the destination excel file
		FileOutputStream fout = new FileOutputStream(new File(path + destFile));
		book.write(fout);
		fout.close();
		System.out.println("Test status added to the new excel file");
	}
	
}
