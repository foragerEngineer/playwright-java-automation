package m.sierra.PageUtils;

import com.microsoft.playwright.Playwright;

public class TagNameEngine {

    private final Playwright playwright;

    public TagNameEngine(Playwright playwright) {
        this.playwright = playwright;
    }

    // Must be a script that evaluates to a selector engine instance.  The script is evaluated in the page context.
    String createTagNameEngine = "{\n" +
            "  // Returns the first element matching given selector in the root's subtree.\n" +
            "  query(root, selector) {\n" +
            "    return root.querySelector(selector);\n" +
            "  },\n" +
            "\n" +
            "  // Returns all elements matching given selector in the root's subtree.\n" +
            "  queryAll(root, selector) {\n" +
            "    return Array.from(root.querySelectorAll(selector));\n" +
            "  }\n" +
            "}";

    private void registerTagNameEngine() {
        // Register the engine. Selectors will be prefixed with "tag=".
        playwright.selectors().register("tag", createTagNameEngine);
    }

}
