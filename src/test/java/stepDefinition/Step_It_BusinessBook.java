package stepDefinition;

import Utilities.UtilityFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesOfItBusinessBook.ObjectOfAllClasses;
import pagesOfItBusinessBook.ProfilePage;

import java.io.*;
import java.util.Properties;

public class Step_It_BusinessBook extends UtilityFiles {

      Logger log = Logger.getLogger(Step_It_BusinessBook.class);
     public static FileReader  reader;
    public static Properties  p = new Properties();
    static {
        try {
            reader = new FileReader("C:\\Users\\Friday\\IdeaProjects\\Project_Interview\\src\\test\\resources\\datas.properties");
            p.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static WebDriver driver=UtilityFiles.browserLaunch(p.getProperty("browser"));;
    public static ObjectOfAllClasses  obj = new ObjectOfAllClasses(driver);
    @Given("user navigates to the website")
    public void userNavigatesToTheWebsite() throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        log.info("user enters url into the browser");
        driver.get(p.getProperty("url"));
    }
    @When("User clicks on Sign up and it switches to Sign up Options")
    public void userClicksOnSignUpAndItSwitchesToSignUpOptions() {
        log.info("User clicks on Sign up and it switches to Sign up Options");
      clickBtn(obj.getSignup().getSignUpBtn());

    }
    @When("user enters firstname {string}")
    public void userEntersFirstname(String firstname) {

        log.info("user enters firstname ");
        sendKeysElement(obj.getSignup().getFirstname(), firstname);
    }
    @When("user enters lastname {string}")
    public void userEntersLastname(String lastname) {
        log.info("user enters lastname");

        sendKeysElement(obj.getSignup().getLastname(), lastname);
    }
    @When("user types Email into {string} text box")
    public void userTypesEmailIntoTextBox(String email) {

        log.info("user types Email into text box");
        sendKeysElement(obj.getSignup().getEmail(), email);
    }
    @When("user types password {string}")
    public void userTypesPassword(String pass) {

        log.info("user types password ");
        sendKeysElement(obj.getSignup().getPass(), pass);
    }
    @When("user clicks on Terms\\/Conditions checkbox.")
    public void userClicksOnTermsConditionsCheckbox() {

        log.info("user clicks on Terms & Conditions checkbox. ");
        clickBtn(obj.getSignup().getCheckBox());
    }
    @Then("user clicks on getstarted button to register.")
    public void userClicksOnGetstartedButtonToRegister() {
        log.info("user clicks on getstarted button to register.");
           clickBtn(obj.getSignup().getRegisterBtn());
        Assert.assertEquals(driver.getTitle(),"Log In or Sign Up | ITBusinessBook");
    }
    @When("user clicks on SignIn option")
    public void user_clicks_on_sign_in_option() throws InterruptedException {
        log.info("user clicks on SignIn option");
       Thread.sleep(3000);
        driver.get(p.getProperty("url"));
            }
    @When("User enters email into Text Field")
    public void userEntersEmailIntoTextField() {
        log.info("User enters email into Text Field");
    sendKeysElement(obj.getLogin().getLogin(),p.getProperty("email"));
    }
    @When("Then user enters password")
    public void thenUserEntersPassword() {

        log.info("Then user enters password");
        sendKeysElement(obj.getLogin().getPassword(),p.getProperty("password"));
    }
    @Then("login must be successful.")
    public void loginMustBeSuccessful() throws InterruptedException {
        log.info("login must be successful.");
        Thread.sleep(3000);
        waitForElement(obj.getLogin().getSignIn());

      clickBtn(obj.getLogin().getSignIn());
      Thread.sleep(3000);
      Assert.assertEquals(driver.getTitle(),"News Feed | ITBusinessBook");
    }

    @When("User click Jobs and moves to Find a job and click it")
    public void user_click_jobs_and_moves_to_find_a_job_and_click_it() {
        log.info("User click Jobs and moves to Find a job and click it");
        moveToElement(obj.getJobs().getJobs());
clickBtn(obj.getJobs().getFindjobs());
    }
    @When("user enters job title into textbox.")
    public void user_enters_job_title_into_textbox() {
        log.info("user enters job title into textbox.");
sendKeysElement(obj.getJobs().getTitle(),p.getProperty("Jobtitle"));
    }
    @When("user clicks on search button.")
    public void user_clicks_on_search_button() {
        log.info("user clicks on search button.");
clickBtn(obj.getJobs().getSearch());
Assert.assertEquals(driver.getTitle(),"Jobs | ITBusinessBook");
    }

    @When("User clicks on profile")
    public void user_clicks_on_profile() {

        log.info("User clicks on profile");
        clickBtn(obj.getProfile().getProfileButton());
    }
    @When("user moves the cursor to logout and clicks logout button")
    public void user_moves_the_cursor_to_logout_and_clicks_logout_button() {
        log.info("user moves the cursor to logout and clicks logout button ");
        clickBtn(obj.getLogout().getLogout());
    }
    @Then("user clicks ok to logout")
    public void user_clicks_ok_to_logout() throws InterruptedException {
        log.info("user clicks ok to logout");
       // clickBtn(obj.getLogout().getOkButton());
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Log In or Sign Up | ITBusinessBook");
       // driver.close();
    }
}
