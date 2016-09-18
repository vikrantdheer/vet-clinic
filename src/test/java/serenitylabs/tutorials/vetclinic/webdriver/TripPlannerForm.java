package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;
import static serenitylabs.tutorials.vetclinic.webdriver.Traveller.TIME_UNIT_FORMAT;

public class TripPlannerForm {

    @FindBy(id = "itdDate")
    public WebElement travelDay;

    @FindBy(id = "itdTimeHour")
    public WebElement timeHour;

    @FindBy(id = "itdTimeMinute")
    public WebElement timeMinute;

    @FindBy(id = "display_destination")
    public WebElement destination;

    @FindBy(id = "display_origin")
    public WebElement origin;

    @FindBy(name = "btnTripPlannerSubmit")
    public WebElement submitButton;

    static final Map<DeparturePreference, By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();

    static {
        DEPARTURE_RADIO_BUTTONS.put(ArriveBefore, By.id("itdTripDateTimeArr"));
        DEPARTURE_RADIO_BUTTONS.put(LeaveAfter, By.id("itdTripDateTimeDep"));
    }

    public static By departureButtonFor(DeparturePreference departurePreference) {
        return DEPARTURE_RADIO_BUTTONS.get(departurePreference);
    }

    public void arriveOrDepartTimeIn(int hour, int minute) {
        Select hourList = new Select(timeHour);
        hourList.selectByVisibleText(TIME_UNIT_FORMAT.format(hour));

        Select minuteList = new Select(timeMinute);
        minuteList.selectByVisibleText(TIME_UNIT_FORMAT.format(minute));
    }
}
