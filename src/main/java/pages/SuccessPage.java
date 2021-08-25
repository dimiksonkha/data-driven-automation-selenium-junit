package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    private WebDriver driver;
    private By successMessage = By.tagName("h1");
    public SuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
