package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Condition;
import utils.BaseTest;

import java.util.Map;

import static utils.Locators.*;

public class ticketStepdefs extends BaseTest {

    @Given("user on THY homepage")
    public void userOnTHYHomepage() {
        gotoURL(url);
        click(buttonCookieAccept);
    }

    @When("user select a ticket as follows")
    public void userSelectATicketAsFollows(DataTable table) {
        Map<String, String> map = table.asMap();
        String fromCity  = map.get("fromCity");
        String fromAirport  = map.get("fromAirport");
        String toCity  = map.get("toCity");
        String toAirport  = map.get("toAirport");
        String month  = map.get("month");
        String day  = map.get("day");

        sendkeys(portFrom, fromCity);
        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(portListWrapperFrom));
        dropDown.findElement(getXpathFromDropDown(fromAirport)).click();

        sendkeys(portTo, toCity);
        dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(portListWrapperTo));
        dropDown.findElement(getXpathFromDropDown(toAirport)).click();

        if (!find(calander).isDisplayed())
            click(calanderButton);
        waitFor(calanderButton, Condition.visible);
        WebElement curCalander = find(getCalander(month));
        curCalander.findElement(getXpathOfDay(day)).click();
    }

    @When("user select oneway")
    public void userSelectOneway() {
        clear(oneWay);
    }
}
