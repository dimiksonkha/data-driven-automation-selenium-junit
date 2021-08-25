package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By signUpLink = By.cssSelector("a[href=\"/blog/sign-up/\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public RegistrationPage clickSignUpLink(){
        driver.findElement(signUpLink).click();
        return new RegistrationPage(driver);
    }
}
