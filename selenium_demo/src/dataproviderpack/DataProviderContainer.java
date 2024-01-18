package dataproviderpack;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderContainer {

	static FileInputStream fis = null;
	static String filepath = System.getProperty("user.dir") + "\\MyDataFiles\\Testdata.xlsx";

	@DataProvider(name = "logintestdata")
	public Object[][] logindata() {
		Object[][] data = new Object[][] { { "admin", "admin123" }, { "admin1", "admin123" },
				{ "admin2", "admin123" } };
		return data;

	}

	@DataProvider(name = "logintestdata1")
	public Object[][] logindata1() {
		Object[][] data = new Object[][] { { "admin1", "admin123" }, { "admin", "admin1234" },
				{ "admin", "admin123" } };
		return data;

	}

	@DataProvider(name = "dp4")
	public Iterator<String[]> data4() {
		List<String[]> list = new ArrayList<>();
		list.add(new String[] { "admin", "admin123" });
		list.add(new String[] { "admin1", "admin123" });
		return list.iterator();
	}

	@DataProvider(name = "dp3")
	public Iterator<String> data3() {
		List<String> list = new ArrayList<>();
		list.add("admin");
		list.add("admin123");
		list.add("admin1");
		list.add("admin123");
		return list.iterator();

	}

	@DataProvider(name = "readdata")
	public static Object[][] readData() throws Exception {
		fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("TestData");
		int noofrows = sh.getPhysicalNumberOfRows();
		int noofcols = sh.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[noofrows - 1][noofcols];

		for (int i = 1; i < noofrows; i++) {
			Row row = sh.getRow(i);
			for (int j = 0; j < noofcols; j++) {
				Cell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				String str = format.formatCellValue(cell);
				data[i - 1][j] = str;
			}
		}
		return data;
	}
}
