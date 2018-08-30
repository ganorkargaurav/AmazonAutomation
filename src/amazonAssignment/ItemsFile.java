package amazonAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//fetching data from excel sheet
public class ItemsFile {

    
    public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException {
    	
    	
        File file = new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook amazonSearch = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        amazonSearch = new XSSFWorkbook(inputStream);
        Sheet searchSheet = amazonSearch.getSheet(sheetName);
        
        int rowCount = searchSheet.getLastRowNum()+1;
        int columnCount = searchSheet.getRow(0).getPhysicalNumberOfCells();
        
        System.out.println(rowCount);
        System.out.println(columnCount);
        
        String[][] Data = new String[rowCount][columnCount];
                
        for (int i = 0; i < rowCount; i++) {

        	Row row = searchSheet.getRow(i);

        			for (int j = 0; j < columnCount; j++) {

               				Data[i][j] = row.getCell(j).getStringCellValue();
               				
        			}
        }
		return Data;

    }
}
	
