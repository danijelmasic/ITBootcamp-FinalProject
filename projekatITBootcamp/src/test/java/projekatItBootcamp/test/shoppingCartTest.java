package projekatItBootcamp.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import projekatItBootcamp.pages.shoppingCart;
import utils.PropReader;

import java.io.IOException;
import java.time.Duration;

public class shoppingCartTest {

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

    @AfterSuite
    public void closeAllProcesses() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    /*Cart_01
    1. Navigate to https://www.saucedemo.com/inventory.html
    with a logged account
    2. Find an item you wish to add to the cart
    3. Click the ""add to cart"" button
    4. Assert that the item has been added to the cart*/

    @Test(priority = 3)
    public void addOneItemToCart(){
        System.out.println("Go to https://www.saucedemo.com/inventory.html");
        wd.get("https://www.saucedemo.com/inventory.html");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "You should be directed to the url: https://www.saucedemo.com/inventory.html");

        shoppingCart shoppingCartPage = new shoppingCart(wd);


//        shoppingCartPage.inputValues("standard_user", "secret_sauce");
//
//        shoppingCartPage.clickLoginButton();

        shoppingCartPage.clickAddToCart();

        shoppingCartPage.clickOnShoppingCart();

        String confirmAddedItem = shoppingCartPage.confirmAddedItem();

        System.out.println("Assert that item has been added to the cart");

        Assert.assertEquals(confirmAddedItem, "REMOVE", "There should be an item in the shopping cart");

        shoppingCartPage.clickRemoveBackpack();

    }

    /*Cart_02
    1. Navigate to https://www.saucedemo.com/inventory.html
    with a logged account
    2. Click the ""add to cart"" button on multiple items
    4. Assert that items are added to the cart*/

    @Test(priority = 1)
    public void addMultipleItemsToCart() throws InterruptedException {
        System.out.println("Go to https://www.saucedemo.com/inventory.html");
        wd.get("https://www.saucedemo.com/inventory.html");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "You should be re-directed to the url: https://www.saucedemo.com/");

        shoppingCart shoppingCartPage = new shoppingCart(wd);

        shoppingCartPage.inputValues("standard_user", "secret_sauce");

        shoppingCartPage.clickLoginButton();

        shoppingCartPage.clickAddBackpack();

        shoppingCartPage.clickAddBikeLight();

        shoppingCartPage.clickAddShirt();

        shoppingCartPage.clickAddJacket();

        String itemsInCart = shoppingCartPage.itemsInCart();

        boolean testCart;

        if(Integer.parseInt(itemsInCart) > 1){
            testCart = true;
            Assert.assertEquals(true, true, "Items are added to cart");
            System.out.println("Items are added, test passed");

            shoppingCartPage.cleanUp();

        }else{
            testCart = false;
            Assert.assertEquals(false, true, "Not enough items added");
            System.out.println("There is not enough items in the cart, test failed");

            shoppingCartPage.cleanUp();
        }
    }

    /*Cart_03
    1. Navigate to https://www.saucedemo.com/inventory.html
    with a logged account
    2. Navigate to the shopping cart
    3. Click on the ""remove"" button
    4. Assert that the item has been removed
*/

    @Test(priority = 2)
    public void removeItemFromCart(){
        System.out.println("Go to https://www.saucedemo.com/inventory.html");
        wd.get("https://www.saucedemo.com/inventory.html");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "You should be directed to the url: https://www.saucedemo.com/inventory.html");

        shoppingCart shoppingCartPage = new shoppingCart(wd);

//        shoppingCartPage.inputValues("standard_user", "secret_sauce");
//
//        shoppingCartPage.clickLoginButton();

        shoppingCartPage.clickAddBackpack();

        shoppingCartPage.clickOnShoppingCart();

        shoppingCartPage.clickRemove();

        String itemRemoved = shoppingCartPage.itemRemoved();

        Assert.assertEquals(itemRemoved, "CONTINUE SHOPPING", "Test passed");

    }

    /*Cart_04
    1. Navigate to https://www.saucedemo.com/inventory.html
    with a logged account
    2. Add an item
    3. Navigate to the shopping cart
    4. Click on the ""checkout"" button
    5. Enter values to the wanted fields
    6. Click ""continue"" button
    7. Click ""finish"" button
    8. Assert that the purchase has been made*/

    @Test(priority = 4)
    public void checkout(){
        System.out.println("Go to https://www.saucedemo.com/inventory.html");
        wd.get("https://www.saucedemo.com/inventory.html");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "You should be directed to the url: https://www.saucedemo.com/inventory.html");

        shoppingCart shoppingCartPage = new shoppingCart(wd);

        shoppingCartPage.clickAddToCart();

        shoppingCartPage.clickOnShoppingCart();

        shoppingCartPage.clickCheckout();

        shoppingCartPage.enterValuesForCheckout("Danijel", "Masic", "12345");

        shoppingCartPage.clickContinue();

        shoppingCartPage.clickFinish();

        String orderConformation = shoppingCartPage.confirmOrder();

        Assert.assertEquals(orderConformation, "THANK YOU FOR YOUR ORDER", "Order successful, test passed");





    }




}
