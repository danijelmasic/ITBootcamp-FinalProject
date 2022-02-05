package projekatItBootcamp.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import projekatItBootcamp.pages.login;

import java.io.IOException;
import java.time.Duration;

public class loginTest {

    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void zatvoriWebDriver() {
        wd.close();
    }



    /*Login_01
    1. Navigate to https://www.saucedemo.com/
    2. Enter a valid username
    3. Enter a valid password
    4. Click the login button
    5. Assert that login is successful and that you are
    directed to the home page*/

    @Test
    public void loginWithValidValues(){
        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        login loginPage = new login(wd);

        loginPage.inputValues("standard_user", "secret_sauce");

        loginPage.clickLoginButton();

        String confirmLogin = loginPage.confirmHomeScreen();

        System.out.println("Assert that you have logged in");

        Assert.assertEquals(confirmLogin, "PRODUCTS", "You should be moved to PRODUCTS page.");

    }

    /*Login_02
1. Navigate to https://www.saucedemo.com/
2. Enter a valid username
3. Enter an invalid password
4. Click the login button
5. Assert that error message has appeared*/

    @Test
    public void loginWithInvalidPassword(){
        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        login loginPage = new login(wd);

        loginPage.inputValues("standard_user", "danijel");

        loginPage.clickLoginButton();

        String confirmErrorMsg = loginPage.getErrorMessage();

        System.out.println("Assert that error msg has appeared");

        Assert.assertEquals(confirmErrorMsg, "Epic sadface: Username and password do not match any user in this service", "Error message should appear.");
    }

    /*Login_03
1. Navigate to https://www.saucedemo.com/
2. Enter an invalid username
3. Enter a valid password
4. Click the login button
5. Assert that error message has appeared*/

    @Test
    public void loginWithInvalidUsername(){
        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        login loginPage = new login(wd);

        loginPage.inputValues("danijel", "secret_sauce");

        loginPage.clickLoginButton();

        String confirmErrorMsg = loginPage.getErrorMessage();

        System.out.println("Assert that error msg has appeared");

        Assert.assertEquals(confirmErrorMsg, "Epic sadface: Username and password do not match any user in this service", "Error message should appear.");
    }

    /*Login_04
1. Navigate to https://www.saucedemo.com/
2. Enter an invalid username
3. Enter an invalid password
4. Click the login button
5. Assert that error message has appeared*/

    @Test
    public void loginWithInvalidValues(){
        System.out.println("Go to https://www.saucedemo.com/");
        wd.get("https://www.saucedemo.com/");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.saucedemo.com/",
                "The current url should be equal to https://www.saucedemo.com/");

        login loginPage = new login(wd);

        loginPage.inputValues("danijel", "danijel");

        loginPage.clickLoginButton();

        String confirmErrorMsg = loginPage.getErrorMessage();

        System.out.println("Assert that error msg has appeared");

        Assert.assertEquals(confirmErrorMsg, "Epic sadface: Username and password do not match any user in this service", "Error message should appear.");
    }






}
