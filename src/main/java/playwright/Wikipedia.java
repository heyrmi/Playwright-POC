package playwright;


import com.microsoft.playwright.*;

import java.nio.file.Paths;


public class Wikipedia {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();


            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));

            // Open new page
            Page page = context.newPage();

            // Go to https://www.wikipedia.org/
            page.navigate("https://www.wikipedia.org/");

            // Click input[name="search"]
            page.locator("input[name=\"search\"]").click();

            // Fill input[name="search"]
            page.locator("input[name=\"search\"]").fill("Volcano");

            // Press Enter
            page.locator("input[name=\"search\"]").press("Enter");
            // assertThat(page).hasURL("https://en.wikipedia.org/wiki/Volcano");

            // Click text=How often would you like to donate? Just once Give monthly Select an amount (INR >> [aria-label="Close"]
            page.locator("text=How often would you like to donate? Just once Give monthly Select an amount (INR >> [aria-label=\"Close\"]").click();

            // Click .thumbimage >> nth=0
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://en.wikipedia.org/wiki/Volcano#/media/File:Andhika_bayu_nugraha-taman_nasional_bromo_tengger_semeru.jpg"), () ->
            page.waitForNavigation(() -> {
                page.locator(".thumbimage").first().click();
            });

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}