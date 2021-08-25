package registration;

import base.BaseTests;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SuccessPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.SpreadsheetReader;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests extends BaseTests {
    private static final String HOME_PAGE = "http://xhacker404.pythonanywhere.com";

    @BeforeAll
    public static void launchApp(){
        driver.get(HOME_PAGE);

    }

    @Test
    public void testUserRegistration() throws InterruptedException {
        String fileName = System.getProperty("user.dir")+"/resources/data/Test Data.xlsx";
        String sheetName = "user";

        SpreadsheetReader spreadsheet = new SpreadsheetReader(new File(fileName));
        spreadsheet.switchToSheet(sheetName);
        for (int i = 1; i <=10 ; i++) {
            String username = spreadsheet.getCellData("Username", i);
            String email = spreadsheet.getCellData("Email", i);
            String password = spreadsheet.getCellData("Password", i);
            String portfolio = spreadsheet.getCellData("Portfolio", i);
            String image = spreadsheet.getCellData("Image", i);

            HomePage homePage = new HomePage(driver);
            RegistrationPage registrationPage = homePage.clickSignUpLink();
            registrationPage.setUsername(username);
            registrationPage.setEmail(email);
            registrationPage.setPassword(password);
            registrationPage.setPortfolio(portfolio);
            registrationPage.setProfilePicture(System.getProperty("user.dir")+"/resources/images/"+image);
            Thread.sleep(5000);

            SuccessPage successPage =  registrationPage.clickSubmitButton();
            String successMessage = successPage.getSuccessMessage();
            if(i!=10){
                driver.navigate().to(HOME_PAGE);
            }

            assertTrue(successMessage.contains("Thanks for your registration!"), "Registration Failed!!!");

        }

    }

}
