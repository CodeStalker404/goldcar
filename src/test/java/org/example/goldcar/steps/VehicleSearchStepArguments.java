package org.example.goldcar.steps;

import io.cucumber.java.ParameterType;
import org.example.goldcar.enums.VehicleType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VehicleSearchStepArguments {

    @ParameterType("CAR|TRUCK|LUXURY")
    public VehicleType vehicleType(String vehicleType) {
        return VehicleType.valueOf(vehicleType);
    }

    @ParameterType(".*")
    public LocalDate localDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

}
