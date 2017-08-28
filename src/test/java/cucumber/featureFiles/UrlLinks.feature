#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
#	I want to use this template for my feature file
#@tag1
#Scenario: Title of your scenario
#Given I want to write a step with precondition
#	And some other precondition
#When I complete action
#	And some other action
#	And yet another action
#Then I validate the outcomes
#	And check more outcomes
#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step
#Examples:
#    | name  |value | status |
#    | name1 |  5   | success|
#    | name2 |  7   | Fail   |
Feature: To check for all the hyperlinks present in Bugzilla main page

  Background: 
    Given User should be at Bugzilla Main page "http://localhost:5001/"

  Scenario: To check for links
    # Given User should be at Home page "http://localhost:5001/"
    When I click the link text and assert for the title
      | linkName | Title                          |
      | Home     | Bugzilla Main Page             |
      | New      | Log in to Bugzilla             |
      | Browse   | Components for TestProduct     |
      | Reports  | Reporting and Charting Kitchen |
    And I close the browser session
