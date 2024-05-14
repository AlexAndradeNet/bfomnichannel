# language: en
# encoding: utf-8

Feature: Creating new terminals
  As a User
  I want to test various basic exercises
  So that I can enhance my practical skills with foundational interactions

  Background: Login on Salesforce
    Given Abdul is logged in to Salesforce

    #=============================================================================

#  
#  #@HappyPath
#  Scenario: Validating Creation of a New Terminal in VHQ two
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | --None--                     | N/A                |
#      | Clerk/Server ID Label                | --None--                     | (**Calculated**)   |
#      | Default Terminal Settings            | RETAIL Set-up                | (**Calculated**)   |
#      | Ticket Number                        | --None--                     | DISABLED           |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Table Number                         | --None--                     | DISABLED           |
#      | Cashback                             | --None--                     | DISABLED           |
#      | Merchant Receipt Logo                | --None--                     | DISABLED           |
#      | Alphanumeric Invoice number          | --None--                     | DISABLED           |
#      | Terminal Type                        | Standalone                   | (**Calculated**)   |
#      | Tip at Time of Sale                  | --None--                     | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | DISABLED  |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | DISABLED  |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | DISABLED  |
#      | Semi-Integration   | DISABLED  |
#
#  #
#  #@AnotherPaths
#  Scenario: Create restaurant and clerk id and integrated terminal without special settings
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | Yes                          | N/A                |
#      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
#      | Default Terminal Settings            | Restaurant Set-up            | (**Calculated**)   |
#      | Ticket Number                        | Yes                          | ENABLED            |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Cashback                             | --None--                     | DISABLED           |
#      | Table Number                         | --None--                     | DISABLED           |
#      | Alphanumeric Invoice number          | --None--                     | DISABLED           |
#      | Merchant Receipt Logo                | --None--                     | DISABLED           |
#      | Tip at Time of Sale                  | --None--                     | (**Calculated**)   |
#      | Terminal Type                        | Integrated                   | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#    #Then he should see that the terminal "434-115-969" with TID "99001233" is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | ENABLED   |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | ENABLED   |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | ENABLED   |
#      | Semi-Integration   | ENABLED   |
#
#    #
#  #@AnotherPaths
#  Scenario: Create restaurant and clerk id and integrated terminal with special settings set to NO
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | Yes                          | N/A                |
#      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
#      | Default Terminal Settings            | Restaurant Set-up            | (**Calculated**)   |
#      | Ticket Number                        | Yes                          | ENABLED            |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Cashback                             | No                           | DISABLED           |
#      | Table Number                         | No                           | DISABLED           |
#      | Alphanumeric Invoice number          | No                           | DISABLED           |
#      | Merchant Receipt Logo                | No                           | DISABLED           |
#      | Tip at Time of Sale                  | No                           | (**Calculated**)   |
#      | Terminal Type                        | Integrated                   | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#    #Then he should see that the terminal "724-127-856" with TID "99001234" is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | ENABLED   |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | ENABLED   |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | ENABLED   |
#      | Semi-Integration   | ENABLED   |
#
#    #
#  #@AnotherPaths
#  Scenario: Create restaurant and clerk id and integrated terminal with special settings set to YES
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | Yes                          | N/A                |
#      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
#      | Default Terminal Settings            | Restaurant Set-up            | (**Calculated**)   |
#      | Ticket Number                        | Yes                          | ENABLED            |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Cashback                             | Yes                          | ENABLED            |
#      | Table Number                         | Yes                          | ENABLED            |
#      | Alphanumeric Invoice number          | Yes                          | ENABLED            |
#      | Merchant Receipt Logo                | Yes                          | ENABLED            |
#      | Tip at Time of Sale                  | Yes                          | (**Calculated**)   |
#      | Terminal Type                        | Integrated                   | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#    #Then he should see that the terminal "342-758-068" with TID "99001235" is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | ENABLED   |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | ENABLED   |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | ENABLED   |
#      | Semi-Integration   | ENABLED   |



#  #
#  #@AnotherPaths
#  Scenario: Create MOTO and clerk id and integrated terminal without special settings
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | Yes                          | N/A                |
#      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
#      | Default Terminal Settings            | MOTO                         | (**Calculated**)   |
#      | Ticket Number                        | Yes                          | ENABLED            |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Cashback                             | --None--                     | DISABLED           |
#      | Table Number                         | --None--                     | DISABLED           |
#      | Alphanumeric Invoice number          | --None--                     | DISABLED           |
#      | Merchant Receipt Logo                | --None--                     | DISABLED           |
#      | Tip at Time of Sale                  | --None--                     | (**Calculated**)   |
#      | Terminal Type                        | Integrated                   | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | ENABLED   |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | DISABLED  |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | DISABLED  |
#      | Semi-Integration   | ENABLED   |
#
#    #
#  #@AnotherPaths
#  Scenario: Create MOTO and clerk id and integrated terminal with special settings set to NO
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | Yes                          | N/A                |
#      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
#      | Default Terminal Settings            | MOTO                         | (**Calculated**)   |
#      | Ticket Number                        | Yes                          | ENABLED            |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Cashback                             | No                           | DISABLED           |
#      | Table Number                         | No                           | DISABLED           |
#      | Alphanumeric Invoice number          | No                           | DISABLED           |
#      | Merchant Receipt Logo                | No                           | DISABLED           |
#      | Tip at Time of Sale                  | No                           | (**Calculated**)   |
#      | Terminal Type                        | Integrated                   | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | ENABLED   |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | DISABLED  |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | DISABLED  |
#      | Semi-Integration   | ENABLED   |
#
#    #
#  #@AnotherPaths
#  Scenario: Create MOTO and clerk id and integrated terminal with special settings set to YES
#    Given he created a new terminal with the following values
#      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
#      | Location                             | April 19th Location          | N/A                |
#      | Company Profile                      | April 19th test              | N/A                |
#      | Make and Model                       | Verifone Android Model T650c | T650c              |
#      | Status                               | Submitted                    | N/A                |
#      | Communication Method                 | IP/SSL                       | N/A                |
#      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
#      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
#      | Clerk/Server ID Enablement           | Yes                          | N/A                |
#      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
#      | Default Terminal Settings            | MOTO                         | (**Calculated**)   |
#      | Ticket Number                        | Yes                          | ENABLED            |
#      | Terminal Auto Batch                  | Yes                          | ENABLED            |
#      | Auto Batch Time                      | 23:00                        | 23:00              |
#      | Cashback                             | Yes                          | ENABLED            |
#      | Table Number                         | Yes                          | ENABLED            |
#      | Alphanumeric Invoice number          | Yes                          | ENABLED            |
#      | Merchant Receipt Logo                | Yes                          | ENABLED            |
#      | Tip at Time of Sale                  | Yes                          | (**Calculated**)   |
#      | Terminal Type                        | Integrated                   | (**Calculated**)   |
#    When he creates a new case to deliver the new terminal
#    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
#      | VHQ_FIELD          | VHQ_VALUE |
#      | Clerk ID           | ENABLED   |
#      | Server ID          | DISABLED  |
#      | Accept Tips        | ENABLED   |
#      | RetailPullMode     | DISABLED  |
#      | RestaurantPushMode | DISABLED  |
#      | Semi-Integration   | ENABLED   |

#
  #@AnotherPaths
  Scenario: Create RETAIL Set-up and clerk id and integrated terminal without special settings
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | Yes                          | N/A                |
      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL Set-up                | (**Calculated**)   |
      | Ticket Number                        | Yes                          | ENABLED            |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Cashback                             | --None--                     | DISABLED           |
      | Table Number                         | --None--                     | DISABLED           |
      | Alphanumeric Invoice number          | --None--                     | DISABLED           |
      | Merchant Receipt Logo                | --None--                     | DISABLED           |
      | Tip at Time of Sale                  | --None--                     | (**Calculated**)   |
      | Terminal Type                        | Integrated                   | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | ENABLED   |
      | Server ID          | DISABLED  |
      | Accept Tips        | DISABLED  |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | ENABLED   |

    #
  #@AnotherPaths
  Scenario: Create RETAIL Set-up and clerk id and integrated terminal with special settings set to NO
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | Yes                          | N/A                |
      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL Set-up                | (**Calculated**)   |
      | Ticket Number                        | Yes                          | ENABLED            |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Cashback                             | No                           | DISABLED           |
      | Table Number                         | No                           | DISABLED           |
      | Alphanumeric Invoice number          | No                           | DISABLED           |
      | Merchant Receipt Logo                | No                           | DISABLED           |
      | Tip at Time of Sale                  | No                           | (**Calculated**)   |
      | Terminal Type                        | Integrated                   | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | ENABLED   |
      | Server ID          | DISABLED  |
      | Accept Tips        | DISABLED  |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | ENABLED   |

    #
  #@AnotherPaths
  Scenario: Create RETAIL Set-up and clerk id and integrated terminal with special settings set to YES
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | Yes                          | N/A                |
      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL Set-up                | (**Calculated**)   |
      | Ticket Number                        | Yes                          | ENABLED            |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Cashback                             | Yes                          | ENABLED            |
      | Table Number                         | Yes                          | ENABLED            |
      | Alphanumeric Invoice number          | Yes                          | ENABLED            |
      | Merchant Receipt Logo                | Yes                          | ENABLED            |
      | Tip at Time of Sale                  | Yes                          | (**Calculated**)   |
      | Terminal Type                        | Integrated                   | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | ENABLED   |
      | Server ID          | DISABLED  |
      | Accept Tips        | DISABLED  |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | ENABLED   |

    #
  #@AnotherPaths
  Scenario: Create RETAIL with Tip Set-up and clerk id and integrated terminal without special settings
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | Yes                          | N/A                |
      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL with Tip Set-up       | (**Calculated**)   |
      | Ticket Number                        | Yes                          | ENABLED            |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Cashback                             | --None--                     | DISABLED           |
      | Table Number                         | --None--                     | DISABLED           |
      | Alphanumeric Invoice number          | --None--                     | DISABLED           |
      | Merchant Receipt Logo                | --None--                     | DISABLED           |
      | Tip at Time of Sale                  | --None--                     | (**Calculated**)   |
      | Terminal Type                        | Integrated                   | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | ENABLED   |
      | Server ID          | DISABLED  |
      | Accept Tips        | ENABLED   |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | ENABLED   |

    #
  #@AnotherPaths
  Scenario: Create RETAIL with Tip Set-up and clerk id and integrated terminal with special settings set to NO
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | Yes                          | N/A                |
      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL with Tip Set-up       | (**Calculated**)   |
      | Ticket Number                        | Yes                          | ENABLED            |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Cashback                             | No                           | DISABLED           |
      | Table Number                         | No                           | DISABLED           |
      | Alphanumeric Invoice number          | No                           | DISABLED           |
      | Merchant Receipt Logo                | No                           | DISABLED           |
      | Tip at Time of Sale                  | No                           | (**Calculated**)   |
      | Terminal Type                        | Integrated                   | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | ENABLED   |
      | Server ID          | DISABLED  |
      | Accept Tips        | ENABLED   |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | ENABLED   |

    #
  #@AnotherPaths
  Scenario: Create RETAIL with Tip Set-up and clerk id and integrated terminal with special settings set to YES
    Given he created a new terminal with the following values
      | SALESFORCE                           | SF_VALUE                     | EXPECTED_VHQ_VALUE |
      | Location                             | April 19th Location          | N/A                |
      | Company Profile                      | April 19th test              | N/A                |
      | Make and Model                       | Verifone Android Model T650c | T650c              |
      | Status                               | Submitted                    | N/A                |
      | Communication Method                 | IP/SSL                       | N/A                |
      | Charge Equipment Cost incl. Shipping | Partner                      | N/A                |
      | Purchase or Rental                   | Purchase from Nuvei          | N/A                |
      | Clerk/Server ID Enablement           | Yes                          | N/A                |
      | Clerk/Server ID Label                | Clerk ID                     | (**Calculated**)   |
      | Default Terminal Settings            | RETAIL with Tip Set-up       | (**Calculated**)   |
      | Ticket Number                        | Yes                          | ENABLED            |
      | Terminal Auto Batch                  | Yes                          | ENABLED            |
      | Auto Batch Time                      | 23:00                        | 23:00              |
      | Cashback                             | Yes                          | ENABLED            |
      | Table Number                         | Yes                          | ENABLED            |
      | Alphanumeric Invoice number          | Yes                          | ENABLED            |
      | Merchant Receipt Logo                | Yes                          | ENABLED            |
      | Tip at Time of Sale                  | Yes                          | (**Calculated**)   |
      | Terminal Type                        | Integrated                   | (**Calculated**)   |
    When he creates a new case to deliver the new terminal
    Then he should see that the terminal is created correctly in VHQ, including the following calculated fields
      | VHQ_FIELD          | VHQ_VALUE |
      | Clerk ID           | ENABLED   |
      | Server ID          | DISABLED  |
      | Accept Tips        | ENABLED   |
      | RetailPullMode     | DISABLED  |
      | RestaurantPushMode | DISABLED  |
      | Semi-Integration   | ENABLED   |
