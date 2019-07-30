package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Batman's Cave Development");
        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");

        //precitat zo stranky total income
        String calculatedIncome = calculatorPage.getTotalIncome();
        //vytvorit novy saving request
        calculatorPage.submitRequest();
        //overim, ze total income sa zobrazi v requeste
        //System.out.println(driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class,'amounts')]/p/span")).getText());

        //pomocou xpath
        Assert.assertEquals(calculatedIncome,
                driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class,'amounts')]/p/span")).getText());

        //pomocou cssSelectoru
        Assert.assertEquals(calculatedIncome,
                driver.findElement(By.cssSelector("ul.saving-list > li div.amounts > p > span")).getText());

    }

    @Test
    public void itShouldDisplayFundInNewRequest() {
        String vFund = "Batman's Cave Development";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund(vFund);
        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");

        //precitat zo stranky total income
        String calculatedIncome = calculatorPage.getTotalIncome();
        //vytvorit novy saving request
        calculatorPage.submitRequest();
        Assert.assertEquals(vFund,
                driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div/p[contains(@class,'fund-description')]")).getText());
    }

}
