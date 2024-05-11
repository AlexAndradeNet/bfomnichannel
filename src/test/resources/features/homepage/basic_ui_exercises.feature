# language: en
# encoding: utf-8

Feature: Creating new terminals
  As a User
  I want to test various basic exercises
  So that I can enhance my practical skills with foundational interactions

  Background: Login on Salesforce
    Given Abdul is logged in to Salesforce

    #=============================================================================

  #@skip
  #Scenario: Validating Creation of a New Terminal in VHQ
  Scenario Outline: Validating Creation of a New Terminal in VHQ
    #Given he created a new terminal for the location "April 19th Location" and Default Terminal Settings to "<Default_Terminal_Settings>" and Tip at Time of Sale "<Tip_at_Time_of_Sale>"
    #When he creates a new case for the company profile "April 19th test" in the location "April 19th Location"
    Then he should see that the terminal is correctly created in VHQ by serial "414-463-067" and TID "99001213"
    Examples:
      | Default_Terminal_Settings | Tip_at_Time_of_Sale |
      | RETAIL Set-up             | --None--            |
      | RETAIL Set-up             | Yes                 |
      | RETAIL Set-up             | No                  |
      | RETAIL with Tip Set-up    | --None--            |
      | RETAIL with Tip Set-up    | Yes                 |
      | RETAIL with Tip Set-up    | No                  |
      | Restaurant Set-up         | --None--            |
      | Restaurant Set-up         | Yes                 |
      | Restaurant Set-up         | No                  |
      | MOTO                      | --None--            |
      | MOTO                      | Yes                 |
      | MOTO                      | No                  |
