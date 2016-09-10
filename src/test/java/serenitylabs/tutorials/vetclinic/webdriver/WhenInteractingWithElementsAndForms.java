package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhenInteractingWithElementsAndForms {
    WebDriver driver;

    @Before
    public void setup() {
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setJavascriptEnabled(true);
        //capabilities.setCapability("phantomjs.binary.path", "D:\\Vikrant\\Softwares\\Drivers\\phantom\\bin\\phantomjs.exe");
        //driver = new PhantomJSDriver(capabilities);

        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void entering_a_field_value() {

        // TODO: Enter 'Town Hall' into the 'From' field
        WebElement originField = driver.findElement(By.id("display_origin"));
        originField.sendKeys("Town Hall");

        String displayedValue = originField.getAttribute("value");
        assertThat(displayedValue, equalTo("Town Hall"));
    }

    @Test
    public void click_on_a_button() {
        // TODO: Click on the View Trip button
        driver.findElement(By.id("display_origin")).sendKeys("Town Hall");
        driver.findElement(By.id("display_destination")).sendKeys("Parramatta");
        driver.findElement(By.id("btnTripPlannerSubmit")).click();

        String title = driver.findElement(By.tagName("h1")).getText();
        assertThat(title, is("Plan your trip"));
    }

    @Test
    public void click_on_a_checkbox() {
        // TODO: Click on the Remember Me checkbox
        WebElement rememberCheckBox = driver.findElement(By.id("chkPlannerRemember"));
        assertThat(rememberCheckBox.isEnabled(), is(true));

        rememberCheckBox.click();

        Boolean rememberMeChoice = rememberCheckBox.isSelected();
        assertThat(rememberMeChoice, is(true));
    }

    @Test
    public void click_on_a_radio_button() {

        // TODO: Choose the 'Leave After' option and make sure it is the one selected
        WebElement leaveOrArriveRadioButton = driver.findElement(By.cssSelector("[value=dep]"));
        assertThat(leaveOrArriveRadioButton.isEnabled(), is(true));

        leaveOrArriveRadioButton.click();

        String leaveOrArrivePreference = leaveOrArriveRadioButton.getAttribute("value");

        assertThat(leaveOrArrivePreference, is("dep"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm
        Select selectHour = new Select(driver.findElement(By.id("itdTimeHour")));
        selectHour.selectByVisibleText("12");

        String selectedHour = selectHour.getFirstSelectedOption().getText();

        assertThat(selectedHour, is("12"));
    }

   /* @After
    public void shutdown() {
        driver.quit();
    }*/
}
