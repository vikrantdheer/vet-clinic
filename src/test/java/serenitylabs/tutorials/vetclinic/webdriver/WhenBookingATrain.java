package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WhenBookingATrain {
    WebDriver driver;

    @Before
    public void setup() {
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("phantomjs.binary.path", "D:\\Vikrant\\Softwares\\Drivers\\phantom\\bin\\phantomjs.exe");
        driver = new PhantomJSDriver(capabilities);*/

        System.setProperty("webdriver.chrome.driver", "D:\\Vikrant\\Softwares\\Drivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void should_be_able_to_plan_a_trip() {
        driver.findElement(By.id("display_origin")).sendKeys("Town Hall");
        driver.findElement(By.id("display_destination")).sendKeys("Parramatta");

        WebElement arriveOrDepartRadioButton = driver.findElement(By.cssSelector("[value=arr]"));
        assertThat(arriveOrDepartRadioButton.isEnabled(), is(true));

        arriveOrDepartRadioButton.click();

        Select hour = new Select(driver.findElement(By.id("itdTimeHour")));
        hour.selectByVisibleText("10");


        Select minute = new Select(driver.findElement(By.id("itdTimeMinute")));
        minute.selectByVisibleText("15");

        WebElement submitButton = driver.findElement(By.id("btnTripPlannerSubmit"));
        assertThat(submitButton.isEnabled(), is(true));

        submitButton.click();

        List<WebElement> journeyOptions = driver.findElements(By.cssSelector(".journeyValue"));
        assertThat(journeyOptions.size(), is(greaterThan(0)));


        WebElement origin = driver.findElement(By.id("name_origin"));
        assertThat(origin.getAttribute("value"), containsString("Town Hall"));

        WebElement destination = driver.findElement(By.id("name_destination"));
        assertThat(destination.getAttribute("value"), containsString("Parramatta"));

        Select selectedArriveOrDepart = new Select(driver.findElement(By.id("SelectArriveDepart")));
        assertThat(selectedArriveOrDepart.getFirstSelectedOption().getAttribute("value"), is(equalTo("arr")));

        Select selectedHour  = new Select(driver.findElement(By.id("selectHour")));
        assertThat(selectedHour.getFirstSelectedOption().getText(), is(equalTo("10")));

        Select selectedMinute  = new Select(driver.findElement(By.id("selectMinute")));
        assertThat(selectedMinute.getFirstSelectedOption().getText(), is(equalTo("15")));

        Select selectedDay  = new Select(driver.findElement(By.id("itdDateDayMonthYear")));
        assertThat(selectedDay.getFirstSelectedOption().getText(), containsString("Today"));
    }

    /*@After
    public void shutdown() {
        driver.quit();
    }*/
}
