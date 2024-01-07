Feature: lead functionality

Background:
Given user should on login page


@Sweta
Scenario Outline: <TCName>
When user enters the credentials
And click on login button
Then user should be navigated to home page
When user creates the lead with lname and company
Then lead should be created succeessfully
And click on logout
And close browser
Examples:
|TCName|
|TC03|
|TC04|
|TC05|