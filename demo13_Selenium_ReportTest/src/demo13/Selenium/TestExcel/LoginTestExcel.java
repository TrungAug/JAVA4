package demo13.Selenium.TestExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestExcel {
	public WebDriver driver;
	
	// khai báo workbook và worksheet
	
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	
	
	//biến ghi kết quả ra file excel
	
	private Map<String, Object[]> testNGResult;
	
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
			worksheet=workbook.getSheet(sheet);
			if(worksheet==null) {
				System.out.println("Không tìm thấy workSheet " +sheet);
			}else {
				//Đọc dữ liệu từ sheet tìm thấy
				Iterator<Row> rows = worksheet.iterator();//đọc từng dòng dữ liệu trong sheet
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
							Cell cell = cells.next();
							if(cell.getColumnIndex()==0) {
								key = dataFmt.formatCellValue(cell);
							}else if(cell.getColumnIndex()==1) {
								username=dataFmt.formatCellValue(cell);
							}else if(cell.getColumnIndex()==2) {
								password=dataFmt.formatCellValue(cell);
							}else if(cell.getColumnIndex()==3) {
								expected=dataFmt.formatCellValue(cell);
							}
							String [] myArr= {username,password,expected};
							dataLogin.put(key, myArr);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//chụp hình
	public void takeScreenShot(WebDriver driver, String outputScreen) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(outputScreen));
	}

	public void writeImg(String imgSrc, Row row, Cell cell, XSSFSheet sheet) throws IOException {
		InputStream is = new FileInputStream(imgSrc);
		byte[] bytes = IOUtils.toByteArray(is);
		int idImg = worksheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
		is.close();

		XSSFDrawing drawing = worksheet.createDrawingPatriarch();
		ClientAnchor anchor = new XSSFClientAnchor();

		anchor.setCol1(cell.getColumnIndex() + 1);
		anchor.setRow1(row.getRowNum());
		anchor.setCol2(cell.getColumnIndex() + 2);
		anchor.setRow2(row.getRowNum() + 1);

		drawing.createPicture(anchor, idImg);
	}

	@BeforeClass
	public void suiteTest() {
		try {
			System.out.println(1);
			testNGResult = new LinkedHashMap<String, Object[]>();
			System.setProperty("webdriver.chrome.driver",
					"D:\\5. FALL 2023\\Kiem Thu Nang Cao\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(2);
			
			
			workbook = new XSSFWorkbook(new FileInputStream(new File(EXECL_DIR + "Book1.xlsx")));
			System.out.println(3);
			worksheet = workbook.getSheet("testDataLogin");
			readDataFromExcel();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println(4);
			workbook = new XSSFWorkbook();
			worksheet = workbook.createSheet("TestNG Result Summary");
			System.out.println(5);
			CellStyle rowStyle = workbook.createCellStyle();
			rowStyle.setAlignment(HorizontalAlignment.CENTER);
			rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			rowStyle.setWrapText(true);
			System.out.println(6);
			testNGResult.put("1", new Object[] { "Test Step No.", "Action", "Username", "Password", "Expected Output",
					"Actual Output", "Status", "Link", "Image" });
			System.out.println(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void LoginTest() throws Exception {
		try {
			Set<String> keySet = dataLogin.keySet();
			int index = 1;
			for (String key : keySet) {
				String[] value = dataLogin.get(key);
				String username = value[0];
				String password = value[1];
				String expected = value[2];

				//String url = "https://phptravels.net/login";
				String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
				driver.navigate().to(url);
				//driver.get(url);

//				driver.findElement(By.name("email")).sendKeys(username);
//				driver.findElement(By.name("password")).sendKeys(password);
//
//				Thread.sleep(1000);
//				driver.findElement(By.id("submitBTN")).click();
				driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

				String actualHeader = driver.getTitle();
				Thread.sleep(1000);

				if (actualHeader.equalsIgnoreCase(expected)) {
					testNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index),
									"Test Login susscess with valid username and password", username, password,
									expected, actualHeader, "PASS", "" });
				} else {
					String path = IMAGE_DIR + "failure" + System.currentTimeMillis() + ".png";
					takeScreenShot(driver, path);
					testNGResult.put(String.valueOf(index + 1),
							new Object[] { String.valueOf(index), "Test Login fail with invalid username and password",
									username, password, expected, actualHeader, "FAILED", path.replace("\\", "/") });
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void suiteTearDown() {
		Set<String> keyset = testNGResult.keySet();
		int rownum = 0;
		for (String key : keyset) {
			CellStyle rowStyle = workbook.createCellStyle();
			Row row = worksheet.createRow(rownum++);
			Object[] objArr = testNGResult.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}

				if (obj.toString().contains("failure") && obj.toString().contains(".png")) {
					try {
						row.setHeightInPoints(80);
						writeImg(obj.toString(), row, cell, worksheet);
						CreationHelper creationHelper = worksheet.getWorkbook().getCreationHelper();
						XSSFHyperlink hyperlink = (XSSFHyperlink) creationHelper.createHyperlink(HyperlinkType.URL);

						cell.setCellValue("full img");
						hyperlink.setAddress(obj.toString().replace("\\", "/"));
						cell.setHyperlink(hyperlink);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(new File("EXCEL_DIR" + "SaveTestNGResultToExecl.xlsx"));
				workbook.write(out);
				out.close();
				System.out.println("Susscessfully saved Selenium WebDriver TestNG result to Excel file");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
	}
	
}
