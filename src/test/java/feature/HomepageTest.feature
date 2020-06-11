@one
Feature: Homepage Test cases

Scenario: Check text , number of links and header
Given user navigates to the url "https://www.amazon.com" and prerequisites are set
When user moves the cursor to hello signin button
Then Yourlist ands Youraccount text should be present
And Yourlist should have 12 links
And Youraccount should have 17 links
And Header should have 5 links
And header links should have correct texts 
And close the browser











