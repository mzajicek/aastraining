package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

public class CalculationTest extends TestBase {


    @Test
    public void ifShouldCalculateTotalIncome() {

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Batman's Cave Development");


        //1. vybrat fond, zadat sumu, roky, email
        //selectFund("Batman's Cave Development");
        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");

        //2. overit, ze Total Income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
//        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
//        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().contains("kr"));
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, zadat sumu, roky, email
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Batman's Cave Development");

        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");
        //2. overit, ze Interest Income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
//        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
//        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().contains("kr"));
        Assert.assertFalse(calculatorPage.getInterest().isEmpty());
        Assert.assertTrue(calculatorPage.getInterest().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, zadat sumu, roky, email
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Batman's Cave Development");
        calculatorPage.selectInvestment("1000");
        calculatorPage.selectYears("5");
        calculatorPage.selectEmail("test@test.sk");
        //2. overit, ze Risk nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
        //Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
        Assert.assertFalse(calculatorPage.getRisk().isEmpty());
    }

    @Test
    public void itShouldCalculateIncomeForEachFund(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        String[] arrayOfFunds={"Batman's Cave Development","Handelsbanken Aktiv 100","Hoggwart's Fund"};
        for (String arrayOfFund : arrayOfFunds) {
            calculatorPage.selectFund(arrayOfFund);
            calculatorPage.selectInvestment("1000");
            calculatorPage.selectYears("5");
            calculatorPage.selectEmail("test@test.sk");
            //Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
            //Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().contains("kr"));
            Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
            Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
        }
    }


}
