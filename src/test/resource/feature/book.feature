Feature: Booking

  Scenario Outline: LogInBooking
    Given I LogIn web as <username> and <password>
    When  I select to open <option>
    Examples: