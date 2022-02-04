package projekatItBootcamp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.StandardCharsets;

public class shoppingCart {

    private WebDriver wd;

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addToCart;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement shoppingCart;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement conformation;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement addBikeLight;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement addShirt;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement addJacket;

    @FindBy(xpath = "//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")
    WebElement cartNumber;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/button[1]")
    WebElement removeFromCart;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement continueShopping;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement cartContains;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement removeBackpack;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    WebElement removeBikeLight;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")
    WebElement removeShirt;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")
    WebElement removeJacket;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    WebElement orderConfirm;




    public shoppingCart(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void inputValues(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickAddToCart(){addToCart.click();}

    public void clickOnShoppingCart(){shoppingCart.click();}

    public String confirmAddedItem(){
        return conformation.getText();
    }

    public void clickAddBackpack(){addBackpack.click();}

    public void clickAddBikeLight(){addBikeLight.click();}

    public void clickAddShirt(){addShirt.click();}

    public void clickAddJacket(){addJacket.click();}

    public String itemsInCart(){return cartNumber.getText();}

    public void clickRemove(){removeFromCart.click();}

    public String itemRemoved(){return cartContains.getText();}

    public void clickRemoveBackpack(){removeBackpack.click();}

    public void clickCheckout(){checkoutButton.click();}

    public void cleanUp(){
        removeBackpack.click();
        removeBikeLight.click();
        removeShirt.click();
        removeJacket.click();
    }

    public void enterValuesForCheckout(String name, String prezime, String zip){
        firstName.sendKeys(name);
        lastName.sendKeys(prezime);
        zipCode.sendKeys(zip);
    }

    public void clickContinue(){continueButton.click();}

    public void clickFinish(){finishButton.click();}

    public String confirmOrder(){ return orderConfirm.getText();}
}
