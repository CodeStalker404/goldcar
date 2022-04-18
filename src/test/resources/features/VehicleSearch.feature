Feature: Vehicle search

  Scenario: Search a vehicle for a specific agency and date
    Given I open "https://www.europcar.es/es-es"
    And I accept the cookies
    When I select the vehicle type CAR
    And I type "ALC", picking the agency "Alicante Aeropuerto"
    And I select the pick up date 01-08-2022 for any hour
    And I select the return date 08-08-2022 for any hour
    And I click on Buscar
    Then the text "SEAT LEON" is visible at the availability page
