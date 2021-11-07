package com.volvocars.pages;

import com.volvocars.utilities.BrowserUtils;
import com.volvocars.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MillionMorePage {

    public MillionMorePage(){ PageFactory.initElements(Driver.get(),this); }

    @FindBy(css = "button[title='Accept']")
    public WebElement acceptCookiesButton;

    @FindBy(css = "section[data-autoid]>h2")
    public WebElement explanationHeaderText;

    @FindBy(css = "section[data-autoid]>p")
    public WebElement explanationText;

    @FindBy(xpath = "//button[text()='watch the story']")
    public WebElement watchTheStoryButton;

    @FindBy(xpath = "(//a[@data-autoid='nav:siteNavLogoSmall'])[2]")
    public WebElement volvoButton;

    @FindBy(xpath = "//em[text()='Our Cars']")
    public WebElement ourCarsButton;

    @FindBy(css = "span[data-testid='burger']")
    public WebElement menuButton;

    public void acceptCookies(){
        try{
            acceptCookiesButton.click();
        }catch (NoSuchElementException exception){
            System.out.println("Did not asked cookies");
        }
    }

    public void checkExplanationTexts(){
        String header = "Ideas that change the world are often the most controversial.";
        String text = "After we introduced the 3-point safety belt, we faced a world of criticism. Since then, " +
                "it has saved more than a million lives. Now it's time for the next step. For everyone's safety.";
        Assert.assertEquals("Check explanation text header",header,explanationHeaderText.getText());
        Assert.assertEquals("Check explanation text",text,explanationText.getText());
    }

    public void checkWatchStoryButtonDisappeared(){
        List<WebElement> list = Driver.get().findElements(By.xpath("//button[text()='watch the story']"));
        Assert.assertEquals(0,list.size());
    }

    public WebElement getCarCategoryOptionButton(String carCategory){
        return Driver.get().findElement(By.xpath("(//h2[text()='" + carCategory + "'])[1]"));
    }

    public WebElement getMenuCategoryButton(String menuCategory){
        return Driver.get().findElement(By.xpath("//em[text()='" + menuCategory + "']"));
    }

    public WebElement getVideoRunButton(int videoNumber){
        return Driver.get().findElement(By.xpath("//video[@data-autoid='videoTestimonials:video-"+(videoNumber-1)+"']/../button"));
    }

    public void checkVideoRunButton(int videoNumber){
        List<WebElement> listRunButton = Driver.get().findElements(By.xpath("//video[@data-autoid=" +
                "'videoTestimonials:video-" + (videoNumber-1) +"']/../button"));
        Assert.assertEquals(0,listRunButton.size());
    }

    public WebElement getVideoBlock(int blockOrder){
        BrowserUtils.waitForVisibility(By.xpath("//div[@data-autoid='videoTestimonials:container']["+blockOrder+"]"),10);
        return Driver.get().findElement(By.xpath("//div[@data-autoid='videoTestimonials:container']["+blockOrder+"]"));
    }

    //for Learn more - Recharge - Mild hybrid cars - Cookies - Legal- Privacy - Social Media buttons
    public WebElement getButtomButtons(String buttonName){
        return Driver.get().findElement(By.xpath("//a[text()='" + buttonName + "']"));
    }

}
