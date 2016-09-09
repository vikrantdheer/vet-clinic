package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class WhenAddingATodoItem {

    WebDriver driver;

    @Before
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("phantomjs.binary.path","D:\\Vikrant\\Softwares\\Drivers\\phantom\\bin\\phantomjs.exe");
        driver = new PhantomJSDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void should_add_new_item_to_list() {

        // GIVEN
        driver.get("http://todomvc.com/examples/angularjs/#/");

        // WHEN
        WebElement inputField = driver.findElement(By.id("new-todo"));
        inputField.sendKeys("Buy some milk");
        inputField.sendKeys(Keys.RETURN);

        // THEN
        WebElement todoListContents = driver.findElement(By.id("todo-list"));
        assertThat(todoListContents.getText(), containsString("Buy some milk"));

        driver.quit();
    }

}
