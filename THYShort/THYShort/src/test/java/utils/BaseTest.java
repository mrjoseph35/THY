package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseTest(){
        this(Browser.CHROME);
    }

    protected BaseTest(Browser browser){
        driver = Driver.getDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void gotoURL(String url){
        driver.get(url);
    }

    public WebElement find(By locator){
        return waitFor(locator, Condition.exist);
    }

    public WebElement waitFor(By locator, Condition condition){
        switch (condition){
            case exist:
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            case visible:
            case appear:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case enable:
            case clickable:
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        return null;
    }

    public void click(By locator){
        WebElement element = waitFor(locator, Condition.visible);
        element.click();
    }

    public void clear(By locator){
        WebElement element = waitFor(locator, Condition.visible);
        element.clear();
    }

    public void sendkeys(By locator, String str){
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(str);
    }

    public void pressEnter(By locator){
        find(locator).sendKeys(Keys.ENTER);
    }

    public void scrollIntoView(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", find(locator));
    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getText(By locator){
        return waitFor(locator, Condition.visible).getText();
    }


    public void sendKeysByAction(By locator, String text){
        new Actions(driver).moveToElement(find(locator)).sendKeys(text).build().perform();
    }

    public void doubleClick(By locator){
        new Actions(driver).moveToElement(find(locator)).doubleClick().build().perform();
    }

    public void delText(By locator){
        new Actions(driver).moveToElement(find(locator)).sendKeys(Keys.DELETE).build().perform();
    }

    public By getSelectorOfTheday(String month, String day){
        return By.xpath("//*[@class='ui-datepicker-month' and text()='" + month +"']//ancestor::div[contains(@class, 'ui-datepicker-group')]//*[text()='" + day+ "']");
    }

}
