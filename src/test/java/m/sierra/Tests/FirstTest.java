package m.sierra.Tests;

import m.sierra.Pages.HomePage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTitle() {
        HomePage homePage = new HomePage(page);
        homePage.isHomePageDisplayed();
    }

//    @Test(priority = 2)
//    public void verifySearch() {
//    }

}
