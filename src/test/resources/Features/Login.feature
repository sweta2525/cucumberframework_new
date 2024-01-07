@laxman
Feature: Validate all login fuctionality

Background:
Given user should on login page

@madan
Scenario: TC01
When user enters the credentials
And click on login button
Then user should be navigated to home page
And user cal validate logout link
And close browser

@madan
Scenario: TC02
When user enters the credentials
And click on login button
Then user should validate error message
And close browser

Scenario Outline: test valid login feature with multiple parameters
When user enters "<userid>" and "<password>"
And click on login button
Then user should be navigated to home page
And user cal validate logout link
And close browser
Examples:
|userid | password |
|rutuja | pink |
|Priyanka | blue|
|Laxman | white|

@lead
Scenario: Create multiple leads
When user enters the valid credentials
And click on login button
Then user should be navigated to home page
When user creates the lead with lname "<lname>" and company "<company>"
|lname | company|
|Modi | BJP|
|Madan | Google|
|Laxman | Microsoft|
Then lead should be created succeessfully
And click on logout
And close browser

