package m.sierra.Asserts;

import com.microsoft.playwright.Locator;
import m.sierra.Driver.PlaywrightFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlayAsserts extends PlaywrightFactory {

    public void assertElementHasText(Locator elementLocator, String text) {
        Locator element = page.locator(String.valueOf(elementLocator));
        assertThat(element).hasText(String.valueOf(text));
    }


}
