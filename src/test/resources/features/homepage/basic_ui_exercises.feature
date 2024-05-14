# language: en
# encoding: utf-8

Feature: Creating new terminals
  As a User
  I want to test various basic exercises
  So that I can enhance my practical skills with foundational interactions

  Background: Login on Salesforce
    Given Abdul is logged in to Salesforce

    #=============================================================================


  #Scenario: Validating Creation of a New Terminal in VHQ
#  Scenario Outline: Validating Creation of a New Terminal in VHQ
#    Given he created a new terminal for the location "April 19th Location" and Default Terminal Settings to "<Default_Terminal_Settings>" and Tip at Time of Sale "<Tip_at_Time_of_Sale>"
#    When he creates a new case for the company profile "April 19th test" in the location "April 19th Location"
#    #Then he should see that the terminal is correctly created in VHQ by serial "414-463-067" and TID "99001213"
#    Then he should see that the terminal is correctly created in VHQ
#    Examples:
#      | Default_Terminal_Settings | Tip_at_Time_of_Sale |
#      | RETAIL Set-up             | --None--            |
#      | RETAIL Set-up             | Yes                 |
#      | RETAIL Set-up             | No                  |
#      | RETAIL with Tip Set-up    | --None--            |
#      | RETAIL with Tip Set-up    | Yes                 |
#      | RETAIL with Tip Set-up    | No                  |
#      | Restaurant Set-up         | --None--            |
#      | Restaurant Set-up         | Yes                 |
#      | Restaurant Set-up         | No                  |
#      | MOTO                      | --None--            |
#      | MOTO                      | Yes                 |
#      | MOTO                      | No                  |


  #@skip
  Scenario: Validating Creation of a New Terminal in VHQ two
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | --None--                     | N/A                |
      | Clerk/Server ID Label                | --None--                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL Set-up                | (**Calculated**)   |
      | Ticket Number                        | --None--                     | DISABLED           |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Table Number                         | --None--                     | DISABLED           |
      | Cashback                             | --None--                     | DISABLED           |
      | Merchant Receipt Logo                | --None--                     | DISABLED           |
      | Alphanumeric Invoice number          | --None--                     | DISABLED           |
      | Terminal Type                        | Standalone                   | (**Calculated**)   |
      | Tip at Time of Sale                  | --None--                     | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | DISABLED  |
      | Server ID          | DISABLED  |
      | Accept Tips        | DISABLED  |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | DISABLED  |
