Feature: Registration

  # The first example has two steps
  @Autom123
  @important
  Scenario: login-verfication wrong password
  Given the user navigate to the registration page
    When the user type wrong email and click submit
    Then the error msg appear "Geben Sie Ihre E-Mail-Adresse oder Mobiltelefonnummer eintrtrtrtrtrt"
    

 Scenario Outline: login-verfication wrong second
  Given the user navigate to the registration page <start>
    When the user type wrong email and click submit <eat>
    Then the error msg appear <left>

     Examples:
    | start | eat | left |
    |    12 |   5 |    7 |
    |    20 |   5 |   15 |