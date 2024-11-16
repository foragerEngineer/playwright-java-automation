package m.sierra.PageUtils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class UiHelper {

    private final Page page;

    public UiHelper(Page page) {
        this.page = page;
    }

    @Step("Wait until page is loaded")
    public void waitUntilPageLoad() {
        page.waitForLoadState();
    }

    public void clickElement(String locator) {
        page.click(locator);
    }

}
