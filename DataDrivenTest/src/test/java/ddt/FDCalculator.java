package ddt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FDCalculator {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		String filePath = System.getProperty("user.dir")+"\\testData\\caldata.xlsx";
		
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1"); 
		
		for(int i=1;i<=rows;i++) {
			
			//read data from excel
			String pri = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateofinterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String pri2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//pass above data into excel
			if(i==1) {
				driver.findElement(By.xpath("//button[text()='No thanks']")).click();
				
			}
			driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys(pri);
			driver.findElement(By.xpath("//*[@id=\"interest\"]")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//*[@id=\"tenure\"]")).sendKeys(per1);
			
			Select per2drop = new Select(driver.findElement(By.id("tenurePeriod")));
			per2drop.selectByVisibleText(pri2);
			
			
			Select fredrop = new Select(driver.findElement(By.xpath("//*[@id=\"frequency\"]")));
			fredrop.selectByVisibleText(fre);
			
			
			
			 driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			 
			

			//validation
			
			String act_mvalue =  driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			System.err.println("Actual Value :"+act_mvalue+"\t Expected Value:"+exp_mvalue);
			if(Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}else {

				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath,"Sheet1", i, 7);
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='cal_div']//a[2]")).click();
		}//ending of for loop
		driver.quit();
		
	}

}
