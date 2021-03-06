package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleTest {
    Playwright playwright;

    @BeforeClass
    public void beforeClass() {
        playwright = Playwright.create();
    }

    @Test
    public void chromiumTest() {
        // dafult will be tested in chromium
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        System.out.println(page.title());
        Assert.assertEquals(page.title(), "Google");
        browser.close();
    }

    @Test
    public void chromeTest() {
        // setting up value in setChannel will launch respective browser
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        System.out.println(page.title());
        Assert.assertEquals(page.title(), "Google");
        browser.close();
    }

    @Test
    public void edgeTest() {
        // setting up value in setChannel will launch respective browser
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        System.out.println(page.title());
        Assert.assertEquals(page.title(), "Google");
        browser.close();
    }

    @Test
    public void firefoxTest() {
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        System.out.println(page.title());
        Assert.assertEquals(page.title(), "Google");
        browser.close();
    }

    @Test
    public void safariTest() {
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        System.out.println(page.title());
        Assert.assertEquals(page.title(), "Google");
        browser.close();
    }

    @AfterClass
    public void afterClass() {
        playwright.close();
    }

}
