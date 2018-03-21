package com.demo.ui.page.object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by alpa on 3/20/18
 */
public class ProjectsPage {

    public SelenideElement header = $("#mainContent>h2");
    public ElementsCollection projectsMenu = $$(".bigMenu>h3>a");



}
