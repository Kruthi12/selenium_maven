package com.test;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tabledemo {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6B.01.16\\Desktop\\Browser drivers\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  String url="http://10.232.237.143:443/TestMeApp";
	  driver.navigate().to(url);
	  System.out.println("The title of the webpage is"+driver.getTitle());
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.id("userName")).sendKeys("lalitha");
	  driver.findElement(By.name("password")).sendKeys("password123");
	  driver.findElement(By.name("Login")).click();
	  driver.findElement(By.xpath("//*[@id='menu3']/li[4]/a/span")).click();
	  WebElement objtable=driver.findElement(By.xpath("html/body/b/section/div"));
	  List<WebElement> allrows=objtable.findElements(By.tagName("tr"));
	  for(WebElement row:allrows) {
		  List<WebElement> cells=row.findElements(By.tagName("td"));
		  for(WebElement cell:cells) {
			  System.out.println(cell.getText());
		  }
	  }
	  for(int n=1;n<allrows.size();n++) {
		  List<WebElement> cells=allrows.get(n).findElements(By.tagName("td"));
		  System.out.println("Orderid: "+cells.get(0).getText());
		  System.out.println("Date of Order: "+cells.get(2).getText());
	  }
  }
}