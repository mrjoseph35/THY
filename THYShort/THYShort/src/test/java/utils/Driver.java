package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<Browser> browsers = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }

    //TODO driveri güncelle
    public static WebDriver getDriver(Browser browser) {

        if (browsers.get()==null)
            browsers.set(browser);

        if (drivers.get() == null) {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--disable-web-security");
                    firefoxOptions.addArguments("--test-type");
                    firefoxOptions.addArguments("--disable-extensions");
                    firefoxOptions.addArguments("--allow-insecure-localhost");
                    firefoxOptions.addArguments("--ignore-urlfetcher-cert-requests");
                    firefoxOptions.addArguments("--disable-blink-features=AutomationControlled");
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--disable-web-security");
                    edgeOptions.addArguments("--test-type");
                    edgeOptions.addArguments("--disable-extensions");
                    edgeOptions.addArguments("--allow-insecure-localhost");
                    edgeOptions.addArguments("--ignore-urlfetcher-cert-requests");
                    edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
                    drivers.set(new EdgeDriver(edgeOptions));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-web-security");
                    chromeOptions.addArguments("--test-type");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--allow-insecure-localhost");
                    chromeOptions.addArguments("--ignore-urlfetcher-cert-requests");
                    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                    drivers.set(new ChromeDriver(chromeOptions));
                    break;
            }
        }
        return drivers.get();
    }

    public static void quitDriver(){
        if (drivers.get()!=null){
            drivers.get().quit();
            drivers.set(null);
        }
    }

    public static Browser getBrowser(){
        return browsers.get();
    }

    public static void setBrowser(Browser browser){
        browsers.set(browser);
    }

}
