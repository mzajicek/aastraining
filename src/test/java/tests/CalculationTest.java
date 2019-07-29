package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest {

    WebDriver driver; //premenna driver

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void ifShouldCalculateTotalIncome(){
        //1. vybrat fond, zadat sumu, roky, email
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("info@test.sk");
        //2. overit, ze Total Income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
    }

    @Test
    public void ifShouldCalculateInterestIncome(){
        //1. vybrat fond, zadat sumu, roky, email
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("info@test.sk");
        //2. overit, ze Interest Income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
    }

    @Test
    public void ifShouldCalculateRisk(){
        //1. vybrat fond, zadat sumu, roky, email
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("info@test.sk");
        //2. overit, ze Risk nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
