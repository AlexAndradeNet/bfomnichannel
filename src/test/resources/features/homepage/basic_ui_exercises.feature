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
  Scenario: Validating Creation of a New Terminal in VHQ
    Given he created a new terminal for the location "April 19th Location"
    When he creates a new case for the company profile "April 19th test" in the location "April 19th Location"
    #Then he should see that the terminal is correctly created in VHQ
