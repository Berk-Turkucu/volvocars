package com.volvocars.step_definitions;

import com.volvocars.pages.MillionMorePage;
import com.volvocars.utilities.BrowserUtils;
import com.volvocars.utilities.ConfigurationReader;
import com.volvocars.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class volvocars {

    MillionMorePage millionMorePage = new MillionMorePage();

    @Given("user should be able on the volvo-million-more page")
    public void user_should_be_able_on_the_volvo_million_more_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        millionMorePage.acceptCookies();
        Assert.assertEquals("Verify user on the MillionMorePage",
                "A million more | Volvo Cars - International",Driver.get().getTitle());

    }


    @Then("user should see the explanations on top of the volvo-million-more page")
    public void userShouldSeeTheExplanationsOnTopOfTheVolvoMillionMorePage() {
        millionMorePage.checkExplanationTexts();
    }

    @When("user clicks the Watch The Story Button")
    public void userClicksTheWatchTheStoryButton() {
        millionMorePage.watchTheStoryButton.click();
    }

    @Then("user should be able to watch the story")
    public void userShouldBeAbleToWatchTheStory() {
        millionMorePage.checkWatchStoryButtonDisappeared();
    }

    @When("user clicks the volvo button")
    public void userClicksTheVolvoButton() {
        millionMorePage.volvoButton.click();
    }

    @Then("user should be able on the home page")
    public void userShouldBeAbleOnTheHomePage() {
        Assert.assertEquals("Control homepage title","International | Volvo Cars - International", Driver.get().getTitle());
    }

    @And("user returns volvo-million-more page")
    public void userReturnsVolvoMillionMorePage() {
        Driver.get().navigate().back();
        Assert.assertEquals("Verify user on the MillionMorePage",
                "A million more | Volvo Cars - International",Driver.get().getTitle());
    }

    @When("user clicks the Our Cars button")
    public void userClicksTheOurCarsButton() {
        Assert.assertFalse(millionMorePage.getCarCategoryOptionButton("Electric").isDisplayed());
        millionMorePage.ourCarsButton.click();
    }

    @Then("user should see the {string}, {string} and {string} options")
    public void userShouldSeeTheAndOptions(String arg0, String arg1, String arg2) {
        BrowserUtils.waitForVisibility(millionMorePage.getCarCategoryOptionButton(arg1),10);
        Assert.assertTrue(millionMorePage.getCarCategoryOptionButton(arg0).isDisplayed());
        Assert.assertTrue(millionMorePage.getCarCategoryOptionButton(arg1).isDisplayed());
        Assert.assertTrue(millionMorePage.getCarCategoryOptionButton(arg2).isDisplayed());
    }

    @When("user clicks Menu button")
    public void userClicksMenuButton() {
        millionMorePage.menuButton.click();
    }

    @Then("user should see the {string}, {string}, {string}, {string}, {string} options on the menu")
    public void userShouldSeeTheOptionsOnTheMenu(String arg0, String arg1, String arg2, String arg3, String arg4) {
        BrowserUtils.waitForVisibility(millionMorePage.getMenuCategoryButton(arg0),5);
        Assert.assertTrue(millionMorePage.getMenuCategoryButton(arg0).isDisplayed());
        Assert.assertTrue(millionMorePage.getMenuCategoryButton(arg1).isDisplayed());
        Assert.assertTrue(millionMorePage.getMenuCategoryButton(arg2).isDisplayed());
        Assert.assertTrue(millionMorePage.getMenuCategoryButton(arg3).isDisplayed());
        Assert.assertTrue(millionMorePage.getMenuCategoryButton(arg4).isDisplayed());
    }

    @When("user clicks video {int} run button")
    public void userClicksVideoRunButton(int arg0) {
//        BrowserUtils.scrollToElement(millionMorePage.getVideoRunButton(arg0));
//        millionMorePage.getVideoRunButton(arg0).click();
        BrowserUtils.scrollToElement(millionMorePage.getVideoBlock(arg0));
        BrowserUtils.clickWithJS(millionMorePage.getVideoRunButton(arg0));
    }

    @Then("user should watch video {int}")
    public void userShouldWatchVideo(int arg0) {
        millionMorePage.checkVideoRunButton(arg0);
    }


    @When("user clicks {string} button")
    public void userClicksButton(String buttonName) {
        millionMorePage.getButtomButtons(buttonName).click();
    }

    @Then("user should see the {string} page")
    public void userShouldSeeThePage(String pageName) {
        Assert.assertTrue(Driver.get().getTitle().contains(pageName));
    }
}
