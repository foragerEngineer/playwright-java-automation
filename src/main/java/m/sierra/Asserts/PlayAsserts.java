package m.sierra.Asserts;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlayAsserts {

    private final Page page;

    public PlayAsserts(Page page) {
        this.page = page;
    }

    public void assertElementHasText(Locator elementLocator, String text) {
        assertThat(elementLocator).hasText(text);
    }


}
