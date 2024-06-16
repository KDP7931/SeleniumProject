package com.Kp.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Kp.qa.Base.BaseClass;
import com.Kp.qa.Pages.HomePage;


public class Utilites extends BaseClass{
	
	public Utilites() {
		// TODO Auto-generated constructor stub
	}
	public void dropDown(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		}
	public void dropDown(WebElement ele, int indexs)
	{
		Select s = new Select(ele);
		s.selectByIndex(indexs);
	}
	
	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver); 
		a.moveToElement(ele).perform();
	}
	
	public void doubleClickbtn(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public void draganddrop(WebDriver driver,WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	public void alertPopup(WebDriver driver) {
		driver.switchTo().alert();
	}
	
	public void frame(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	public void switchBackframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void scrollbar(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void switchTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b:child) {
		driver.switchTo().window(b);
		}
	}
	
	public void WaitelementtoClick(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,ExplicitWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	
	public void verify(WebDriver driver,String expected) {
		Assert.assertEquals(driver.getTitle(), expected);
	}
	public static boolean isEmpty(String strElementValue)
	{   
        System.out.print("\n"+strElementValue);
        if(strElementValue != "" && strElementValue!= null && !strElementValue.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
	}
	
	WebDriver driver;
	public  boolean isClickable(WebElement webe)      
	{
		
	    try
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, ExplicitWaitTime);
	        wait.until(ExpectedConditions.elementToBeClickable(webe));
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	}
	
	public int CalculateKGtoMG(int  Kg) {
		int mg = Kg * 1000000;
		System.out.println("Calculated mg:"+mg);
		return mg;	
	}
	
	public int CalculateKGtoG(int  Kg) {
		int g = Kg * 1000;
		System.out.println("Calculated mg:"+g);
		return g;	
	}
   //Get Current Date and Time.
	public String GetDateTime() {
		//SimpleFormat to Format the Date and Time.
			 
		//Get current date time with Date()
		Date datetime = new Date();
		//DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		String dt= dateFormat.format(datetime);	
		
		System.out.println("Current Captured date and time: " +dt);
		return dt;
	}
	
	public String ExpectedTimeDate(Date ExpDate, int sec) {
	
		String Exp = null ; 
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");	
		 // Convert Date to Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(ExpDate);
     // Perform addition/subtraction
        cal.add(Calendar.SECOND, sec);
        Date ModDate = cal.getTime();
        Exp = dateFormat.format(ModDate);
        System.out.println("Updated date and time: " +Exp);
		return Exp;
	}
	
	
	public void DragDrop(WebElement Source, WebElement Destination) {
        Actions act = new Actions(driver);
        act.dragAndDrop(Source, Destination).build().perform();
    }
	
	
	public void JsExecutorClick(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
	}

	public void ScrollToElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	
	public long getTimeDifference(String datetime1, String datetime2) throws ParseException {
	    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
	    Date date1 = dateFormat.parse(datetime1);
	    Date date2 = dateFormat.parse(datetime2);

	    // Calculate the time difference in milliseconds
	    long timeDifference = Math.abs(date1.getTime() - date2.getTime());

	    return timeDifference;
	}
	

		
	 public String[][] getDataFromExcel(String xlFilePath, String sheetName) throws IOException {
	        String[][] tabArray = null;
	        FileInputStream file = null;
	        Workbook workbook = null;
	        Sheet sheet = null;

	        try {
	            // Load the workbook
	            file = new FileInputStream(new File(xlFilePath));
	            workbook = WorkbookFactory.create(file);
	            sheet = workbook.getSheet(sheetName);

	            // Find the range of the sheet
	            int startRow = 1;
	            int endRow = sheet.getLastRowNum();
	            int startCol = Integer.MAX_VALUE; // Set initial value to maximum
	            int endCol = Integer.MIN_VALUE;   // Set initial value to minimum

	            // Determine the maximum and minimum column index
	            for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
	                Row row = sheet.getRow(rowNum);
	                if (row != null) {
	                    int firstCol = row.getFirstCellNum();
	                    int lastCol = row.getLastCellNum();
	                    startCol = Math.min(startCol, firstCol);
	                    endCol = Math.max(endCol, lastCol);
	                }
	            }

	            // Initialize tabArray
	            tabArray = new String[endRow - startRow + 1][endCol - startCol + 1];

	            // Read data from the sheet
	            for (int i = startRow; i <= endRow; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = startCol; j < endCol; j++) {
	                    Cell cell = row.getCell(j);
	                    if (cell != null) {
	                        if (cell.getCellType() == CellType.STRING) {
	                            tabArray[i - startRow][j - startCol] = cell.getStringCellValue();
	                        } else if (cell.getCellType() == CellType.NUMERIC) {
	                            tabArray[i - startRow][j - startCol] = String.valueOf(cell.getNumericCellValue());
	                        }
	                    }
	                }
	            }
	        } finally {
	            if (workbook != null) {
	                workbook.close();
	            }
	            if (file != null) {
	                file.close();
	            }
	        }
	        return tabArray;
	    }
	 
	 @DataProvider(name = "provideLoginData")
	  
		 public Object[][] provideLoginData() {

				Object[][] data = new Object[4][2];

				// 1st row
				data[0][0] = "mngr57651";
				data[0][1] = "EmEpypa";
				//2nd row
				data[1][0] = "mngr576516";
				data[1][1] = "EmEpyp";
				//3rd row
				data[2][0] = "mngr57651";
				data[2][1] = "EmEpyp";
				//4th row
				data[3][0] = "mngr576516";
				data[3][1] = "EmEpypa";
				return data;
			}

}
	 
