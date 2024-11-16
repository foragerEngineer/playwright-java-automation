package m.sierra.Utilities;

import com.microsoft.playwright.Browser;

import java.nio.file.Paths;

public class BrowserUtils {

    Browser browser;


    public BrowserUtils(Browser browser) {
        this.browser = browser;
    }

    public void startVideoRecording() {
        browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("target/videos")));
    }

    public BrowserUtils newPageContext() {
        browser.newContext();
        return this;
    }

}
