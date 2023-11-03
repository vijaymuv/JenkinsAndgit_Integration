package runner;

import Utilities.UtilityFiles;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class Adactin_Runnable {
       WebDriver driver;

       @BeforeTest()
	   void setUp(){
		driver = UtilityFiles.browserLaunch("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}
        @Test(dataProvider = "datasAdactin1",dataProviderClass = Adactin_Runnable.class)
		void loginAndBookHotel(String url1,String username1,String password1, String location1 ,String hotels1,
				String room, String roomno, String in, String out,String adroom,String croom, String fname, String lname ,String desc, String Cardno,String ctype, String month1,String year1,String cvv1) throws InterruptedException {
			driver.get(url1);
			WebElement user_name = driver.findElement(By.xpath("//input[@id='username']"));
			user_name.sendKeys(username1);
			WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
			pass.sendKeys(password1);
			WebElement login = driver.findElement(By.xpath("//input[@class='login_button']"));
			login.click();
			Thread.sleep(3000);

				WebElement location = driver.findElement(By.xpath("//select[@name='location']"));
				Select s  = new Select(location);
				s.selectByVisibleText(location1);
				WebElement hotels = driver.findElement(By.xpath("//select[@name='hotels']"));
				Select s1 = new Select(hotels);
				s1.selectByVisibleText(hotels1);
				WebElement room_type = driver.findElement(By.xpath("//select[@name='room_type']"));
				Select s3 = new Select(room_type);
				s3.selectByVisibleText(room);
				WebElement room_no = driver.findElement(By.xpath("//select[@name='room_nos']"));
				Select s4 = new Select(room_no);
				s4.selectByVisibleText(roomno);
				WebElement check_in = driver.findElement(By.xpath("//input[@name='datepick_in']"));
				check_in.sendKeys(in);
				WebElement check_out = driver.findElement(By.xpath("//input[@name='datepick_out']"));
				check_out.sendKeys(out);
				WebElement adult_per_room = driver.findElement(By.xpath("//select[@name='adult_room']"));
				Select s5 = new Select(adult_per_room);
				s5.selectByVisibleText(adroom);
				WebElement children_pr = driver.findElement(By.xpath("//select[@name='child_room']"));
				Select a = new Select(children_pr);
				a.selectByVisibleText(croom);

				WebElement search_btn = driver.findElement(By.xpath("//input[@id='Submit']"));
				search_btn.click();
				WebElement search_hotel = driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
				search_hotel.click();
				WebElement continue_btn = driver.findElement(By.xpath("//input[@id='continue']"));
				continue_btn.click();
				WebElement First_name = driver.findElement(By.xpath("//input[@id='first_name']"));
				First_name.sendKeys(fname);
				WebElement last_name = driver.findElement(By.xpath("//input[@id='last_name']"));
				last_name.sendKeys(lname);
				WebElement text_area = driver.findElement(By.xpath("//textarea[@name='address']"));
				text_area.sendKeys(desc);
				WebElement creditcard_no = driver.findElement(By.xpath("//input[@id='cc_num']"));
				creditcard_no.sendKeys(Cardno);
				WebElement card_type = driver.findElement(By.xpath("//select[@id='cc_type']"));
				Select  b = new Select(card_type);
				b.selectByVisibleText(ctype);
				WebElement expired_mon = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
				Select c = new Select(expired_mon);
				c.selectByVisibleText(month1);
				WebElement expired_year = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
				Select d = new Select(expired_year);
				d.selectByVisibleText(year1);
				WebElement cvv_no = driver.findElement(By.xpath("//input[@id='cc_cvv']"));
				cvv_no	.sendKeys(cvv1);
				WebElement book_now_btn= driver.findElement(By.xpath("//input[@id='book_now']"));
				book_now_btn.click();

 	   }
	@AfterTest
	void closeBrowser(){
		WebElement logout_btn = driver.findElement(By.xpath("//a[.='Logout']"));
		logout_btn.click();
		driver.close();
	}
	@DataProvider(name="datasAdactin1")
	public String[][] datas1() {
		File f = new File("C:\\A_files\\Adactin_Datas.xlsx");
		String[][] datasAdactin;
		try {
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet("Adactin");
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(0).getLastCellNum();

			datasAdactin = new String[lastRowNum][lastCellNum];

			for (int i = 1; i <=lastRowNum; i++) {
				for (int j = 0; j < lastCellNum; j++) {

					DataFormatter dataFormatter = new DataFormatter();
					datasAdactin[i-1][j] = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return datasAdactin;

	}
}
