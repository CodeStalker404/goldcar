package org.example.goldcar.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.goldcar.enums.VehicleType;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    public static void selectVehicleType(VehicleType vehicleType) {
        switch(vehicleType) {
            case CAR:
                $(".ecw-vehicle-filter__options > .ecw-vehicle-filter__type--car").click();
                break;
            case TRUCK:
                $(".ecw-vehicle-filter__options > .ecw-vehicle-filter__type--truck").click();
                break;
            case LUXURY:
                $(".ecw-vehicle-filter__options > .ecw-vehicle-filter__type--luxury").click();
                break;
            default:
                throw new NoSuchElementException("There is no vehicle type with value " + vehicleType);
        }
    }

    public static void selectAgency(String inputText, String agencyName) {
        $(By.id("ecw-autocomplete-input__pickup-station")).setValue(inputText);
        $(By.xpath("//p[text()='" + agencyName + "']")).click();
    }

    public static void selectPickUpDate(LocalDate pickUpLD) {
        selectCalendarDate("pickup-datetime", pickUpLD);
    }

    public static void selectReturnDate(LocalDate pickUpLD) {
        selectCalendarDate("return-datetime", pickUpLD);
    }

    public static void selectFirstOpenHour() {
        $$(By.xpath("//div[@class='ecw-timepicker-wrapper__time']")).first().click();
    }

    public static void clickOnSearch() {
        $(".ecw-search-submit").click();
    }


    private static void selectCalendarDate(String calendarId, LocalDate pickUpLD) {
        String firstCalendarDate =
                $(By.xpath(
                    "//div[@id='" + calendarId + "']" +
                    "//div[@class='asd__month'][1]" +
                    "//td[contains(@class, 'asd__day--enabled')][1]"
                )).should(Condition.exist).attr("data-date");

        assert firstCalendarDate != null;

        LocalDate firstCalendarLD = LocalDate.parse(firstCalendarDate, DateTimeFormatter.ISO_DATE);

        int totalMonthsPickUp = pickUpLD.getYear() * 12 + pickUpLD.getMonthValue();
        int totalMonthsFirstCalendar = firstCalendarLD.getYear() * 12 + firstCalendarLD.getMonthValue();

        int timesToClickMonthButton = totalMonthsPickUp - totalMonthsFirstCalendar;

        SelenideElement monthButton =
                timesToClickMonthButton >= 0
                        ? $(".asd__change-month-button--next > button")
                        : $(".asd__change-month-button--previous > button");

        for(int i = 0; i < timesToClickMonthButton; i++) {
            monthButton.click();
        }

        String pickUpDate = pickUpLD.format(DateTimeFormatter.ISO_DATE);
        $("button[date='" + pickUpDate + "']").click();
    }

}
