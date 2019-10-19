#Author: jaivyas@98gmail.com
#Keywords Summary : Selenium_BDD_framework
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
	
	Feature: To check sucessfull sign-in to facebook and navigate to home
				To check sucessfull sign-in to facebook and navigate to profile
				
  I want to use this template for my feature file

  @navigatetohome
  Scenario: To verify if the user is succesfully able to login or not
    Given invokebrowser
    And navigate to facebook
    When enter Credentials
    Then navigate to home
    
	@navigatetoprofile
	Scenario: To verify if the user is succefully able to navigate to profile page
	Given invokebrowser
	And navigate to facebook
	When enter Credentials
	Then navigate to profile
	
	@collectallhyperlinks
	Scenario: To verify if all the links on the page is clickable or not
	Given invokebrowser
	And navigate to google
	Then collecthyperlinks