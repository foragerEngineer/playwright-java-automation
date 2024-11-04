package m.sierra.Asserts;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlayAsserts {

    private final Page page;

    public PlayAsserts(Page page) {
        this.page = page;
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


}
