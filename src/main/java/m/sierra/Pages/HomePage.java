package m.sierra.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import m.sierra.Asserts.PlayAsserts;
import m.sierra.PageUtils.UiHelper;

public class HomePage {

    private final Page page;
    private final PlayAsserts asserts;
    private final Locator basicPageLink;

    public HomePage(Page page) {
        this.page = page;
        this.asserts = new PlayAsserts(page);
        this.basicPageLink = page.locator("span:has-text(\"Playwright\")");
    }

    public void isHomePageDisplayed() {
        asserts.assertElementHasText(basicPageLink, "Playwright");
    }

    public void clickGetStartedDisplayed() {
        System.out.println("Clicking on Get Started");
        page.click("//a[normalize-space()='Get started']");
        System.out.println("Clicked on Get Started");
        System.out.println("Waiting for 4 seconds");
        System.out.println("Waited for 4 seconds");
    }


}
