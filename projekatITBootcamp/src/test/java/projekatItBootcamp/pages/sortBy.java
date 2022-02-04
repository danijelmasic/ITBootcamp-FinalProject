package projekatItBootcamp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sortBy {

    private WebDriver wd;

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")
    WebElement backpackFirst;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[1]/a/div")
    WebElement shirtLast;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")
    WebElement shirtFirst;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[1]/a/div")
    WebElement backpackLast;

    public sortBy(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public void inputValues(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String confirmFirstPlaceItem(){return backpackFirst.getText();}

    public String confirmLastPlaceItem(){return shirtLast.getText();}


}
