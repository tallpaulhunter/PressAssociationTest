package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by paul.hunter on 09/08/2017.
 */
public class ClientSteps {
    WebDriver driver = new FirefoxDriver();

    @Given("^the user is on landing page$")
    public void setup() throws Throwable {
        driver.get("http://accountsdemo.herokuapp.com");
        driver.manage().window().maximize();
    }


    @When("^she chooses to sign up$")
    public void she_chooses_to_sign_up() throws Throwable {
        driver.findElement(By.linkText("Sign up")).click();
    }


    @And("^she provides the first name as ([^\"]*)$")
    public void she_provides_the_first_name_as(String firstName) throws Throwable {
        driver.findElement(By.id("user_first_name")).sendKeys(firstName);
    }


    @And("^she provides the last name as ([^\"]*)$")
    public void she_provides_the_last_name_as(String lastName) throws Throwable {
        driver.findElement(By.id("user_last_name")).sendKeys(lastName);
    }

    @And("^she provides the email as ([^\"]*)$")
    public void she_provides_the_email_as(String email) throws Throwable {
        driver.findElement(By.id("user_email")).sendKeys(email);
    }

    @And("^she provides the password as ([^\"]*)$")
    public void she_provides_the_password_as(String password) throws Throwable {
        driver.findElement(By.id("user_password")).sendKeys(password);
    }

    @And("^she provides the confirm password again as ([^\"]*)$")
    public void she_provides_the_confirm_password_again_as(String confirmPassword) throws Throwable {
        driver.findElement(By.id("user_password_confirmation")).sendKeys(confirmPassword);
    }


    @And("^she signs-up$")
    public void she_signs_up() throws Throwable {
        driver.findElement(By.name("commit")).click();
    }

    @Then("^she should be logged in to the application$")
    public void she_should_be_logged_in_to_the_application() throws Throwable {
        boolean signOutLinkDisplayed = driver.findElement(By.cssSelector("a[href='/users/sign_out']")).isDisplayed();
        Assert.assertTrue(signOutLinkDisplayed);
    }
}
