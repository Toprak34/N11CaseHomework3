package com.n11.step_definitions;

import com.n11.pages.BasePageElement;
import com.n11.pages.SearchPageElement;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class N11StepDefinitions {
    WebDriver driver= Driver.get();
    BasePageElement basePageElement = new BasePageElement();
    SearchPageElement searchPage=new SearchPageElement();


    @When("user select filter")
    public void user_select_filter() throws InterruptedException {
        searchPage.setFilter();
        Select sortTo = new Select(searchPage.dropDownType);
        //List<WebElement> options =sortTo.getOptions();
        Assert.assertTrue(sortTo.getFirstSelectedOption().getText().contains("Yorum sayısı"));

        Assert.assertTrue(searchPage.freeShipCheckBox.isSelected());

       // Thread.sleep(1000);
    }

    @Given("User go to n11 home page and search {string}")
    public void user_go_to_n11_home_page_and_search(String product) {
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(ConfigurationReader.get("url"), driver.getCurrentUrl());
        basePageElement.searchProduct(product);
        Assert.assertTrue(searchPage.resultText.getText().contains("Telefon"));
    }
    @When("User sort by comments and select to free shipping filter")
    public void user_sort_by_comments_and_select_to_free_shipping_filter() throws InterruptedException {
        searchPage.setFilter();
        Select sortTo = new Select(searchPage.dropDownType);
        Assert.assertTrue(sortTo.getFirstSelectedOption().getText().contains("Yorum sayısı"));

        Assert.assertTrue(searchPage.freeShipCheckBox.isSelected());

    }

}
