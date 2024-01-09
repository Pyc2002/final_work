package objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@data-testid='login-email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@data-testid='login-password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@data-testid='login-submit']")
    private WebElement loginButton;
    @FindBy(className = "new_user")
    private WebElement filledEmail;
    @FindBy(css = "form.new_user [data-testid='login-password'] + ul")
    private WebElement filledPassword;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void login(String username, String password) {
        typeEmailInField(username);
        typePasswordInField(password);
        clickLoginButton();
    }

    public void typeEmailInField(String username) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(username);
    }

    public void typePasswordInField(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public boolean checkEmailField(){
        return wait.until(ExpectedConditions.visibilityOf(filledEmail)).getText().isEmpty();
    }

    public boolean checkPasswordField(){
        return wait.until(ExpectedConditions.visibilityOf(filledPassword)).getText().isEmpty();
    }
}
