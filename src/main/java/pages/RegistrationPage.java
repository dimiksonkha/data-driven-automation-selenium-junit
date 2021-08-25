package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    private By username = By.id("id_username");
    private By email = By.id("id_email");
    private By password = By.id("id_password");
    private By portfolio = By.id("id_portfolio");
    private By profilePicture = By.id("id_profile_pic");
    private By submitButton = By.cssSelector("input[type=\"submit\"]");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String userName){
        driver.findElement(username).sendKeys(userName);
    }
    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void setEmail(String userEmail){
        driver.findElement(email).sendKeys(userEmail);
    }
    public void setPortfolio(String userPortfolio){
        driver.findElement(portfolio).sendKeys(userPortfolio);
    }

    public void setProfilePicture(String userProfilePicture){
        driver.findElement(profilePicture).sendKeys(userProfilePicture);
    }

    public SuccessPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new SuccessPage(driver);
    }
}
