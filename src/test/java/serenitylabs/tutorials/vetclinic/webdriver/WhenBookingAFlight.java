package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static serenitylabs.tutorials.vetclinic.webdriver.Cities.*;
import static serenitylabs.tutorials.vetclinic.webdriver.ClassType.*;
import static serenitylabs.tutorials.vetclinic.webdriver.Services.*;
import static serenitylabs.tutorials.vetclinic.webdriver.TripType.*;
import static serenitylabs.tutorials.vetclinic.webdriver.TypeOfService.*;

public class WhenBookingAFlight {
    WebDriver driver;

    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Vikrant\\Softwares\\Drivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
    }

    @Test
    public void vikrant_should_be_able_to_book_a_flight() {

        checkFor(International, Flights);

        TripType(OneWayTrip);

        departureAirport(PNQ);

        arrivalAirport(LHR);

        departingOn(25, 9, 2016);

        noOfAdultChildInfant(4, 2, 1);

        classType(Business);

        includeNearByAirports(true);

        bookYourService();

        checkArrivalTimings("12pm-9pm");

        List<WebElement> journeyOptions = driver.findElements(By.linkText("Book"));
        assertThat(journeyOptions.size(), is(greaterThan(0)));
    }

    private static final HashMap<Services, org.openqa.selenium.By> SERVICES_MAP = new HashMap<>();

    private static final HashMap<TripType, org.openqa.selenium.By> TRIP_TYPE = new HashMap<>();

    static {
        SERVICES_MAP.put(Flights, By.cssSelector("[data-code=F]"));
        SERVICES_MAP.put(Hotels, By.cssSelector("[data-code=H]"));

        TRIP_TYPE.put(OneWayTrip, By.id("one_way_button1"));
        TRIP_TYPE.put(RoundTrip, By.id("round_trip_button1"));
        TRIP_TYPE.put(MultiCityTrip, By.id("multi_city_button"));
    }

    private void checkFor(TypeOfService typeOfService, Services service) {
        driver.findElement(SERVICES_MAP.get(service)).click();
        driver.findElement(By.linkText(typeOfService.toString())).click();
    }

    private void TripType(TripType tripType) {
        WebElement tripTypeRadioButton = driver.findElement(TRIP_TYPE.get(tripType));
        assertThat(tripTypeRadioButton.isEnabled(), is(true));
        tripTypeRadioButton.click();
    }

    private void departureAirport(Cities departureCity) {
        driver.findElement(By.id("from_typeahead1")).clear();
        WebElement originField = driver.findElement(By.id("from_typeahead1"));
        originField.sendKeys(departureCity.toString());
        originField.sendKeys(Keys.RETURN);
    }

    private void arrivalAirport(Cities arrivalCity) {
        driver.findElement(By.id("to_typeahead1")).clear();
        WebElement destinationField = driver.findElement(By.id("to_typeahead1"));
        destinationField.sendKeys(arrivalCity.toString());
        destinationField.sendKeys(Keys.RETURN);
    }

    private void departingOn(int date, int month, int year) {
        driver.findElement(By.id("start_date_sec")).click();
        String ofDate = "[fare-date='" + date + "-" + (month - 1) + "-" + year + "']";
        driver.findElement(By.cssSelector(ofDate)).click();
    }

    private void noOfAdultChildInfant(int noOfAdults, int noOfChildren, int noOfInfants) {
        if (noOfAdults != 0) {
            WebElement adultCountIncrementer = driver.findElement(By.cssSelector("[tabindex='29']"));
            for (int i = 1; i < noOfAdults; i++) {
                adultCountIncrementer.click();
            }
        }

        if (noOfChildren != 0) {
            WebElement childrenCountIncrementer = driver.findElement(By.cssSelector("[tabindex='31']"));
            for (int i = 0; i < noOfChildren; i++) {
                childrenCountIncrementer.click();
            }
        }

        if (noOfInfants != 0) {
            WebElement infantCountIncrementer = driver.findElement(By.cssSelector("[tabindex='33']"));
            for (int i = 0; i < noOfInfants; i++) {
                infantCountIncrementer.click();
            }
        }
    }

    private void classType(ClassType classType) {
        Select classSelector = new Select(driver.findElement(By.id("class_selector")));
        classSelector.selectByIndex(classType.getIndex());
    }

    private void includeNearByAirports(boolean includeNearAirports) {
        WebElement includeAirPortsCheck = driver.findElement(By.id("includeAirPorts_check"));
        assertThat(includeAirPortsCheck.isEnabled(), is(includeNearAirports));
        includeAirPortsCheck.click();
    }

    private void bookYourService() {
        WebElement submitButton = driver.findElement(By.id("flights_submit"));
        assertThat(submitButton.isEnabled(), is(true));
        submitButton.click();
    }

    private void checkArrivalTimings(String timeSlot) {
        driver.findElement(By.linkText("ARRIVAL")).click();
        driver.findElement(By.cssSelector("[data-key=\"timeBucketFilter('0,1,2')\"]")).click();
    }
}
