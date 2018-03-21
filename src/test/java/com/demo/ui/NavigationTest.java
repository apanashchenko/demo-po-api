package com.demo.ui;

import com.demo.ui.page.object.SeleniumHqPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alpa on 3/20/18
 */
public class NavigationTest extends TestBase {


    @Test
    public void projectsPageShouldOpen() {
        open(baseUrl);
        new SeleniumHqPage().goToProjects();
    }

    @Test
    public void downloadsPageShouldOpen() {
        open(baseUrl);
        new SeleniumHqPage().goToDownload();
    }

    @Test
    public void documentationPageShouldOpen() {
        open(baseUrl);
        new SeleniumHqPage().goToDocumentation();
    }

    @Test
    public void supportPageShouldOpen() {
        open(baseUrl);
        new SeleniumHqPage().goToSupport();
    }

    @Test
    public void aboutPageShouldOpen() {
        open(baseUrl);
        new SeleniumHqPage().goToAbout();
    }

}
