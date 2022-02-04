package projekatItBootcamp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import projekatItBootcamp.pages.sortBy;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByTest {

    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                PropReader.fetchProperty("WEBDRIVER.CHROME.PATH"));

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void zatvoriWebDriver() {
        wd.close();
    }

    /*SortBy_01
    1. Navigate to https://www.saucedemo.com/
    and log in
    2. Click on sorting dropdown and choose Price(low to high)
    3. Assert that all items are sorted from low to high price*/

    @Test
    public void sortByAscendingPrice(){

        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        sortBy sortByPage = new sortBy(wd);

        sortByPage.inputValues("standard_user", "secret_sauce");

        sortByPage.clickLoginButton();

        List<WebElement> beforeFilterPrice = wd.findElements(By.className("inventory_item_price"));

        List<Double> beforeFilterPriceList = new ArrayList<>();

        for(WebElement p : beforeFilterPrice){
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Select dropdown = new Select(wd.findElement(By.className("product_sort_container")));

        dropdown.selectByVisibleText("Price (low to high)");

        List<WebElement> afterFilterPrice = wd.findElements(By.className("inventory_item_price"));

        List<Double> afterFilterPriceList = new ArrayList<>();

        for(WebElement p : afterFilterPrice){
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Collections.sort(beforeFilterPriceList);

        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);

        System.out.println("Price is sorted from lowest to highest, test passed!");
    }

    /*SortBy_02
    1. Navigate to https://www.saucedemo.com/
    and log in
    2. Click on sorting dropdown and choose Price(high to low)
    3. Assert that all items are sorted from high to low price
    */

    @Test
    public void sortByDescendingPrice(){

        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        sortBy sortByPage = new sortBy(wd);

        sortByPage.inputValues("standard_user", "secret_sauce");

        sortByPage.clickLoginButton();

        List<WebElement> beforeFilterPrice = wd.findElements(By.className("inventory_item_price"));

        List<Double> beforeFilterPriceList = new ArrayList<>();

        for(WebElement p : beforeFilterPrice){
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Select dropdown = new Select(wd.findElement(By.className("product_sort_container")));

        dropdown.selectByVisibleText("Price (high to low)");

        List<WebElement> afterFilterPrice = wd.findElements(By.className("inventory_item_price"));

        List<Double> afterFilterPriceList = new ArrayList<>();

        for(WebElement p : afterFilterPrice){
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Collections.sort(beforeFilterPriceList);

        Collections.reverse(beforeFilterPriceList);

        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);

        System.out.println("Price is sorted from highest to lowest, test passed!");
    }

    /*SortBy_03
    1. Navigate to https://www.saucedemo.com/
    and log in
    2. Click on sorting dropdown and choose Name(A to Z)
    3. Assert that all items are sorted from A to Z*/

    @Test
    public void sortByAToZ(){

        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        sortBy sortByPage = new sortBy(wd);

        sortByPage.inputValues("standard_user", "secret_sauce");

        sortByPage.clickLoginButton();

        Select dropdown = new Select(wd.findElement(By.className("product_sort_container")));

        dropdown.selectByVisibleText("Name (A to Z)");

        String confirmFirstItem = sortByPage.confirmFirstPlaceItem();

        Assert.assertEquals(confirmFirstItem, "Sauce Labs Backpack", "Backpack should be the first item");

        String confirmLastItem = sortByPage.confirmLastPlaceItem();

        Assert.assertEquals(confirmLastItem, "Test.allTheThings() T-Shirt (Red)", "The red shirt should be the last item");

        System.out.println("Items sorted A to Z, test passed");

    }

    /*SortBy_04
    1. Navigate to https://www.saucedemo.com/
    and log in
    2. Click on sorting dropdown and choose Name(Z to A)
    3. Assert that all items are sorted from Z to A*/

    @Test
    public void sortByZToA() throws InterruptedException {

        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        sortBy sortByPage = new sortBy(wd);

        sortByPage.inputValues("standard_user", "secret_sauce");

        sortByPage.clickLoginButton();

        Select dropdown = new Select(wd.findElement(By.className("product_sort_container")));

        dropdown.selectByVisibleText("Name (Z to A)");

        String confirmFirstItem = sortByPage.confirmFirstPlaceItem();

        Assert.assertEquals(confirmFirstItem, "Test.allTheThings() T-Shirt (Red)", "The red shirt should be the first item");

        String confirmLastItem = sortByPage.confirmLastPlaceItem();

        Assert.assertEquals(confirmLastItem, "Sauce Labs Backpack", "Backpack should be the last item");

        System.out.println("Items sorted Z to A, test passed");

    }
}
