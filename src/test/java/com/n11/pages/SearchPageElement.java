package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPageElement extends BasePageElement {

    @FindBy(className = "resultText")
    public WebElement resultText;

    @FindBy(xpath = "(//*[@class =\"brand-checkbox\"])[4]")
    public WebElement brandFilterElements;


    @FindBy(id = "sortingType")
    public WebElement dropDownType;

    @FindBy(id = "freeShippingOption")
    public WebElement freeShipCheckBox;

    public void setFilter() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(Driver.get(),Duration.ofSeconds(3));

        brandFilterElements.click();
        wait.until(ExpectedConditions.elementToBeClickable(freeShipCheckBox));
        wait.until(ExpectedConditions.visibilityOf(dropDownType));

        Select sortTo = new Select(dropDownType);
        sortTo.selectByVisibleText("Yorum sayısı");
        freeShipCheckBox.click();

    }


}
