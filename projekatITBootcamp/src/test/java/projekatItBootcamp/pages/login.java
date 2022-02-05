package projekatItBootcamp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {

    private WebDriver wd;

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement conformation;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    WebElement errorMessage;

    public login(WebDriver wd) {
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

    public String confirmHomeScreen(){
        return conformation.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
