package demo13.Selenium.TestExcel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class LoginTestExcel {
	public WebDriver driver;
	
	// khai báo workbook và worksheet
	
	private XSSFWorkbook workbook;
	private XSSFSheet workshet;
	
	
	//biến ghi kết quả ra file excel
	
	private Map<String, Object[]> testNgResult;
	
	//biến lưu trữ dữ liệu đọc từ file excel;
	private Map<String, String[]> dataLogin;
	
	
	//đường dẫn của file excel
	private final String EXECL_DIR="D:\\5. FALL 2023\\Java4\\BaiLab\\demo13_Selenium_ReportTest\\Resources\\data";
	
	//đường dẫn đến thư mục imgae
	private final String IMAGE_DIR="D:\\5. FALL 2023\\Java4\\BaiLab\\demo13_Selenium_ReportTest\\Resources\\image";
	
	//đọc dữ liệu từ file excel
	
	private void readDataFromExcel() {
		try {
			dataLogin = new HashMap<String, String[]>();
			String sheet="Test-data-login";
			workshet=workbook.getSheet(sheet);
			if(workshet==null) {
				System.out.println("Không tìm thấy workSheet " +sheet);
			}else {
				//Đọc dữ liệu từ sheet tìm thấy
				Iterator<Row> rows = workshet.iterator();//đọc từng dòng dữ liệu trong sheet
				DataFormatter dataFmt = new DataFormatter(); //đọc data chính xác
				while (rows.hasNext()) {
					Row row = rows.next();
					if(row.getRowNum()>=1) {
						Iterator<Cell> cells = row.cellIterator();
						String key = "";
						String username="";
						String password="";
						String expected="";
						while(cells.hasNext()) {
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
