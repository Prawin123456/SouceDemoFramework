package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String toReaddataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("/SouceDemo_Framework/src/test/resources/Book3.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String work = book.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return work;
	}

}
