package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class apachepoi_1 {
  @Test
  public void f() throws IOException, InterruptedException {
	  File src=new File("C:\\Users\\training_b6B.01.16\\Desktop\\testdata.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sh=wb.getSheetAt(0);
	  System.out.println("First row number:"+sh.getFirstRowNum());
	  System.out.println("Last row number:"+sh.getLastRowNum());
	  int rowcount=sh.getLastRowNum()-sh.getFirstRowNum();
	  System.out.println("The total rowcount is "+rowcount);
	  //System.out.println(sh.getRow(0).getCell(0).getStringCellValue()+"\t\t\t"+sh.getRow(0).getCell(1).getStringCellValue());
	  //System.out.println(sh.getRow(1).getCell(0).getStringCellValue()+"\t\t\t"+sh.getRow(1).getCell(1).getStringCellValue());
	  for(int i=1;i<=rowcount;i++) {
		  System.out.println(sh.getRow(i).getCell(0).getStringCellValue()+"\t\t\t"+sh.getRow(i).getCell(1).getStringCellValue());
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6B.01.16\\Desktop\\Browser drivers\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
	  driver.findElement(By.id("password")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
	  driver.findElement(By.name("Login")).click();
	  Thread.sleep(2000);
	  driver.close();
	  //wb.close();
	  }
	  //writing to excel file
	  /*XSSFRow header=sh.getRow(0);
	  XSSFCell header2=header.createCell(2);
	  header2.setCellValue("Status");
	  sh.getRow(1).createCell(2).setCellValue("Pass");
	  sh.getRow(2).createCell(2).setCellValue("Fail");
	  FileOutputStream fos=new FileOutputStream(src);
	  wb.write(fos);
	  wb.close();*/
	  ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\training_b6B.01.16\\Desktop\\extentreport.html");
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(reporter);
	  ExtentTest logger=extent.createTest("DemoWebShop");
	  logger.log(Status.INFO, "Apache Poi is used in this test script");
	  logger.log(Status.PASS, "Excel data reading is done successfully");
	  logger.log(Status.FAIL,MarkupHelper.createLabel("This test case is fail",ExtentColor.INDIGO));
	  extent.flush();
	  //driver.close();
  }
}