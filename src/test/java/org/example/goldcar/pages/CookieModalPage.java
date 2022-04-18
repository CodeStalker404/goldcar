package org.example.goldcar.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CookieModalPage {

    public static void acceptCookies() {
        $(By.id("didomi-notice-agree-button")).click();
    }

    public static void rejectCookies() {
        $(By.id("didomi-notice-disagree-button")).click();
    }

}
