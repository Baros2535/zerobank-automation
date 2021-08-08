Feature: Navigating to Account Activity Page

  Background:
    Given the user is logged in
    When the user navigates to "Account Activity" Page


  Scenario: Account Activity Title
      Then the user should see the title "Zero - Account Activity"

  Scenario: Account dropdown default value
    Then Account drop down should have "Savings" selected

  Scenario: Account dropdown options
    Then  Account drop down should have the following options
      |Savings|
      |Checking|
      |Loan    |
      |Credit Card|
      |Brokerage  |

  Scenario: Transactions columns
    Then  Transactions table should have column names
      |Date|
      |Description|
      |Deposit    |
      |Withdrawal|



