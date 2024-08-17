package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class ReadData {
public static String readPropertyFile(String value) throws IOException {
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Automation Framework\\SSqure\\src\\main\\java\\config\\config.properties");
	prop.load(file);
	return prop.getProperty(value);
	
}
public static String readExecl(int rownum,int colnum) throws EncryptedDocumentException, IOException {
	FileInputStream file=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Automation Framework\\SSqure\\TestData\\Book1.xlsx");
	Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
	String value=excel.getRow(rownum).getCell(colnum).getStringCellValue();
	return value;
	
}
}
