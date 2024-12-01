package m.sierra.PageUtils.Locators;

import com.microsoft.playwright.options.AriaRole;
import m.sierra.Pages.BasePage;

public class InnerTextAll extends BasePage {

    public InnerTextAll() {
        super();
    }

    /**
     * Returns an array of node.innerText values for all matching nodes
     */
    public void getAllInnerText() {
        String[] arrayOfTexts = page.getByRole(AriaRole.LINK).allTextContents().toArray(String[]::new);
        for (String text : arrayOfTexts) {
            System.out.println(text);
        }
    }

    /**
     * Output example from the Playwright site:
     * skip to main content
     * Playwright
     * Docs
     * API
     * Community
     *
     *
     * Get started
     * Star
     * 67k+
     * TypeScript
     * JavaScript
     * Python
     * .NET
     * Java
     * Codegen.
     * Playwright inspector.
     * Trace Viewer.
     */

}
