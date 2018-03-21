package com.demo.ui.listener;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.newInputStream;

/**
 * Created by alpa on 3/20/18
 */
public class ScreenshotListener extends AllureTestNg {

    @Override
    public void onTestFailure(final ITestResult result) {
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(final ITestResult result) {
        takeScreenshot();
    }


    private void takeScreenshot() {
        File screen = Screenshots.takeScreenShotAsFile();
        try {
            Allure.addAttachment(screen.getName(), newInputStream(screen.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
