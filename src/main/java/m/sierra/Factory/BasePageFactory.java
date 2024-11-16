package m.sierra.Factory;

import com.microsoft.playwright.Page;
import lombok.extern.log4j.Log4j2;
import m.sierra.Pages.BasePage;

@Log4j2
public final class BasePageFactory {

    private BasePageFactory() {
    }

    public static <T extends BasePage> T createInstance(final Page page, final Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception e) {
            log.error("BasePageFactory::createInstance", e);
        }
        throw new NullPointerException("Page class instantiation failed");
    }

}