package m.sierra.Tests;

import m.sierra.Pages.HomePage;
import m.sierra.Utilities.UiHelper;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTitle() {
        HomePage homePage = new HomePage(page);
        UiHelper uiHelper = new UiHelper(page);
        uiHelper.waitUntilPageLoad();
        homePage.isHomePageDisplayed();
    }

}
