Feature: Title of your feature
  I want to use this template for my feature file
      
 @iphonesearch
  Scenario Outline:  Amazon web application automation for Iphone
    Given User is navigated to url
    When search for "<searchItem>"
    Then display all iphones
    Then display only iphone with "<condition>"

    Examples: 
      | searchItem | condition |
      |iphone | 128 GB |
       
  
 @news
Scenario: Print world news
    Given User is navigated to url "https://www.news.google.com/"
    When Click on "India" Tab.
    Then Display News of first "5" sections
    When Click on "World" Tab.
    Then Display News of first "3" sections


 @datePick
Scenario: Print Date format
    Given User is navigated to url "https://jqueryui.com/datepicker/"
    Then Print current month WeekEnd Dates.
    Then Print the Current Date in format DD-MMMMM-YYYY
    