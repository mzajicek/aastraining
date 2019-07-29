package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest extends TestBase {


    @Test
    public void ifShouldCalculateTotalIncome() {
        //1. vybrat fond, zadat sumu, roky, email
        selectFund("Batman's Cave Development");
        selectInvestment("1000");
        selectYears("5");
        selectEmail("test@test.sk");

        //2. overit, ze Total Income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
//        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
//        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().contains("kr"));
        Assert.assertFalse(getTotalIncome().isEmpty());
        Assert.assertTrue(getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, zadat sumu, roky, email
        selectFund("Batman's Cave Development");
        selectInvestment("1000");
        selectYears("5");
        selectEmail("test@test.sk");
        //2. overit, ze Interest Income nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
//        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
//        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().contains("kr"));
        Assert.assertFalse(getInterest().isEmpty());
        Assert.assertTrue(getInterest().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, zadat sumu, roky, email
        selectFund("Batman's Cave Development");
        selectInvestment("1000");
        selectYears("5");
        selectEmail("test@test.sk");
        //2. overit, ze Risk nie je prazdny
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
        //Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
        Assert.assertFalse(getRisk().isEmpty());
    }

    @Test
    public void itShouldCalculateIncomeForEachFund(){
        String[] arrayOfFunds={"Batman's Cave Development","Handelsbanken Aktiv 100","Hoggwart's Fund"};
        for (String arrayOfFund : arrayOfFunds) {
            selectFund(arrayOfFund);
            selectInvestment("1000");
            selectYears("5");
            selectEmail("test@test.sk");
            //Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
            //Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().contains("kr"));
            Assert.assertFalse(getTotalIncome().isEmpty());
            Assert.assertTrue(getTotalIncome().contains("kr"));
        }
    }


    private String getTotalIncome(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }

    private String getInterest(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }

    private String getRisk(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }

    private void selectFund(String fundToSelect){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }



    private void selectInvestment(String investmentToSelect){
        driver.findElement(By.id("oneTimeInvestmentInput")).clear();
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investmentToSelect);
    }
    private void selectYears(String yearsToSelect){
        driver.findElement(By.id("yearsInput")).clear();
        driver.findElement(By.id("yearsInput")).sendKeys(yearsToSelect);
    }
    private void selectEmail(String emailToSelect){
        driver.findElement(By.id("emailInput")).clear();
        driver.findElement(By.id("emailInput")).sendKeys(emailToSelect);
    }



}
