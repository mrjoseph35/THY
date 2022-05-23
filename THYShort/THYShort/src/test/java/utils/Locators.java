package utils;

import org.openqa.selenium.By;

public interface Locators {

    String url = "https://www.turkishairlines.com";

    By buttonCookieAccept = By.id("cookieWarningAcceptId");

    // Flight form
    By oneWay = By.xpath("//div[@class='booker-menu']/a[2]");
    By portFrom = By.id("portInputFrom");
    By portFromButton = By.xpath("//div[@class='selected-port-button'][.//parent::div/input[@id='portInputFrom']]");
    By portListWrapperFrom = By.xpath("(//div[@class='port-list-wrapper'])[1]");

    By portTo = By.id("portInputTo");
    By portListWrapperTo = By.xpath("(//div[@class='port-list-wrapper'])[2]");
    By calanderButton = By.id("calendarPlaceholder");
    By calander = By.cssSelector("div#singleCityCalendarHolder");
    By selectFlightDate1 = By.id("selectFlightDate01");
    By selectFlightDate2 = By.id("selectFlightDate02");
    By calanderOk = By.xpath("//a[@aria-label='OK']");
    By submitButton = By.cssSelector("a[name='submit']");
    By continueButton = By.cssSelector(".complete-button button");
    static By getXpathFromDropDown(String str){
        return By.xpath(".//*[@data-value='" + str + "']");
    }

    static By getCalander(String month){
        return By.xpath("//*[@class='ui-datepicker-month' and text()='" + month +"']//ancestor::div[contains(@class, 'ui-datepicker-group')]");
    }
    static By getXpathOfDay(String day){
        return By.xpath(".//*[text()='" + day+ "']");
    }

    static By getNtheFlightLocator(int n){
        return By.xpath("(//div[starts-with(@class, 'price-col')])[" + n + "]");
    }

    static By getNthePriceLocator(int n){
        return By.xpath("(//div[@class='price-box']//a[@class='select-button'])[" + n + "]");
    }


}
