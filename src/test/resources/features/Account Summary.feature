Feature: Navigating to Account Summary Page
Background:
  Given the user is logged in
  Scenario: Account summary title
    Then the user should see the title "Zero – Account Summary"

    Scenario: Account types
      Then Account summary page should have to following account types
    |Cash Accounts       |
    |Investment Accounts |
    |Credit Accounts     |
    |Loan Accounts       |

      Scenario: Credit accounts table columns
        Then The user should see the columns under the Credit Accounts table
          |Account    |
          |Credit Card|
          |Balance    |
