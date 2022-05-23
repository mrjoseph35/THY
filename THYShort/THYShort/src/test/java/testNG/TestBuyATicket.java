package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import utils.Condition;
import utils.Driver;
import utils.BaseTest;

import static utils.Locators.*;

public class TestBuyATicket extends BaseTest {

    @Test(priority = 1)
    public void gotoURL(){
        driver.get(url);
        click(buttonCookieAccept);
    }

    @Test(priority = 2)
    public void selectFlight(){
        scrollIntoView(oneWay);
        click(oneWay);
        sendkeys(portFrom, "Istanbul");
        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(portListWrapperFrom));
        dropDown.findElement(getXpathFromDropDown("SAW")).click();

        sendkeys(portTo, "Ankara");
        dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(portListWrapperTo));
        dropDown.findElement(getXpathFromDropDown("ESB")).click();

        By dayLocator = getSelectorOfTheday("Mai", "24");
        scrollIntoView(dayLocator);
        click(dayLocator);
        click(calanderOk);
        click(submitButton);
    }

    @Test(priority = 3)
    public void selectFlightAndClass(){
        waitFor(getNtheFlightLocator(1), Condition.visible);
        click(getNtheFlightLocator(1));
        click(getNthePriceLocator(1));
        click(continueButton);
    }

    @Test(priority = 4)
    public void fillThePersonelForm(){

    }

    @AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }

}
