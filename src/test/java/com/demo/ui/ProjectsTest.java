package com.demo.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.demo.ui.page.object.SeleniumHqPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alpa on 3/20/18
 */
public class ProjectsTest extends TestBase {

    @Test
    public void checkProjectHeader() {
        open(baseUrl);
        new SeleniumHqPage()
                .goToProjects()
                .header.shouldHave(Condition.text("Selenium Projects"));
    }

    @Test
    public void checkProjectList() {
        open(baseUrl);
        new SeleniumHqPage()
                .goToProjects()
                .projectsMenu
                .shouldHave(CollectionCondition.exactTexts("Selenium WebDriver", "Selenium Grid",
                "Selenium IDE", "Selenium Remote Control"));
    }

}
