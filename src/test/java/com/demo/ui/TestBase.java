package com.demo.ui;

import com.codeborne.selenide.Configuration;
import com.demo.ui.listener.ScreenshotListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 * Created by alpa on 3/20/18
 */
@Listeners(ScreenshotListener.class)
public class TestBase {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.seleniumhq.org";
    }


}
