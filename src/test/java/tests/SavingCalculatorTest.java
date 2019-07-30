package tests;


import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;
import utils.MathUtils;

public class SavingCalculatorTest extends TestBase {

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

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Batman's Cave Development");
        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");
        //5. Overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

/* Stary sposob bez pouzitia metod
       //1. Vybrat fond
        //new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //2. Zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1000");
        //3. Zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        //4. Zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@test.sk");
        //5. Overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
*/

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

    @Test
    public void selectRandomFund() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.enterRandomFund();
        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");
        //5. Overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    /* Nedokoncene cakanie na nacitanie
    @Test
    public void itShouldWaitUntilTitleIsVisible() throws InterruptedException {
        try {
            new WebDriverWait(driver, 2)
                    .until()
        }
    }

     */

}
