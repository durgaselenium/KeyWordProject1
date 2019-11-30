package com.qa.orange.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

public WebDriver driver;
public Properties prop;

public WebDriver init_driver(String browserName)
{
if (browserName.equals("chrome"))
{
if (prop.getProperty("headless").equals("yes"))
{
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
driver = new ChromeDriver(options);
}
else {
 System.setProperty("webdriver.chrome.silentOutput", "true");	
 driver = new ChromeDriver();	
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

}else if (browserName.equalsIgnoreCase("firefox"))
{
System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");	
driver = new FirefoxDriver();	
}	
return driver;
}

public Properties init_properites()
{
prop = new Properties();
try {
	FileInputStream fis = new FileInputStream("./Config/config.Properties");
	prop.load(fis);
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
return prop;
}
	
	
}
