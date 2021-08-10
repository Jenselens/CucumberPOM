Feature: verifying hotel details

  Scenario Outline: Verifying adactin login with valid credentials
    Given user is on the adactin hotel page
    When User should enter "<username>" and "<password>"
    And User should enter "<location>","<hotel>","<roomtype>"and"<NoofRooms>"
    And User should select the hotel by click login button
    And user should enter "<first_name>","<last_name>","<address>","<cc_num>","<cc_type>","<cc_expmonth>","<cc_expyr>","<cc_ccv>"
    And user should get order id
    Then user should verify success message

    Examples: 
      | username      | password | location | hotel       | roomtype | NoofRooms | first_name | last_name | address | cc_num           | cc_type | cc_expmonth | cc_expyr | cc_ccv |
      | JeniferJoseph | WA4P6I   | Sydney   | Hotel Creek | Double   | 2 - Two   | Jenifer    | Joseph    | Chennai | 7299012723654320 | VISA    | March       |     2022 |    234 |
