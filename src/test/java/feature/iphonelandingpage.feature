@two
Feature: iphonelandingpage Test cases

Background:
When browser is invoked
Then prerequisites are set

Scenario: Check the no of checkbox in brandcolumn, search result and the no of links in footer
Given user navigates to the url "https://www.amazon.com"
When user searches for "iphone"
Then iphonelanding page should have 12 checkbox in brand column
And search result should be "iphone"
And footer should have 36 links
And close the browser












