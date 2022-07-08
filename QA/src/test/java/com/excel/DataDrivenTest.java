package com.excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.*;

public class DataDrivenTest {
    private WebDriver driver;
    private WriteExcelFile writeExcelFile;
    private ReadExcelFile readExcelFile;

    By searchBoxLocator = By.id("search_query_top");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationpractice.com/index.php");
    }

    @AfterClass
    public void tearDown() {
    }
}