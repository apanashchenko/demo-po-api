package com.demo.ui;

import com.codeborne.selenide.Condition;
import com.demo.ui.page.object.SeleniumHqPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alpa on 3/20/18
 */
public class SeleniumHqTest extends TestBase {

    @Test
    public void checkMainPage() {
        open(baseUrl);
        new SeleniumHqPage().checkMainPage();
    }

    @Test
    public void logoShouldBeVisible() {
        open(baseUrl);
        new SeleniumHqPage().bigLogo.shouldBe(Condition.visible);
    }

    @Test
    public void logoShouldNotBeVisible() {
        open(baseUrl);
        new SeleniumHqPage().bigLogo.shouldNotBe(Condition.visible);
    }


}
