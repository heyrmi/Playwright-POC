package tests;

import com.microsoft.playwright.*;
import org.assertj.core.api.Assertions;

import java.io.IOException;

public class ExampleTest {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        System.out.println(page.title());
        //AssertJ assertion
        Assertions.assertThat(page.title().equalsIgnoreCase("Google!"));
    }
}
