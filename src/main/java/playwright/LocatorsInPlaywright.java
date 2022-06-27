package playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorsInPlaywright {
    public static void main(String[] args) throws InterruptedException {
        // Playwright instance
        Playwright playwright = Playwright.create();

        // Browser Instance
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Context - 1
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.google.com");

        // Locator - for single element
        // We can also pass simple test
        Locator signIn = page.locator("text = SIGN IN");
        signIn.click();

        System.out.println(page.title());

        // Context - 2
        BrowserContext browserContext2 = browser.newContext();
        Page page2 = browserContext2.newPage();
        page2.navigate("https://youtube.com");

        // Locator-Sign in
        // Multiple elements
        Locator signInYoutube = page2.locator("text = Sign In");
        int totalNumberOfElementsFound = signInYoutube.count();
        // Here it found only one but there can be cases where you have multiple
        System.out.println(totalNumberOfElementsFound);
        signInYoutube.first().click();

        // Kept it here just to see the output
        // This is not recommended way for wait
        Thread.sleep(5000);
        System.out.println(page2.title());

        // Context - 3
        BrowserContext browserContext3 = browser.newContext();
        // Page means tab
        Page page3 = browserContext3.newPage();
        page3.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        // Here it is capturing the collection : same as findElements in selenium
        Locator countryOptions = page3.locator("select#Form_submitForm_Country option");
        // total number of elements found
        System.out.println(countryOptions.count());

        // To print the country names/available options
        /*
         * for(int i=0; i< countryOptions.count(); i++){
         * String countryName = countryOptions.nth(i).textContent();
         * System.out.println(countryName);
         * }
         */
        // Using for each loop
        List<String> countryNamesInList = countryOptions.allTextContents();
        /*
         * for (var countryName : countryNamesInList) {
         * System.out.println(countryName);
         * }
         */
        countryNamesInList.forEach(countryName -> System.out.println(countryName));

        // countryOptions.first().click();

        // Kept it here just to see the output
        // This is not recommended way for wait
        Thread.sleep(5000);
        System.out.println(page3.title());

        // teardown
        browser.close();
        playwright.close();
    }
}
