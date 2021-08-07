Feature:  Navigating to Pay Bills Page

  Background:
    Given the user is logged in
    When the user navigates to "Pay Bills" Page

  Scenario: Pay Bills Title
    Then the user should see the title "Zero – Pay Bills"

    Scenario: Successful Pay operation
      And the user enters the following information
     |Payee|Bank of America|
      |Account|Savings|
      |Amount|45|
      |Date|2021-08-15|
      |Description|other|
      And the user clicks the Pay button
      Then the user should see the message as "The payment was successfully submitted"

  Scenario: Unsuccessful Pay operation without amount
    And the user enters the following information
      |Payee|Bank of America|
      |Account|Savings|
      |Amount||
      |Date|2021-08-15|
      |Description|other|
    And the user clicks the Pay button
    Then the user should see the message as "Please fill out this field message!"


  Scenario: Unsuccessful Pay operation without date
    And the user enters the following information
      |Payee|Bank of America|
      |Account|Savings|
      |Amount|45|
      |Date||
      |Description|other|
    And the user clicks the Pay button
    Then the user should see the message as "Please fill out this field message!"

  Scenario: Unsuccessful Pay operation invalid date
    And the user enters the following information
      |Payee|Bank of America|
      |Account|Savings|
      |Amount|45|
      |Date|invalid|
      |Description|other|
    And the user clicks the Pay button
    Then the user should not see the message as "The payment was successfully submitted"

  Scenario: Unsuccessful Pay operation invalid amount
    And the user enters the following information
      |Payee|Bank of America|
      |Account|Savings|
      |Amount|invalidAmount*|
      |Date|2021-08-15|
      |Description|other|
    And the user clicks the Pay button
    Then the user should not  see the message as "The payment was successfully submitted"
