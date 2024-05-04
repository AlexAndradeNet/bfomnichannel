# language: en
# encoding: utf-8

Feature: Practicing Basic User Interactions
  As a User
  I want to test various basic exercises
  So that I can enhance my practical skills with foundational interactions

  Background: Login on Salesforce
    Given Alexander is logged in to Salesforce

    #=============================================================================

  #@skip
  Scenario: Verifying the Search bar is visible on the landing page
    When he is on the landing page
    Then he should see the Search bar is visible
