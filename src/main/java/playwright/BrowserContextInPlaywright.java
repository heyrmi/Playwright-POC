package playwright;

import com.microsoft.playwright.*;

public class BrowserContextInPlaywright {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Context one
        BrowserContext context1 = browser.newContext();
        Page page1 = context1.newPage();
        page1.navigate("https://www.google.com/");
        System.out.println(page1.title());

        // Context two
        BrowserContext context2 = browser.newContext();
        Page page2 = context2.newPage();
        page2.navigate("https://www.amazon.in");
        System.out.println(page2.title());

        // tear down
        browser.close();
        playwright.close();

        /**
         * try (Playwright playwright = Playwright.create()) {
         * BrowserType chromium = playwright.chromium();
         * // Create a Chromium browser instance
         * Browser browser = chromium.launch();
         * // Create two isolated browser contexts
         * BrowserContext userContext = browser.newContext();
         * BrowserContext adminContext = browser.newContext();
         * // Create pages and interact with contexts independently
         * 
         * Page page1 = userContext.newPage();
         * page1.navigate("https://www.google.com/");
         * System.out.println(page1.title());
         * 
         * Page page2 = adminContext.newPage();
         * page2.navigate("https://www.amazon.in");
         * System.out.println(page2.title());
         */
    }
}
