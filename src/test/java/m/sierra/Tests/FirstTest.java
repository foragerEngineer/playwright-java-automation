package m.sierra.Tests;

import m.sierra.PageUtils.Locators.InnerTextAll;
import m.sierra.Pages.HomePage;
import m.sierra.PageUtils.UiHelper;
import m.sierra.baseTest.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test(priority = 1, description = "Verify the title of the home page")
    public void verifyTitleTest() {
        HomePage homePage = new HomePage();
        UiHelper uiHelper = new UiHelper(page);
        uiHelper.waitUntilPageLoad();
        homePage.isHomePageDisplayed();
    }

    @Test(priority = 2, description = "Verify 'Get Started' button is clickable")
    public void verifyGetStartedTest() {
        HomePage homePage = new HomePage();
        UiHelper uiHelper = new UiHelper(page);
        InnerTextAll innerTextAll = new InnerTextAll();
        innerTextAll.getAllInnerText();
        uiHelper.waitUntilPageLoad();
        homePage.clickGetStartedButton();
        uiHelper.waitUntilPageLoad();
    }

}
