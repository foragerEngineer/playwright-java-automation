package m.sierra.Asserts;

import com.microsoft.playwright.Locator;
import m.sierra.Pages.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlayAsserts extends BasePage {

    public PlayAsserts() {
        super();
    }

    /***
     * Asserts that the element is visible by using the locator HTML tag
     * @param elementLocator provide an HTML tag locator
     * @param text provide the text to be asserted
     */
    public void assertElementHasText(Locator elementLocator, String text) {
        assertThat(elementLocator).hasText(text);
    }

    public void assertElementIsVisible(String elementLocator) {
        assertThat(page.locator(elementLocator)).isVisible();
    }


    public void assertEmail(String email) {
    }
}
