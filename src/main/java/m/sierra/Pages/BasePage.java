package m.sierra.Pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected static Page page;

    public static void setAndConfigurePage(Page page) {
        BasePage.page = page;
        page.setDefaultTimeout(5000);
    }

}
