package m.sierra.Tests;

import m.sierra.Pages.HomePage;
import m.sierra.PageUtils.UiHelper;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTitleTest() {
        HomePage homePage = new HomePage(page);
        UiHelper uiHelper = new UiHelper(page);
        uiHelper.waitUntilPageLoad();
        homePage.isHomePageDisplayed();
    }

    @Test(priority = 2)
    public void verifyGetStartedTest() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        UiHelper uiHelper = new UiHelper(page);
        uiHelper.waitUntilPageLoad();
        homePage.clickGetStartedDisplayed();
    }

}
