package m.sierra.Pages;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import m.sierra.Asserts.PlayAsserts;

public final class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private final Locator basicPageLink = page.locator("//a[normalize-space()='Playwright']");

    @Step("Verify the title of the home page")
    public void isHomePageDisplayed() {
        PlayAsserts playAsserts = new PlayAsserts();
        playAsserts.assertElementHasText(basicPageLink, "Playwright");
    }

    @Step("Click on Get Started button")
    public void clickGetStartedButton() {
        System.out.println("Clicking on Get Started");
        page.click("//a[normalize-space()='Get started']");
        System.out.println("Clicked on Get Started");
        System.out.println("Waiting for 4 seconds");
    }

}
