package m.sierra.Utilities;

import com.microsoft.playwright.Page;

public class UiHelper {

    private final Page page;

    public UiHelper(Page page) {
        this.page = page;
    }

    public void waitUntilPageLoad() {
        page.waitForLoadState();
    }
}
