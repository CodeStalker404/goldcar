package org.example.goldcar.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectVehiclePage {

    public static SelenideElement getElementByText(String text) {
        return $(byText(text));
    }

}
