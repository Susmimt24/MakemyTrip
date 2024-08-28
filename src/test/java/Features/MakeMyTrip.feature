Feature: Make my trip application
  I want to use this template for my feature file
  
  @hotelsearch
  Scenario Outline:  Make my trip Hotel search
    Given User is navigated to MakemyTrip url
    When user click on "<Tab>" Tab
    When user entered "<Destination>"
    Then user entered "<CheckInDate>" and "<CheckOutDate>" dates
    Then select the "<Rooms>" and "<Adults>" and "<Children>"
    Then click on Hotel Search
    Then Print all hotels and its price
    Then select the hotel with price range "<LowerPrice>" and "<HigherPrice>"
    Then Select the room
    Then Review Booking
    Then Enter details in Payment Page

    Examples: 
    |Tab  | Destination | CheckInDate| CheckOutDate| Rooms | Adults | Children | LowerPrice | HigherPrice |
    |Hotels | Chennai | 5 January2025| 9 January2025| 3| 4 |     3 |  15000 | 21000|
    |Hotels | Kochi   | 7 January2025| 8 January2025| 1| 1 |     0 |  6000 | 8000|
      
       
 @flightsearch
  Scenario Outline:  Make my trip flight search
    Given User is navigated to MakemyTrip url
    When user entered "<From>" and "<To>" places
    Then user entered "<FromDate>" and "<ToDate>"
    Then select the "<travellers>" and "<travellerClass>"
    Then click on Search

    Examples: 
      | From | To | FromDate| ToDate| travellers | travellerClass |
      |Kochi | Chennai | 5 January 2025 | 10 April2025| 2| Premium Economy |
      |Goa | Mumbai | 9 March 2025 | 14 March 2025| 3 | Economy |
  