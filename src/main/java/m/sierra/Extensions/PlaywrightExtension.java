package m.sierra.Extensions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PlaywrightExtension implements BeforeEachCallback, AfterEachCallback {

    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // Override and globally define the beforeEach
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // Override and globally define the afterEach
    }

    public static Page getPage() {
        return page;
    }

    public static Browser getBrowser() {
        return browser;
    }
}
