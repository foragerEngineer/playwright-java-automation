package m.sierra.PageUtils;

import com.microsoft.playwright.Page;

public class UiHelper {

    private final Page page;

    public UiHelper(Page page) {
        this.page = page;
    }

    public void waitUntilPageLoad() {
        page.waitForLoadState();
    }

    public void clickElement(String locator) {
        page.click(locator);
    }

}
