package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SavingCalculatorTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void itShouldDisplayTitle() {
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
        //Thread.sleep(5000);
    }

    @Test
    public void itShouldDisableApplyButtonOnPage() {
        //driver.findElement(By.cssSelector("button.btn-block")).isEnabled();
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldEnableApplyButton() {
        //1. Vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");

        //2. Zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        //3. Zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        //4. Zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@test.sk");
        //5. Overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldNotSelectAnyFundOnPageOpen() {
        //new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        //System.out.println(new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());

        Assert.assertEquals(
                "Select your fund",
                new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText()
        );
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
