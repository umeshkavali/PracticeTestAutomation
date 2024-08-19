Feature: Positive Login Test

  Scenario Outline: Checking with Valid and Invalid Credentials
    Given User navigates to Login Page
    Then User should enter the username as "<email>"
    Then User should enter the password as "<password>"
    And User should click on Submit button
    Then User should verify the URL as practicetestautomation logged in successfully
    Then User should verify the text as Congratulations or successfully logged in
    And User should verify the Logout displayed on the page
    And User should click on Logout button
    Then Finally User should click on close the browser

    Examples: 
      | email         | password          |
      | student       | Password123       |
      #| inCorrectUser | Password123       |
      #| student       | inCorrectPassword |
