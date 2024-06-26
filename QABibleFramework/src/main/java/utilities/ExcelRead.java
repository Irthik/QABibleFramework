package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static FileInputStream f;
	public static XSSFWorkbook a;
	public static XSSFSheet b;

	public static String getStringData(int x, int y) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFile\\Salary.xlsx");
		a = new XSSFWorkbook(f);
		b = a.getSheet("Sheet1");
		XSSFRow r = b.getRow(x);
		XSSFCell c = r.getCell(y);
		return c.getStringCellValue();

	}

	public static String getIntegerData(int x, int y) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFile\\Salary.xlsx");
		a = new XSSFWorkbook(f);
		b = a.getSheet("Sheet1");
		XSSFRow r = b.getRow(x);
		XSSFCell c = r.getCell(y);
		int z = (int) c.getNumericCellValue();
		return String.valueOf(z);

	}

}
