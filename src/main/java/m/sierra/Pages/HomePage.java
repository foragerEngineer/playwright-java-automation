package m.sierra.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import m.sierra.Asserts.PlayAsserts;

public class HomePage {

    private final PlayAsserts asserts;
    private final Locator basicPageLink;

    public HomePage(Page page) {
        this.asserts = new PlayAsserts();
        this.basicPageLink = page.locator("a");
    }

    public void isHomePageDisplayed() {
        asserts.assertElementHasText(basicPageLink, "basicpagetest");
    }


}
