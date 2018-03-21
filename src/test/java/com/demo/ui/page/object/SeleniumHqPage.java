package com.demo.ui.page.object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by alpa on 3/20/18
 */
public class SeleniumHqPage {

    public SelenideElement bigLogo = $("img[src='/images/big-logo.png']");
    private SelenideElement mainPage = $(".homepage.push");
    private SelenideElement projects = $("a[href='/projects/'][title]");
    private SelenideElement download = $("a[href='/download/'][title]");
    private SelenideElement documentation = $("a[href='/docs/'][title]");
    private SelenideElement support = $("a[href='/support/'][title]");

    @Step
    public void checkMainPage() {
        mainPage.shouldBe(visible);
    }

    @Step
    public void logoShouldBeVisible() {
        bigLogo.shouldBe(visible);
    }

    @Step
    public ProjectsPage goToProjects() {
        projects.click();
        return new ProjectsPage();
    }

    @Step
    public DownloadPage goToDownload() {
        download.click();
        return new DownloadPage();
    }

    @Step
    public DocumentationPage goToDocumentation() {
        documentation.click();
        return new DocumentationPage();
    }

    @Step
    public SupportPage goToSupport() {
        $("a[href='/support/'][title]").click();
        return new SupportPage();
    }

    @Step
    public AboutPage goToAbout() {
        support.click();
        return new AboutPage();
    }

}
