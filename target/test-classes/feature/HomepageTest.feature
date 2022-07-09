@one
Feature: Homepage Test cases

Background:
When browser is invoked
Then prerequisites are set

Scenario: Check text , number of links and header
Given user navigates to the url "https://www.amazon.com"
When user moves the cursor to hello signin button
Then Yourlist ands Youraccount text should be present
And Yourlist should have 12 links
And Youraccount should have 17 links
And Header should have 5 links
And header links should have correct texts 
And close the browser













